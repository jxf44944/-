package com.service.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ILimitsDao;
import com.dao.IRoleAndLimitsDao;
import com.dao.IRolesDao;
import com.entity.TActer;
import com.entity.TLimit;
import com.entity.TMiddle;
import com.service.IRoleService;

/***
 * 角色service实现
 * @author Feng
 *
 */
@Service("roleService")
public class RolesServiceImpl implements IRoleService {

	private IRolesDao roleDao;
	private IRoleAndLimitsDao roAndLiDao;
	@SuppressWarnings("unused")
	private ILimitsDao limitsDao;
	
	@Resource(name="limitsDao")
	public void setLimitsDao(ILimitsDao limitsDao) {
		this.limitsDao = limitsDao;
	}
	public IRolesDao getRoleDao() {
		return roleDao;
	}
	@Resource(name="roleDao")
	public void setRoleDao(IRolesDao roleDao) {
		this.roleDao = roleDao;
	}
	public IRoleAndLimitsDao getRoAndLiDao() {
		return roAndLiDao;
	}
	@Resource(name="roleandlimitsDao")
	public void setRoAndLiDao(IRoleAndLimitsDao roAndLiDao) {
		this.roAndLiDao = roAndLiDao;
	}
	
	/**新增
	 * 增加角色的同时，要将角色的权限记录同时插入角色菜单中间表
	 * 
	 * */
	public boolean insRoles(TActer role , String[] limitArr){
		boolean flag = false;
		if(roleDao.insert(role)){
			
		if(limitArr.length>0){	
		  for(String limitId : limitArr){
			  int id = Integer.parseInt(limitId);
			  TMiddle roandl = new TMiddle();
			TLimit limits = new TLimit();
			limits.setLimitid(id);
			roandl.setTLimit(limits);
			roandl.setTActer(role);
	//		System.out.println(limitId+"---------"+role.getRoleId());
			if(roAndLiDao.insert(roandl)){
				flag= true;
			}else{
				return false;
			}
		  }
		  return flag;
		}
			return true;
		}else{
			return false;
		}
	}
	
	/**删除
	 * 应该先删除角色权限中间表，用户表关联的记录，再删除角色 
	 * 因此需要先调用 相应的dao方法
	 * */
	@SuppressWarnings("unchecked")
	public boolean delRoles(TActer role){
		boolean flag = false;
		
		TActer retRole = this.getRoles(role);
		
			Iterator<TMiddle> iter = retRole.getTMiddles().iterator();
	System.out.println("here is RoleServiceImpl 84 here is OK ");
			while(iter.hasNext()){
			System.out.println("here is RoleServiceImpl 86 here is OK ");
			TMiddle randl = iter.next();
				if(roAndLiDao.delete(randl)){
					flag = true;
				}
				if(flag==false){
					return false;
				}
				
			}
			
			if(roleDao.delete(retRole)){
				System.out.println("here is deleteRole 104 is ok");
				return true;
		}else{
			return flag;
		}
	}
	
	/**修改
	 * 对于角色 权限，应该先将原来的权限删除，再重新的插入
	 * 
	 * **/
	public boolean uptRoles(TActer role, String[] limitArr){
		boolean flag = false;
		List<TMiddle> limitList = roAndLiDao.list(" where acterid=" + role.getActerid());	
		if(roleDao.update(role)){
			for(TMiddle randl : limitList){
				flag = roAndLiDao.delete(randl);
				if(flag==false){
					return false;
				}
			}			
			
			if(limitArr.length>0){	
				  for(String limitId : limitArr){
					  int id = Integer.parseInt(limitId);
					  TMiddle roandl = new TMiddle();
					TLimit limits = new TLimit();
					limits.setLimitid(id);
					roandl.setTLimit(limits);
					roandl.setTActer(role);
			//		System.out.println(limitId+"---------"+role.getRoleId());
					if(roAndLiDao.insert(roandl)){
						flag= true;
					}else{
						return false;
					}
				  }
			}
			return true;
		}else{
			return false;
		}
	}
	
	/**查找单条记录信息**/
	@SuppressWarnings("unchecked")
	public TActer getRoles(TActer role){
	
		TActer retRole = roleDao.getRole(role);
		List<TMiddle> limitList = roAndLiDao.list(" where acterid=" + role.getActerid());
		Set limitSet = new HashSet(limitList);//将角色中的菜单列表封装到set中，再封装到角色中
		retRole.setTMiddles(limitSet);
		
		return retRole;
	}
	
	/**查找所有的角色列表
	 * */
	public List<TActer> list(String sql){
		
		List<TActer> list = roleDao.list();
		
		return list;
		
	}
	

	
	
}

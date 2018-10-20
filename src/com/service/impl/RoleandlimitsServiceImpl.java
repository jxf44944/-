package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ILimitsDao;
import com.dao.IRoleAndLimitsDao;
import com.entity.TLimit;
import com.entity.TMiddle;
import com.service.IRoleandlimitsService;

/***
 * 角色 菜单 中间表service实现
 * @author Feng
 * 2014-02-17
 */
@Service("roleandlimitsService")
public class RoleandlimitsServiceImpl implements IRoleandlimitsService {

	private IRoleAndLimitsDao roleAndLimitsDao;
	private ILimitsDao limitDao;
	public ILimitsDao getLimitDao() {
		return limitDao;
	}
	@Resource(name="limitsDao")
	public void setLimitDao(ILimitsDao limitDao) {
		this.limitDao = limitDao;
	}

	
	public IRoleAndLimitsDao getRoleAndLimitsDao() {
		return roleAndLimitsDao;
	}
	@Resource(name="roleandlimitsDao")
	public void setRoleAndLimitsDao(IRoleAndLimitsDao roleAndLimitsDao) {
		this.roleAndLimitsDao = roleAndLimitsDao;
	}

	
	/**新增*/
	public boolean insRoleandlimits(TMiddle randl){
		if(roleAndLimitsDao.insert(randl)){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**删除*/
	public boolean delRoleandlimits(TMiddle randl){
		if(roleAndLimitsDao.delete(randl)){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**修改**/
	public boolean uptRoleandlimits(TMiddle randl){
		if(roleAndLimitsDao.update(randl)){
			return true;
		}else{
			return false;
		}
		
	}
	
	/**查找单条记录信息**/
	public TMiddle getRoleandlimits(TMiddle randl){
	//	Roleandliimit roleLimits = roleAndLimitsDao.getRoleLimits(randl);
		System.out.println("here is RoleandLimitsService 65  , the method getRoleandlimits is not complate;");
		
		return null;
		
	}
	
	/**查找列表
	 * */
	public List<TMiddle> list(String sql){
		
		System.out.println("here is RoleandlimitsService 75 ,the method list() is ok;");
		List<TMiddle> list = roleAndLimitsDao.list(sql);
		List<TMiddle> retlist = new ArrayList<TMiddle>();
		for(TMiddle rolelimit : list){
			TLimit limit = new TLimit();
			limit.setLimitid(rolelimit.getTLimit().getLimitid());
			TLimit retLimit = limitDao.getMsg(limit);
			rolelimit.setTLimit(retLimit);
			retlist.add(rolelimit);
		}
		
		return retlist;
		
	}
	
	
	
}

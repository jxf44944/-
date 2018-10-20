package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IRolesDao;
import com.dao.IUsersDao;
import com.entity.TActer;
import com.entity.TUser;
import com.service.IUsersService;
@Service(value="usersService")
public class UsersServiceImpl implements IUsersService {

	private IUsersDao userdao;
	@Resource(name="usersDao")
	public void setUserdao(IUsersDao userdao) {
		this.userdao = userdao;
	}

	public boolean insUsers(TUser cli) {
		if(userdao.insert(cli)){
			return true;
		}else{
			return false;
		}
	}

	public boolean delUsers(TUser cli) {
		if(userdao.delete(cli)){
			return true;
		}else{
			return false;
		}
	}

	public boolean uptUsers(TUser cli) {
		if(userdao.update(cli)){
			return true;
		}else{
			return false;
		}
	}

/*	public Users getUsers(Users cli) {
		Users u=userdao.getUsers(cli);
		return u;
	}*/

	public List<TUser> searchUsers(TUser cli) {
		List<TUser> list=null;
		if(cli==null){
			list=userdao.selectAll();
		}else{
			list=userdao.select(cli);
		}
		return list;
	}

	
	
	//	private IDeptsDao deptDao;
		private IRolesDao roleDao;
	/*	
		public IUsersDao getUserDao() {
			return userDao;
		}
		@Resource(name="usersDao")
		public void setUserDao(IUsersDao userDao) {
			this.userDao = userDao;
		}*/
/*		public IDeptsDao getDeptDao() {
			return deptDao;
		}
		@Resource(name="deptsDao")
		public void setDeptDao(IDeptsDao deptDao) {
			this.deptDao = deptDao;
		}*/
		public IRolesDao getRoleDao() {
			return roleDao;
		}
		@Resource(name="roleDao")
		public void setRoleDao(IRolesDao roleDao) {
			this.roleDao = roleDao;
		}
		
		
		
		
		
		
		
		
		/**查找单条记录信息**/
		public TUser getUsers(TUser user){
			TUser retUser = userdao.getUser(user);
			//Depts userDept = deptDao.getDept(retUser.getDepts());//调用 DeptDao的方法，获取用户所属的部门
			TActer userRole = roleDao.getRole(retUser.getTActer());//调用RolesDao的方法，获取用户所属的角色
			//retUser.setDepts(userDept);//设置用户所属的部门
			retUser.setTActer(userRole);//设置用户的角色 
			return retUser;
			
		}
		
		/**查找列表
		 * */
		public List<TUser> listAll(){
			List<TUser> userList = userdao.list(null);
			List<TUser> retList = new ArrayList<TUser>();
			for(TUser user : userList){
				//Depts userDept = deptDao.getDept(user.getDepts());//调用 DeptDao的方法，获取用户所属的部门
				TActer userRole = roleDao.getRole(user.getTActer());//调用RolesDao的方法，获取用户所属的角色
				//user.setDepts(userDept);//设置用户所属的部门
				user.setTActer(userRole);//设置用户的角色 
				retList.add(user);
			}
			
	 		return retList;
		//	return userList;
		}

		/**按条件查询列表
		 * */
		public List<TUser> list(String sql){
			List<TUser> userList = userdao.list(sql);
			List<TUser> retList = new ArrayList<TUser>();
			for(TUser user : userList){
				//Depts userDept = deptDao.getDept(user.getDepts());//调用 DeptDao的方法，获取用户所属的部门
				TActer userRole = roleDao.getRole(user.getTActer());//调用RolesDao的方法，获取用户所属的角色
				//user.setDepts(userDept);//设置用户所属的部门
				user.setTActer(userRole);//设置用户的角色 
				retList.add(user);
			}
			
	 		return retList;
		//	return userList;
		}
		
		/***用户登录验证*/
		public TUser checkUser(TUser user){
			String sql="  where username='"+user.getUsername() +"'  and password='"+user.getPassword()+"'";
			List<TUser> userList = userdao.list(sql);//理论上来说应该是只有一个用户被封装返回
			if(userList.size()>0){
				TUser retUser = userList.get(0);
				//Depts userDept = deptDao.getDept(retUser.getDepts());//调用 DeptDao的方法，获取用户所属的部门
				TActer userRole = roleDao.getRole(retUser.getTActer());//调用RolesDao的方法，获取用户所属的角色
				//retUser.setDepts(userDept);//设置用户所属的部门
				retUser.setTActer(userRole);//设置用户的角色 
				
				return retUser;
				//return userList.get(0);
			}
			
	 		return null;		
		}
		
	
	
}

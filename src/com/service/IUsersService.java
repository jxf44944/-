package com.service;

import java.util.List;

import com.entity.TUser;

public interface IUsersService {
   
    
     public List<TUser> searchUsers(TUser cli);
     
     
     

 	/**新增*/
 	public boolean insUsers(TUser user);
 	
 	/**删除*/
 	public boolean delUsers(TUser user);
 	
 	/**修改**/
 	public boolean uptUsers(TUser user);
 	
 	/**查找单条记录信息**/
 	public TUser getUsers(TUser user);
 	
 	/**按条件查找所有符合的记录
 	 * */
 	public List<TUser> list(String sql);
 	
 	/**查询所有的用户*/
 	public List<TUser> listAll();
 	
 	/***用户登录验证*/
 	public TUser checkUser(TUser user);
     
}

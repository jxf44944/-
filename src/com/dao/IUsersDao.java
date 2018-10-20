package com.dao;

import java.util.List;

import com.entity.TUser;

public interface IUsersDao {

	public List<TUser> select(TUser cli);
	public TUser getUsers(TUser cli);
	public List<TUser> selectAll();
	
	
	/**增加用户**/
	public boolean insert(TUser user);
	
	/**删除用户**/
	public boolean delete(TUser user);
	
	/**修改用户*/
	public boolean update(TUser user);
	
	/**查询单个用户信息*/
	public TUser getUser(TUser user);
	
	/**查询所有用户列表**/
	public List<TUser> list(String sql);
	
}

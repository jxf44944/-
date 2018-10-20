package com.dao;

import java.util.List;

import com.entity.TActer;

/***
 * 角色dao接口
 * @author Feng
 *2014-02-15
 *
 */
public interface IRolesDao {

	
	/**添加角色*/
	public boolean insert(TActer role);
	
	/**删除角色*/
	public boolean delete(TActer role);
	
	/**修改角色**/
	public boolean update(TActer role);
	
	/**查询单个角色**/
	public TActer getRole(TActer role);
	
	/**查询所有角色*/
	public List<TActer> list();
	
	
}

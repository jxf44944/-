package com.dao;

import java.util.List;

import com.entity.TLimit;

/***
 * 权限菜单Dao接口
 * @author Feng
 *
 */
public interface ILimitsDao {

	/**新增菜单**/
	public boolean insert(TLimit limit);
	
	/**删除菜单**/
	public boolean delete(TLimit limit);
	
	/**修改菜单**/
	public boolean update(TLimit limit);
	
	/**查询单个菜单信息**/
	public TLimit getMsg(TLimit limit);
	
	/**查询所有菜单列表*/
	public List<TLimit> list(String sql);
	
	/***
	 * 获取用户的权限，
	 */
	
}

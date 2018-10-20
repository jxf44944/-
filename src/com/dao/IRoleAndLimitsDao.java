package com.dao;

import java.util.List;

import com.entity.TMiddle;

/***
 * 角色权限中间表 dao接口
 * 用于动态分配角色的权限(菜单)
 * 
 * service 调用时要注意：
 * 因为用户的权限有多个，所以增加的时候应该是同时插入多条记录(调用方法多次);
 * 修改用户权限时，应该是先将原来的权限删除，再重新插入数据记录(即先调用删除方法，再调用新增方法);
 * 此处不提供单独删除一个权限记录。删除方法直接删除角色对应的所有权限记录。
 * 
 * @author Feng
 * 2014-02-15
 */
public interface IRoleAndLimitsDao {

	/**新增权限
	 * 因为用户的权限有多个，
	 * 这里是一条一条记录增加进去，
	 * 所以当管理员分配权限的时候，需要多次调用此方法
	 * 
	 * */
	public boolean insert(TMiddle randl);
	
	/**删除用户所有 菜单项*/
	public boolean delete(TMiddle randl);
	
	/**修改用户菜单项**/
	public boolean update(TMiddle randl);
	
	/**查找用户的菜单项**/
	public TMiddle getRoleLimits(TMiddle randl);
	
	/**按条件查找所有符合条件的用户菜单项列表
	 * 当传入null值时，查找所有的记录
	 * 当传入搜索条件时，按条件查询
	 * （按用户角色查询）
	 * */
	public List<TMiddle> list(String sql);
}

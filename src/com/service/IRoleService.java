package com.service;

import java.util.List;

import com.entity.TActer;


/***
 * 角色 service 接口
 * @author Feng
 * 2014-02-15
 */
public interface IRoleService {
	
	
	/**新增*/
	public boolean insRoles(TActer role , String[] limitArr);
	
	/**删除*/
	public boolean delRoles(TActer role);
	
	/**修改**/
	public boolean uptRoles(TActer role, String[] limitArr);
	
	/**查找单条记录信息**/
	public TActer getRoles(TActer role);
	
	/**查找列表
	 * */
	public List<TActer> list(String sql);
	
}

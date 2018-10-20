package com.service;

import java.util.List;

import com.entity.TMiddle;


/***
 * 通用 service 接口
 * @author Feng
 * 2014-02-15
 */
public interface IRoleandlimitsService {
	
	
	/**新增*/
	public boolean insRoleandlimits(TMiddle randl);
	
	/**删除*/
	public boolean delRoleandlimits(TMiddle randl);
	
	/**修改**/
	public boolean uptRoleandlimits(TMiddle randl);
	
	/**查找单条记录信息**/
	public TMiddle getRoleandlimits(TMiddle randl);
	
	/**查找列表
	 * */
	public List<TMiddle> list(String sql);
	
}

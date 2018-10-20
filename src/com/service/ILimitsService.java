package com.service;

import java.util.List;

import com.entity.TLimit;


/***
 * 权限菜单 service 接口   
 * @author Feng
 * 2014-02-15
 */
public interface ILimitsService {
	
	
	/**新增*/
	public boolean insLimits(TLimit limit);
	
	/**删除*/
	public boolean delLimits(TLimit limit);
	
	/**修改**/
	public boolean uptLimits(TLimit limit);
	
	/**查找单条记录信息**/
	public TLimit getLimits(TLimit limit);
	
	/**查找列表
	 * */
	public List<TLimit> listAll();
	public List<TLimit> list(String hql);
	
}

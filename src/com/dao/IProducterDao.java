package com.dao;

import java.util.List;

import com.entity.TProducter;

public interface IProducterDao {
	
	/**增加供应商**/
	public boolean insert(TProducter pt);
	
	/**删除供应商**/
	public boolean delete(TProducter pt);
	
	/**修改供应商**/
	public boolean update(TProducter pt);
	
	/**查询单个供应商**/
	public TProducter getAProducter(TProducter pt);
	
	/**查询供应商列表**/
	public List<TProducter> list();
	
	public int getAllRowCount(String hql);
	
	public List<TProducter> queryForPage(final String hql,final int offset,final int length); 
}

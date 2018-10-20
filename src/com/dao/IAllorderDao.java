package com.dao;

import java.util.List;

import com.entity.TAllorder;

public interface IAllorderDao {
	
	/**增加出入库单**/
	public Integer insert(TAllorder hp);
	
	/**删除出入库单**/
	public boolean delete(TAllorder hp);
	
	/**修改出入库单**/
	public boolean update(TAllorder hp);
	
	/**查询出入库单**/
	public TAllorder getAAllorder(TAllorder hp);
	
	/**查询出入库单**/
	public List<TAllorder> list();
	
	public int getAllRowCount(String hql);
	
	public List<TAllorder> queryForPage(final String hql,final int offset,final int length); 
}

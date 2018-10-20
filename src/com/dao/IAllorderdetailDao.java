package com.dao;

import java.util.List;

import com.entity.TAllorderdetail;

public interface IAllorderdetailDao {
	
	/**增加库单药品明细**/
	public boolean insert(TAllorderdetail hp);
	
	/**删除库单药品明细**/
	public boolean delete(TAllorderdetail hp);
	
	/**修改库单药品明细**/
	public boolean update(TAllorderdetail hp);
	
	/**查询库单药品明细**/
	public TAllorderdetail getAAllorderdetail(TAllorderdetail hp);
	
	/**根据条件查询库单药品明细**/
	public List<TAllorderdetail> getAllorderdetails(String hql);
	
	/**查询库单药品明细**/
	public List<TAllorderdetail> list();
	
	public int getAllRowCount(String hql);
	
	public List<TAllorderdetail> queryForPage(final String hql,final int offset,final int length); 
}

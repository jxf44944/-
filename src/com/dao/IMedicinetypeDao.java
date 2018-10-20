package com.dao;

import java.util.List;

import com.entity.TMedicinetype;

public interface IMedicinetypeDao {
	
	/**增加药品种类**/
	public boolean insert(TMedicinetype hp);
	
	/**删除药品种类**/
	public boolean delete(TMedicinetype hp);
	
	/**修改药品种类**/
	public boolean update(TMedicinetype hp);
	
	/**查询药品种类**/
	public TMedicinetype getAMedicinetype(TMedicinetype hp);
	
	/**查询药品种类**/
	public List<TMedicinetype> list();
	
	public int getAllRowCount(String hql);
	
	public List<TMedicinetype> queryForPage(final String hql,final int offset,final int length); 
}

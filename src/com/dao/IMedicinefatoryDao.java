package com.dao;

import java.util.List;

import com.entity.TMedicinefatory;

public interface IMedicinefatoryDao {
	
	/**增加药库药品**/
	public boolean insert(TMedicinefatory hp);
	
	/**删除药库药品**/
	public boolean delete(TMedicinefatory hp);
	
	/**修改药库药品**/
	public boolean update(TMedicinefatory hp);
	
	/**查询药库药品**/
	public TMedicinefatory getAMedicinefatory(TMedicinefatory hp);
	
	/**根据条件查询药库药品**/
	public TMedicinefatory getAMedicinefatory(String hql);
	
	/**查询药库药品列表**/
	public List<TMedicinefatory> list();
	
	public int getAllRowCount(String hql);
	
	public List<TMedicinefatory> queryForPage(final String hql,final int offset,final int length); 
}

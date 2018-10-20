package com.dao;

import java.util.List;

import com.entity.THospital;

public interface IHospitalDao {
	
	/**增加医院**/
	public boolean insert(THospital hp);
	
	/**删除医院**/
	public boolean delete(THospital hp);
	
	/**修改医院**/
	public boolean update(THospital hp);
	
	/**查询医院**/
	public THospital getAHospital(THospital hp);
	
	/**查询医院列表**/
	public List<THospital> list();
	
	public int getAllRowCount(String hql);
	
	public List<THospital> queryForPage(final String hql,final int offset,final int length); 
}

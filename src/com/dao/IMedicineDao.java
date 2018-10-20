package com.dao;

import java.util.List;

import com.entity.TMedicine;

public interface IMedicineDao {
	
	/**增加药品**/
	public boolean insert(TMedicine hp);
	
	/**删除药品**/
	public boolean delete(TMedicine hp);
	
	/**修改药品**/
	public boolean update(TMedicine hp);
	
	/**查询药品**/
	public TMedicine getAMedicine(TMedicine hp);
	
	/**查询药品种类列表**/
	public List<TMedicine> list();
	
    /**根据sql查询药品**/
    public List<TMedicine> getTongJiMedicine(String sql);
	
	/**根据条件查询药品种类列表**/
	public List<TMedicine> getMedicines(String hql);
	
	public int getAllRowCount(String hql);
	
	public List<TMedicine> queryForPage(final String hql,final int offset,final int length); 
}

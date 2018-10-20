package com.dao;

import java.util.List;

import com.entity.TMedpromiddle;

public interface IMedicinePriceDao {
	
	/**增加药品价格**/
	public boolean insert(TMedpromiddle hp);
	
	/**删除药品价格**/
	public boolean delete(TMedpromiddle hp);
	
	/**修改药品价格**/
	public boolean update(TMedpromiddle hp);
	
	/**查询药品价格**/
	public TMedpromiddle getAMedicinePrice(TMedpromiddle hp);
	
	/**查询药品价格**/
	public List<TMedpromiddle> list();
	
	public List<TMedpromiddle> getMedicinePrices(String hql);
	
	public int getAllRowCount(String hql);
	
	public List<TMedpromiddle> queryForPage(final String hql,final int offset,final int length); 
}

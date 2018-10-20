package com.service;

import java.util.List;

import com.entity.TMedpromiddle;
import com.util.PageBean;

public interface IMedicinePriceService {
	/**增加药品价格**/
	public boolean insMedicinePrice(TMedpromiddle hp);
	/**删除药品价格***/
    public boolean delMedicinePrice(TMedpromiddle hp);
    /**修改药品价格***/
    public boolean uptMedicinePrice(TMedpromiddle hp);
    /**查询单个药品价格***/
    public TMedpromiddle getAMedicinePrice(TMedpromiddle hp);
    /**根据条件查询药品价格***/
    public List<TMedpromiddle> getMedicinePrices(String hql);
    /**查询药品价格**/
    public List<TMedpromiddle> getMedicinePrice();
    
    public PageBean queryForPage(int pageSize,int currentPage,TMedpromiddle hp,String sql);
    
}

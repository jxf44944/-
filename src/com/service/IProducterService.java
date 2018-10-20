package com.service;

import java.util.List;

import com.entity.TProducter;
import com.util.PageBean;

public interface IProducterService {
	/**增加供应商**/
	public boolean insProducter(TProducter pt);
	/**删除供应商**/
    public boolean delProducter(TProducter pt);
    /**修改供应商**/
    public boolean uptProducter(TProducter pt);
    /**查询单个供应商**/
    public TProducter getAProducter(TProducter pt);
    /**查询供应商列表**/
    public List<TProducter> getProducter();
    
    public PageBean queryForPage(int pageSize,int currentPage,TProducter pt,String sql);
    
}

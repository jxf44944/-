package com.service;

import java.util.List;

import com.entity.TAllorder;
import com.util.PageBean;

public interface IAllorderService {
	/**增加出入库单**/
	public boolean insAllorder(TAllorder hp);
	/**删除出入库单***/
    public boolean delAllorder(TAllorder hp);
    /**修改出入库单***/
    public boolean uptAllorder(TAllorder hp);
    /**查询单个出入库单***/
    public TAllorder getAAllorder(TAllorder hp);
    /**查询出入库单**/
    public List<TAllorder> getAllorder();
    
    public PageBean queryForPage(int pageSize,int currentPage,TAllorder hp,String type);
    
}

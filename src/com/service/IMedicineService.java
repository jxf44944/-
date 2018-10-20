package com.service;

import java.util.List;

import com.entity.TMedicine;
import com.util.PageBean;

public interface IMedicineService {
	/**增加药品**/
	public boolean insMedicine(TMedicine hp);
	/**删除药品***/
    public boolean delMedicine(TMedicine hp);
    /**修改药品***/
    public boolean uptMedicine(TMedicine hp);
    /**查询单个药品***/
    public TMedicine getAMedicine(TMedicine hp);
    /**查询药品**/
    public List<TMedicine> getMedicine();
    /**根据sql查询药品**/
    public List<TMedicine> getTongJiMedicine(String sql);
    public PageBean queryForPage(int pageSize,int currentPage,TMedicine hp,String sql);
    
}

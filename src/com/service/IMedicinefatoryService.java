package com.service;

import java.util.List;

import com.entity.TMedicinefatory;
import com.util.PageBean;

public interface IMedicinefatoryService {
	/**增加药品价格**/
	public boolean insMedicinefatory(TMedicinefatory hp);
	/**删除药品价格***/
    public boolean delMedicinefatory(TMedicinefatory hp);
    /**修改药品价格***/
    public boolean uptMedicinefatory(TMedicinefatory hp);
    /**查询单个药品价格***/
    public TMedicinefatory getAMedicinefatory(TMedicinefatory hp);
    /**根据条件查询单个药品价格***/
    public TMedicinefatory getAMedicinefatory(String hql);    
    /**查询药品价格**/
    public List<TMedicinefatory> getMedicinefatory();
    
    public PageBean queryForPage(int pageSize,int currentPage,TMedicinefatory hp,String sql);
    
}

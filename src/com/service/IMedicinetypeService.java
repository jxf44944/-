package com.service;

import java.util.List;

import com.entity.TMedicinetype;
import com.util.PageBean;

public interface IMedicinetypeService {
	/**增加药品品种**/
	public boolean insMedicinetype(TMedicinetype hp);
	/**删除药品品种***/
    public boolean delMedicinetype(TMedicinetype hp);
    /**修改药品品种***/
    public boolean uptMedicinetype(TMedicinetype hp);
    /**查询单个药品品种***/
    public TMedicinetype getAMedicinetype(TMedicinetype hp);
    /**查询药品品种列表**/
    public List<TMedicinetype> getMedicinetype();
    
    public PageBean queryForPage(int pageSize,int currentPage,TMedicinetype hp,String sql);
    
}

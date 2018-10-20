package com.service;

import java.util.List;

import com.entity.TAllorderdetail;
import com.util.PageBean;

public interface IAllorderdetailService {
	/**增加库单药品明细**/
	public boolean insAllorderdetail(TAllorderdetail hp);
	/**删除库单药品明细***/
    public boolean delAllorderdetail(TAllorderdetail hp);
    /**修改库单药品明细***/
    public boolean uptAllorderdetail(TAllorderdetail hp);
    /**查询库单药品明细***/
    public TAllorderdetail getAAllorderdetail(TAllorderdetail hp);
    /**根据条件查询库单药品明细***/
    public List<TAllorderdetail> getAllorderdetails(String hql);
    /**查询库单药品明细**/
    public List<TAllorderdetail> getAllorderdetail();
    
    public PageBean queryForPage(int pageSize,int currentPage,TAllorderdetail hp);
    
}

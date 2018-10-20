package com.service;

import java.util.List;

import com.entity.THospital;
import com.util.PageBean;

public interface IHospitalService {
	/**增加医院**/
	public boolean insHospital(THospital hp);
	/**删除医院***/
    public boolean delHospital(THospital hp);
    /**修改医院***/
    public boolean uptHospital(THospital hp);
    /**查询单个医院***/
    public THospital getAHospital(THospital hp);
    /**查询医院*列表**/
    public List<THospital> getHospital();
    
    public PageBean queryForPage(int pageSize,int currentPage,THospital hp,String sql);
    
}

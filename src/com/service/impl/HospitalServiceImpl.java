package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IHospitalDao;
import com.entity.THospital;
import com.service.IHospitalService;
import com.util.PageBean;

@Service("hospitalService")
public class HospitalServiceImpl implements IHospitalService {
	
	private IHospitalDao hospitalDao;

	@Resource(name="hospitalDao")
	public void setHospitalDao(IHospitalDao HospitalDao) {
		this.hospitalDao = HospitalDao;
	}

	public boolean insHospital(THospital hp) {
		if(hospitalDao.insert(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean delHospital(THospital hp) {
		if(hospitalDao.delete(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean uptHospital(THospital hp) {
		if(hospitalDao.update(hp)){
			return true;}
		else{
			return false;}
	}	
	
	public THospital getAHospital(THospital hp) {
		THospital Hospital = hospitalDao.getAHospital(hp);
		return  Hospital;
	}
	
	
	
	/**查找列表
	 * */
	public List<THospital> getHospital(){
		List<THospital> list = hospitalDao.list();
		return list;
	}

	public PageBean queryForPage(int pageSize, int currentPage, THospital tp,String sql) {
		String where="";
		if(!sql.equals(""))
			where=sql;
		String hql="from THospital "+where;
		System.out.println(hql);
		int allRow=hospitalDao.getAllRowCount(hql);//总记录数
		int totalPage =PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, currentPage);//当前页开始记录
		final int length =pageSize;//每页记录数
		List<THospital> list=hospitalDao.queryForPage(hql, offset, length); //"一页"的记录
	    //把分页信息保存到bean中
	    PageBean pageBean = new PageBean();
	    pageBean.setPageSize(pageSize);
	    pageBean.setCurrentPage(currentPage);
	    pageBean.setAllRow(allRow);
	    pageBean.setTotalPage(totalPage);
	    pageBean.setList(list);
	    //pageBean.init();
		return pageBean;
	}
	
}

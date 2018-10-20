package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IMedicinetypeDao;
import com.entity.TMedicinetype;
import com.service.IMedicinetypeService;
import com.util.PageBean;

@Service("medicinetypeService")
public class MedicinetypeServiceImpl implements IMedicinetypeService {
	
	private IMedicinetypeDao medicinetypeDao;

	@Resource(name="medicinetypeDao")
	public void setMedicinetypeDao(IMedicinetypeDao MedicinetypeDao) {
		this.medicinetypeDao = MedicinetypeDao;
	}

	public boolean insMedicinetype(TMedicinetype hp) {
		if(medicinetypeDao.insert(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean delMedicinetype(TMedicinetype hp) {
		if(medicinetypeDao.delete(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean uptMedicinetype(TMedicinetype hp) {
		if(medicinetypeDao.update(hp)){
			return true;}
		else{
			return false;}
	}	
	
	public TMedicinetype getAMedicinetype(TMedicinetype hp) {
		TMedicinetype Medicinetype = medicinetypeDao.getAMedicinetype(hp);
		return  Medicinetype;
	}
	
	
	
	/**查找列表
	 * */
	public List<TMedicinetype> getMedicinetype(){
		List<TMedicinetype> list = medicinetypeDao.list();
		return list;
	}

	public PageBean queryForPage(int pageSize, int currentPage, TMedicinetype tp,String sql) {
		String where="";
		if(!sql.equals(""))
			where=sql;
		String hql="from TMedicinetype "+where;
		int allRow=medicinetypeDao.getAllRowCount(hql);//总记录数
		int totalPage =PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, currentPage);//当前页开始记录
		final int length =pageSize;//每页记录数
		List<TMedicinetype> list=medicinetypeDao.queryForPage(hql, offset, length); //"一页"的记录
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

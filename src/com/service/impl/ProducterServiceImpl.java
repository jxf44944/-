package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IProducterDao;
import com.entity.TProducter;
import com.service.IProducterService;
import com.util.PageBean;

@Service("producterService")
public class ProducterServiceImpl implements IProducterService {
	
	private IProducterDao producterDao;

	@Resource(name="producterDao")
	public void setProducterDao(IProducterDao producterDao) {
		this.producterDao = producterDao;
	}

	public boolean insProducter(TProducter pt) {
		if(producterDao.insert(pt)){
			return true;}
		else{
			return false;}
	}

	public boolean delProducter(TProducter pt) {
		if(producterDao.delete(pt)){
			return true;}
		else{
			return false;}
	}

	public boolean uptProducter(TProducter pt) {
		if(producterDao.update(pt)){
			return true;}
		else{
			return false;}
	}	
	
	public TProducter getAProducter(TProducter pt) {
		TProducter producter = producterDao.getAProducter(pt);
		return  producter;
	}
	
	
	
	/**查找列表
	 * */
	public List<TProducter> getProducter(){
		List<TProducter> list = producterDao.list();
		return list;
	}

	public PageBean queryForPage(int pageSize, int currentPage, TProducter tp,String sql) {
		String where="";
		if(!sql.equals(""))
			where=sql;
		String hql="from TProducter "+where;
		int allRow=producterDao.getAllRowCount(hql);//总记录数
		int totalPage =PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, currentPage);//当前页开始记录
		final int length =pageSize;//每页记录数
		List<TProducter> list=producterDao.queryForPage(hql, offset, length); //"一页"的记录
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

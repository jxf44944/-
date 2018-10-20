package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IAllorderdetailDao;
import com.dao.IMedicineDao;
import com.dao.IProducterDao;
import com.entity.TAllorderdetail;
import com.entity.TMedicine;
import com.entity.TProducter;
import com.service.IAllorderdetailService;
import com.util.PageBean;

@Service("allorderdetailService")
public class AllorderdetailServiceImpl implements IAllorderdetailService {
	
	private IAllorderdetailDao allorderdetailDao;

	private IMedicineDao medicineDao;
	
	private IProducterDao producterDao;
	
	@Resource(name="allorderdetailDao")
	public void setAllorderdetailDao(IAllorderdetailDao allorderdetailDao) {
		this.allorderdetailDao = allorderdetailDao;
	}

	@Resource(name="medicineDao")
	public void setMedicineDao(IMedicineDao MedicineDao) {
		this.medicineDao = MedicineDao;
	}
	
	@Resource(name="producterDao")
	public void setProducterDao(IProducterDao producterDao) {
		this.producterDao = producterDao;
	}
	
	public boolean insAllorderdetail(TAllorderdetail hp) {
		if(allorderdetailDao.insert(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean delAllorderdetail(TAllorderdetail hp) {
		if(allorderdetailDao.delete(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean uptAllorderdetail(TAllorderdetail hp) {
		if(allorderdetailDao.update(hp)){
			return true;}
		else{
			return false;}
	}	
	
	public TAllorderdetail getAAllorderdetail(TAllorderdetail hp) {
		return  allorderdetailDao.getAAllorderdetail(hp);
	}
	
	
	
	/**查找列表
	 * */
	public List<TAllorderdetail> getAllorderdetail(){
		List<TAllorderdetail> list = allorderdetailDao.list();
		return list;
	}

	public PageBean queryForPage(int pageSize, int currentPage, TAllorderdetail tp) {
		String where=" ";
		String hql="from TAllorderdetail "+where;
		int allRow=allorderdetailDao.getAllRowCount(hql);//总记录数
		int totalPage =PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, currentPage);//当前页开始记录
		final int length =pageSize;//每页记录数
		List<TAllorderdetail> list=allorderdetailDao.queryForPage(hql, offset, length); //"一页"的记录
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

	public List<TAllorderdetail> getAllorderdetails(String hql) {
		List<TAllorderdetail> list=allorderdetailDao.getAllorderdetails(hql);
		for(TAllorderdetail m:list){
			if(m.getTProducter().getId()!=null){
				TProducter pro=producterDao.getAProducter(m.getTProducter());
				m.setTProducter(pro);
			}
			if(m.getTMedicine().getId()!=null){
				TMedicine med=medicineDao.getAMedicine(m.getTMedicine());
				m.setTMedicine(med);
			}
		}
		return list;
	}
	
}

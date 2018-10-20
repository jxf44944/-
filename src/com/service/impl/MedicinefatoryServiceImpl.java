package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IMedicineDao;
import com.dao.IMedicinefatoryDao;
import com.dao.IProducterDao;
import com.entity.TMedicine;
import com.entity.TMedicinefatory;
import com.entity.TProducter;
import com.service.IMedicinefatoryService;
import com.util.PageBean;

@Service("medicinefatoryService")
public class MedicinefatoryServiceImpl implements IMedicinefatoryService {
	
	private IMedicinefatoryDao medicinefatoryDao;
	
	private IMedicineDao medicineDao;
	
	private IProducterDao producterDao;

	@Resource(name="medicinefatoryDao")
	public void setMedicinefatoryDao(IMedicinefatoryDao medicinefatoryDao) {
		this.medicinefatoryDao = medicinefatoryDao;
	}

	@Resource(name="medicineDao")
	public void setMedicineDao(IMedicineDao MedicineDao) {
		this.medicineDao = MedicineDao;
	}
	
	@Resource(name="producterDao")
	public void setProducterDao(IProducterDao producterDao) {
		this.producterDao = producterDao;
	}
	
	public boolean insMedicinefatory(TMedicinefatory hp) {
		if(medicinefatoryDao.insert(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean delMedicinefatory(TMedicinefatory hp) {
		if(medicinefatoryDao.delete(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean uptMedicinefatory(TMedicinefatory hp) {
		if(medicinefatoryDao.update(hp)){
			return true;}
		else{
			return false;}
	}	
	
	public TMedicinefatory getAMedicinefatory(TMedicinefatory hp) {
		TMedicinefatory medicinefatory = medicinefatoryDao.getAMedicinefatory(hp);
		if(medicinefatory.getTMedicine().getId()!=null){
				TMedicine m=medicineDao.getAMedicine(medicinefatory.getTMedicine());
				medicinefatory.setTMedicine(m);
			}
		if(medicinefatory.getTProducter().getId()!=null){
				TProducter pro=producterDao.getAProducter(medicinefatory.getTProducter());
				medicinefatory.setTProducter(pro);
		}
		return  medicinefatory;
	}
	
	
	
	/**查找列表
	 * */
	public List<TMedicinefatory> getMedicinefatory(){
		List<TMedicinefatory> list = medicinefatoryDao.list();
		for(TMedicinefatory medicinefatory:list){
			if(medicinefatory.getTMedicine().getId()!=null){
				TMedicine m=medicineDao.getAMedicine(medicinefatory.getTMedicine());
				medicinefatory.setTMedicine(m);
			}
			if(medicinefatory.getTProducter().getId()!=null){
					TProducter pro=producterDao.getAProducter(medicinefatory.getTProducter());
					medicinefatory.setTProducter(pro);
			}
		}
		return list;
	}

	public PageBean queryForPage(int pageSize, int currentPage, TMedicinefatory tp,String sql) {
		String where="";
		if(!sql.equals(""))
			where=sql;
		String hql="from TMedicinefatory "+where;
		int allRow=medicinefatoryDao.getAllRowCount(hql);//总记录数
		int totalPage =PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, currentPage);//当前页开始记录
		final int length =pageSize;//每页记录数
		List<TMedicinefatory> list=medicinefatoryDao.queryForPage(hql, offset, length); //"一页"的记录
		for(TMedicinefatory medicinefatory:list){
			if(medicinefatory.getTMedicine().getId()!=null){
				TMedicine m=medicineDao.getAMedicine(medicinefatory.getTMedicine());
				medicinefatory.setTMedicine(m);
			}
			if(medicinefatory.getTProducter().getId()!=null){
					TProducter pro=producterDao.getAProducter(medicinefatory.getTProducter());
					medicinefatory.setTProducter(pro);
			}
		}
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

	public TMedicinefatory getAMedicinefatory(String hql) {
		return medicinefatoryDao.getAMedicinefatory(hql);
	}
	
}

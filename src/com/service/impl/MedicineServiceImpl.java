package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IMedicineDao;
import com.dao.IMedicinetypeDao;
import com.entity.TMedicine;
import com.entity.TMedicinetype;
import com.service.IMedicineService;
import com.util.PageBean;

@Service("medicineService")
public class MedicineServiceImpl implements IMedicineService {
	
	private IMedicineDao medicineDao;

	private IMedicinetypeDao medicinetypeDao;
	
	@Resource(name="medicineDao")
	public void setMedicineDao(IMedicineDao MedicineDao) {
		this.medicineDao = MedicineDao;
	}
	
	@Resource(name="medicinetypeDao")
	public void setMedicinetypeDao(IMedicinetypeDao medicinetypeDao) {
		this.medicinetypeDao = medicinetypeDao;
	}

	public boolean insMedicine(TMedicine hp) {
		if(medicineDao.insert(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean delMedicine(TMedicine hp) {
		if(medicineDao.delete(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean uptMedicine(TMedicine hp) {
		if(medicineDao.update(hp)){
			return true;}
		else{
			return false;}
	}	
	
	public TMedicine getAMedicine(TMedicine hp) {
		TMedicine medicine = medicineDao.getAMedicine(hp);
		if(medicine.getTMedicinetype().getProtypeid()!=null){
				TMedicinetype mt=medicinetypeDao.getAMedicinetype(medicine.getTMedicinetype());
				medicine.setTMedicinetype(mt);
			}
		return  medicine;
	}
	
	
	
	/**查找列表
	 * */
	public List<TMedicine> getMedicine(){
		List<TMedicine> list = medicineDao.list();
		for(TMedicine m:list){
			if(m.getTMedicinetype().getProtypeid()!=null){
				TMedicinetype mt=medicinetypeDao.getAMedicinetype(m.getTMedicinetype());
				m.setTMedicinetype(mt);
			}
		}
		return list;
	}

	public PageBean queryForPage(int pageSize, int currentPage, TMedicine tp,String sql) {
		String where="";
		if(!sql.equals(""))
			where=sql;
		String hql="from TMedicine "+where;
		int allRow=medicineDao.getAllRowCount(hql);//总记录数
		int totalPage =PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, currentPage);//当前页开始记录
		final int length =pageSize;//每页记录数
		List<TMedicine> list=medicineDao.queryForPage(hql, offset, length); //"一页"的记录
		for(TMedicine m:list){
			if(m.getTMedicinetype().getProtypeid()!=null){
				TMedicinetype mt=medicinetypeDao.getAMedicinetype(m.getTMedicinetype());
				m.setTMedicinetype(mt);
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

	public List<TMedicine> getTongJiMedicine(String sql) {
		List<TMedicine> list = medicineDao.getTongJiMedicine(sql);
		for(TMedicine m:list){
			if(m.getTMedicinetype().getProtypeid()!=null){
				TMedicinetype mt=medicinetypeDao.getAMedicinetype(m.getTMedicinetype());
				m.setTMedicinetype(mt);
			}
		}
		return list;
	}
	
}

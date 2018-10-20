package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.IMedicineDao;
import com.dao.IMedicinePriceDao;
import com.dao.IProducterDao;
import com.entity.TMedicine;
import com.entity.TMedpromiddle;
import com.entity.TProducter;
import com.service.IMedicinePriceService;
import com.util.DebugUtil;
import com.util.PageBean;

@Service("medicinepriceService")
public class MedicinePriceServiceImpl implements IMedicinePriceService {
	
	private IMedicinePriceDao medicinePriceDao;

	private IMedicineDao medicineDao;
	
	private IProducterDao producterDao;
	
	@Resource(name="medicineDao")
	public void setMedicineDao(IMedicineDao MedicineDao) {
		this.medicineDao = MedicineDao;
	}
	
	@Resource(name="medicinepriceDao")
		public void setMedicinePriceDao(IMedicinePriceDao medicinePriceDao) {
		this.medicinePriceDao = medicinePriceDao;
	}
	
	@Resource(name="producterDao")
	public void setProducterDao(IProducterDao producterDao) {
		this.producterDao = producterDao;
	}

	public boolean insMedicinePrice(TMedpromiddle hp) {
		if(medicinePriceDao.insert(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean delMedicinePrice(TMedpromiddle hp) {
		if(medicinePriceDao.delete(hp)){
			return true;}
		else{
			return false;}
	}

	public boolean uptMedicinePrice(TMedpromiddle hp) {
		if(medicinePriceDao.update(hp)){
			return true;}
		else{
			return false;}
	}	
	
	public TMedpromiddle getAMedicinePrice(TMedpromiddle hp) {
		TMedpromiddle medicineprice = medicinePriceDao.getAMedicinePrice(hp);
		if(medicineprice.getTProducter().getId()!=null){
			TProducter pro=producterDao.getAProducter(medicineprice.getTProducter());
			medicineprice.setTProducter(pro);
		}
		if(medicineprice.getTMedicine().getId()!=null){
			TMedicine med=medicineDao.getAMedicine(medicineprice.getTMedicine());
			medicineprice.setTMedicine(med);
		}
		return  medicineprice;
	}
	
	 /**根据条件查询药品价格***/
	public List<TMedpromiddle> getMedicinePrices(String hql){
		List<TMedpromiddle> list = medicinePriceDao.getMedicinePrices(hql);
//		for(TMedpromiddle m:list){
//			System.out.println(m.toString());
//			if(m.getTProducter().getId()!=null){
//				TProducter pro=producterDao.getAProducter(m.getTProducter());
//				m.setTProducter(pro);
//			}
//			if(m.getTMedicine().getId()!=null){
//				TMedicine med=medicineDao.getAMedicine(m.getTMedicine());
//				m.setTMedicine(med);
//			}
//		}
		return list;
	}
	
	/**查找列表
	 * */
	public List<TMedpromiddle> getMedicinePrice(){
		List<TMedpromiddle> list = medicinePriceDao.list();
//		for(TMedpromiddle m:list){
//			if(m.getTProducter().getId()!=null){
//				TProducter pro=producterDao.getAProducter(m.getTProducter());
//				m.setTProducter(pro);
//			}
//			if(m.getTMedicine().getId()!=null){
//				TMedicine med=medicineDao.getAMedicine(m.getTMedicine());
//				m.setTMedicine(med);
//			}
//		}
		return list;
	}

	public PageBean queryForPage(int pageSize, int currentPage, TMedpromiddle tp,String sql) {
		String where="";
		if(!sql.equals(""))
			where=sql;
		String hql="from TMedpromiddle "+where;
		int allRow=medicinePriceDao.getAllRowCount(hql);//总记录数
		int totalPage =PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, currentPage);//当前页开始记录
		final int length =pageSize;//每页记录数
		List<TMedpromiddle> list=medicinePriceDao.queryForPage(hql, offset, length); //"一页"的记录
		for(TMedpromiddle m:list){
			if(m.getTProducter().getId()!=null){
				TProducter pro=producterDao.getAProducter(m.getTProducter());
				m.setTProducter(pro);
			}
			if(m.getTMedicine().getId()!=null){
				TMedicine med=medicineDao.getAMedicine(m.getTMedicine());
				m.setTMedicine(med);
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
	
}

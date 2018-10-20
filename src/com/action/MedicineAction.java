package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.entity.TMedicine;
import com.entity.TMedicinetype;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IMedicineService;
import com.service.IMedicinetypeService;
import com.util.DebugUtil;
import com.util.PageBean;

public class MedicineAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6378261953868111118L;

	private TMedicine medicine;
	
	private IMedicineService medicineService;
	
	private IMedicinetypeService medicinetypeService;
	
	private List<TMedicinetype> medicinetypes;

	@Resource(name="medicineService")
	public void setMedicineService(IMedicineService MedicineService) {
		this.medicineService = MedicineService;
	}
	
	@Resource(name="medicinetypeService")
	public void setMedicinetypeService(IMedicinetypeService MedicinetypeService) {
		this.medicinetypeService = MedicinetypeService;
	}

	public TMedicine getMedicine() {
		return medicine;
	}

	public void setMedicine(TMedicine Medicine) {
		this.medicine = Medicine;
	}

	public List<TMedicinetype> getMedicinetypes() {
		return medicinetypes;
	}

	public void setMedicinetypes(List<TMedicinetype> medicinetypes) {
		this.medicinetypes = medicinetypes;
	}

	/*	// 跳转新增页面
	public String toAddProduct() {
		return "toAdd";
	}*/
	public String toAddMedicine(){
		medicinetypes=medicinetypeService.getMedicinetype();
		return "success";
	}
	// 新增提交
	public String AddMedicine() {
		medicineService.insMedicine(medicine);
		return "MedicineList";
	}

	public String DelMedicine() {
		medicineService.delMedicine(medicine);
		return "MedicineList";
	}

	public String UpdateMedicine() {
		medicineService.uptMedicine(medicine);
		return "MedicineList";
	}
	
	private List<TMedicine> medicineList;
	
	public List<TMedicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<TMedicine> MedicineList) {
		this.medicineList = MedicineList;
	}

	//分页的属性设置
	 private int page = 1; //第几页
	    private PageBean pageBean; //包含分布信息的bean
	    
		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public PageBean getPageBean() {
			return pageBean;
		}

		public void setPageBean(PageBean pageBean) {
			this.pageBean = pageBean;
		}
	
	@SuppressWarnings("unchecked")
	public String ListMedicine() {
		this.pageBean=medicineService.queryForPage(10, page, medicine,"");
		medicineList = pageBean.getList();//有分页的获取列表
		return "toList";
	}
	
	private String hpvalue;
	
	public String getHpvalue() {
		return hpvalue;
	}

	public void setHpvalue(String hpvalue) {
		this.hpvalue = hpvalue;
	}

	@SuppressWarnings("unchecked")
	public String SearchMedicine() {
		try {
			hpvalue = new String(hpvalue.getBytes("iso8859-1"), "UTF-8");
			DebugUtil.debugInfo(hpvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql="where number like '%"+hpvalue+"%' or name like '%"+hpvalue+
			"%' or othername like '%"+hpvalue+"%'";
		this.pageBean=medicineService.queryForPage(10, page, medicine,sql);
		medicineList = pageBean.getList();//有分页的获取列表
		return "toList";
	}

	public String getMedicineA() {
		medicine =medicineService.getAMedicine(medicine);
		medicinetypes=medicinetypeService.getMedicinetype();
		return "success";
	}
	
	//批量删除
	private String ID;

	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String DelMoreMedicine() {
		String ids[]=ID.split(",");
		for(int i=0;i<ids.length;i++){
			int j=Integer.parseInt(ids[i]);
			TMedicine med=new TMedicine();
			med.setId(j);
			medicineService.delMedicine(med);
		}
		return "MedicineList";
	}
}

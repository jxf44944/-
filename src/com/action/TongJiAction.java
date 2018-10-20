package com.action;

import java.util.List;

import javax.annotation.Resource;

import com.entity.TMedicine;
import com.entity.TMedicinetype;
import com.entity.TProducter;
import com.entity.TongJi;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IMedicineService;
import com.service.IMedicinetypeService;
import com.service.IProducterService;

public class TongJiAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6378261953868111118L;

	private TMedicine medicine;
	
	private IMedicineService medicineService;
	
	private IProducterService producterService;
	
	private IMedicinetypeService medicinetypeService;
	
	private List<TMedicinetype> medicinetypes;
	
	private List<TMedicine> medicines;
	
	private List<TProducter> producters;
	
	private TongJi tongji;

	@Resource(name="medicineService")
	public void setMedicineService(IMedicineService MedicineService) {
		this.medicineService = MedicineService;
	}
	
	@Resource(name="producterService")
	public void setProducterService(IProducterService producterService) {
		this.producterService = producterService;
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
	
	public List<TMedicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<TMedicine> medicines) {
		this.medicines = medicines;
	}

	public List<TProducter> getProducters() {
		return producters;
	}

	public void setProducters(List<TProducter> producters) {
		this.producters = producters;
	}

	public TongJi getTongji() {
		return tongji;
	}

	public void setTongji(TongJi tongji) {
		this.tongji = tongji;
	}



	private List<TMedicine> medicineList;
	
	public List<TMedicine> getMedicineList() {
		return medicineList;
	}

	public void setMedicineList(List<TMedicine> MedicineList) {
		this.medicineList = MedicineList;
	}

	
	public String ListTongJi() {
		medicines=medicineService.getMedicine();
		producters=producterService.getProducter();
		medicinetypes=medicinetypeService.getMedicinetype();
		return "toList";
	}
	
	private String hpvalue;
	
	public String getHpvalue() {
		return hpvalue;
	}

	public void setHpvalue(String hpvalue) {
		this.hpvalue = hpvalue;
	}

	public String SearchTongJi() {
		String sql="";
		if(tongji.getProducterid()==null)
		    sql="select tm.* from t_medicine tm where 1=1";
		else
			sql="select tm.* from t_medicine tm left join t_medpromiddle  tmp on" +
					" tmp.medid=tm.id  where tmp.proid="+tongji.getProducterid();
		if(tongji.getMedicineid()!=null)
			sql=sql+" and tm.id="+tongji.getMedicineid();
		else
			sql=sql+" and 1=1";
		if(tongji.getMedicinetypeid()!=null)
			sql=sql+" and tm.typeid="+tongji.getMedicinetypeid();
		else
			sql=sql+" and 1=1";
		if(tongji.getMedicinetime()!=null&&!tongji.getMedicinetime().equals(""))
			sql=sql+" and tm.time like '"+tongji.getMedicinetime()+"%'";
		else
			sql=sql+" and 1=1";
		
		medicineList=medicineService.getTongJiMedicine(sql);
		medicines=medicineService.getMedicine();
		producters=producterService.getProducter();
		medicinetypes=medicinetypeService.getMedicinetype();
			
		return "toList";
	}

}

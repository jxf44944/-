package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.entity.TMedicine;
import com.entity.TMedicinefatory;
import com.entity.TProducter;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IMedicineService;
import com.service.IMedicinefatoryService;
import com.service.IProducterService;
import com.util.DebugUtil;
import com.util.PageBean;

public class MedicineFatoryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2113343965711989034L;
	
	private TMedicinefatory medicinefatory;
	private IMedicineService medicineService;
	
	private IProducterService producterService;
	
	private IMedicinefatoryService medicinefatoryService;
	
	private List<TMedicine> medicines;
	
	private List<TProducter> producters;

	@Resource(name="medicineService")
	public void setMedicineService(IMedicineService MedicineService) {
		this.medicineService = MedicineService;
	}

	@Resource(name="producterService")
	public void setProducterService(IProducterService producterService) {
		this.producterService = producterService;
	}

	@Resource(name="medicinefatoryService")
	public void setMedicineFatoryService(IMedicinefatoryService MedicinefatoryService) {
		this.medicinefatoryService = MedicinefatoryService;
	}

	public TMedicinefatory getMedicinefatory() {
		return medicinefatory;
	}

	public void setMedicinefatory(TMedicinefatory medicinefatory) {
		this.medicinefatory = medicinefatory;
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

	/*	// 跳转新增页面
	public String toAddProduct() {
		return "toAdd";
	}*/
	public String toAddMedicineFatory(){
		medicines=medicineService.getMedicine();
		producters=producterService.getProducter();
		return "success";
	}
	// 新增提交
	public String AddMedicineFatory() {
		DebugUtil.debugInfo(medicinefatory);
		medicinefatoryService.insMedicinefatory(medicinefatory);
		return "MedicineFatoryList";
	}

	public String DelMedicineFatory() {
		medicinefatoryService.delMedicinefatory(medicinefatory);
		return "MedicineFatoryList";
	}

	public String UpdateMedicineFatory() {
		medicinefatoryService.uptMedicinefatory(medicinefatory);
		return "MedicineFatoryList";
	}
	
	private List<TMedicinefatory> medicinefatoryList;
	
	public List<TMedicinefatory> getMedicinefatoryList() {
		return medicinefatoryList;
	}

	public void setMedicinefatoryList(List<TMedicinefatory> medicinefatoryList) {
		this.medicinefatoryList = medicinefatoryList;
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
	
	static String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		MedicineFatoryAction.type = type;
	}

	@SuppressWarnings("unchecked")
	public String ListMedicineFatory() {
		this.pageBean=medicinefatoryService.queryForPage(10, page, medicinefatory,"");
		medicinefatoryList = pageBean.getList();//有分页的获取列表
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
	public String SearchMedicineFatory() {
		try {
			hpvalue = new String(hpvalue.getBytes("iso8859-1"), "UTF-8");
			DebugUtil.debugInfo(hpvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql="where medname like '%"+hpvalue+"%' or comeprice like '%"+hpvalue+
						  " %' or sellpricenow like '%"+hpvalue+ " %' or valuetime like '%"+hpvalue+ " %'";
		this.pageBean=medicinefatoryService.queryForPage(10, page, medicinefatory,sql);
		medicinefatoryList = pageBean.getList();//有分页的获取列表
		return "toList";
	}

	public String getMedicineFatoryA() {
		medicinefatory =medicinefatoryService.getAMedicinefatory(medicinefatory);
		medicines=medicineService.getMedicine();
		producters=producterService.getProducter();
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
	public String DelMoreMedicineFatory() {
		String ids[]=ID.split(",");
		for(int i=0;i<ids.length;i++){
			int j=Integer.parseInt(ids[i]);
			TMedicinefatory cc=new TMedicinefatory();
			cc.setId(j);
			medicinefatoryService.delMedicinefatory(cc);
		}
		return "MedicineFatoryList";
	}
}

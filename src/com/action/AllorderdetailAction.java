package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Debug;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.entity.TAllorder;
import com.entity.TAllorderdetail;
import com.entity.TMedicine;
import com.entity.TMedpromiddle;
import com.entity.TProducter;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IAllorderService;
import com.service.IAllorderdetailService;
import com.service.IMedicinePriceService;
import com.service.IMedicineService;
import com.service.IProducterService;
import com.util.DebugUtil;

public class AllorderdetailAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	/**
	 * 
	 */

	private static final long serialVersionUID = -8956532806103594522L;

	private TAllorder allorder;

	private String medicineid;

	private IAllorderService allorderService;

	private IMedicineService medicineService;

	private IProducterService producterService;

	private IAllorderdetailService allorderdetailService;

	private IMedicinePriceService medicinepriceService;

	private List<TMedicine> medicines;

	private List<TProducter> producters;

	private List<TAllorderdetail> allorderdetails;

	HttpServletRequest req;

	HttpServletResponse resp;

	private Map<String, Object> dataMap;

	public void setServletRequest(HttpServletRequest req) {
		this.req = req;
	}

	public void setServletResponse(HttpServletResponse resp) {
		this.resp = resp;
	}

	@Resource(name = "allorderService")
	public void setAllorderService(IAllorderService allorderService) {
		this.allorderService = allorderService;
	}

	@Resource(name = "allorderdetailService")
	public void setAllorderdetailService(IAllorderdetailService allorderdetailService) {
		this.allorderdetailService = allorderdetailService;
	}

	@Resource(name = "medicineService")
	public void setMedicineService(IMedicineService MedicineService) {
		this.medicineService = MedicineService;
	}

	@Resource(name = "producterService")
	public void setProducterService(IProducterService producterService) {
		this.producterService = producterService;
	}

	@Resource(name = "medicinepriceService")
	public void setMedicinepriceService(IMedicinePriceService medicinepriceService) {
		this.medicinepriceService = medicinepriceService;
	}

	public TAllorder getAllorder() {
		return allorder;
	}

	public void setAllorder(TAllorder allorder) {
		this.allorder = allorder;
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

	public String getMedicineid() {
		return medicineid;
	}

	public List<TAllorderdetail> getAllorderdetails() {
		return allorderdetails;
	}

	public void setAllorderdetails(List<TAllorderdetail> allorderdetails) {
		this.allorderdetails = allorderdetails;
	}

	public void setMedicineid(String medicineid) {
		this.medicineid = medicineid;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * TODO 2014-04-25使用json返回
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public String getAllorderdetail() {
		List<TMedpromiddle> tm = new ArrayList<TMedpromiddle>();
		String hql = " where TMedicine.id =" + medicineid + " and price != null";
		tm = medicinepriceService.getMedicinePrices(hql);
		//重新组装数据
		List<TMedpromiddle> tempList = new ArrayList<TMedpromiddle>();
//		long time = System.currentTimeMillis();
		for (int i = 0; i < tm.size(); i++) {
			TMedpromiddle tMedpromiddle = tm.get(i);
			//药品
			TMedicine tMedicine = tMedpromiddle.getTMedicine();
			//供应商
			TProducter tProducter = tMedpromiddle.getTProducter();
			//临时存储
			TMedpromiddle tempTMedpromiddle = new TMedpromiddle();
			
			tempTMedpromiddle.setId(tMedpromiddle.getId());
			tempTMedpromiddle.setPrice(tMedpromiddle.getPrice());
			tempTMedpromiddle.setValue(tMedpromiddle.getValue());
			tempTMedpromiddle.setProdate(tMedpromiddle.getProdate());
			
			TMedicine tempTMedicine = new TMedicine();
			
			tempTMedicine.setId(tMedicine.getId());
			tempTMedicine.setName(tMedicine.getName());
			
			TProducter tempTProducter = new TProducter();
			
			tempTProducter.setId(tProducter.getId());
			tempTProducter.setName(tProducter.getName());
			
			tempTMedpromiddle.setTMedicine(tempTMedicine);
			tempTMedpromiddle.setTProducter(tempTProducter);
			tempList.add(tempTMedpromiddle);
		}
//		DebugUtil.useTime(time);
		// 指定为JSON
		dataMap = new HashMap<String, Object>();
		if (tm == null) {
			try {
				dataMap.put("ok", false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "json";
		}
		try {
			dataMap.put("msg", tempList);
			dataMap.put("ok", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "json";
	}

	public String GetAllorderdetail() {
		String hql = "where TAllorder.id=" + allorder.getId();
		allorder = allorderService.getAAllorder(allorder);
		if (allorder.getId() != null) {
			allorderdetails = allorderdetailService.getAllorderdetails(hql);
		}
		return "success";
	}

}

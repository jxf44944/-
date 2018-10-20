package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.entity.TMedicine;
import com.entity.TMedpromiddle;
import com.entity.TProducter;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IMedicinePriceService;
import com.service.IMedicineService;
import com.service.IProducterService;
import com.util.DebugUtil;
import com.util.PageBean;

public class MedicinePriceAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8327717102113325276L;

	private IMedicineService medicineService;

	private TMedpromiddle medicineprice;

	private IProducterService producterService;

	private IMedicinePriceService medicinepriceService;

	private List<TMedicine> medicines;

	private List<TProducter> producters;

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

	public TMedpromiddle getMedicineprice() {
		return medicineprice;
	}

	public void setMedicineprice(TMedpromiddle medicineprice) {
		this.medicineprice = medicineprice;
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

	/**
	 * // 跳转新增页面 public String toAddProduct() { return "toAdd"; }
	 */
	public String toAddMedicinePrice() {
		medicines = medicineService.getMedicine();
		producters = producterService.getProducter();
		return "success";
	}

	/**
	 * 新增提交
	 * 
	 * @return
	 */
	public String AddMedicinePrice() {
		String hql = "where  TMedicine.id=" + medicineprice.getTMedicine().getId() + " and TProducter.id=" + medicineprice.getTProducter().getId();
		List<TMedpromiddle> medicineprice2 = medicinepriceService.getMedicinePrices(hql);
		// TODO2018-5-3
		if (medicineprice2.size() > 0) {
			if ("price".equals(type)) {
				// 价格
				
	    // TODO2018-5-6  自动添加价格小数点后2位
				String temp = medicineprice.getPrice();
				String[] chaifen = new String[2];
				chaifen = temp.split("\\.");
				if(chaifen.length==1){
					temp=chaifen[0]+".00";
				}else if(chaifen[1].length() == 1){
					chaifen[1]=chaifen[1]+"0";
					temp = chaifen[0]+"."+chaifen[1];
				}

//				medicineprice2.get(0).setPrice(medicineprice.getPrice());
			    medicineprice2.get(0).setPrice(temp);
				
			} else {
				// 生产时间
				medicineprice2.get(0).setProdate(medicineprice.getProdate());
				// 有效时间
				medicineprice2.get(0).setValue(medicineprice.getValue());
			}
			medicineprice = medicineprice2.get(0);
			// 更新时间
			medicinepriceService.uptMedicinePrice(medicineprice);
		} else
			// 插入数据库
			medicinepriceService.insMedicinePrice(medicineprice);
		return "MedicinePriceList";
	}

	public String DelMedicinePrice() {
		if (type.equals("price")) {
			medicineprice = medicinepriceService.getAMedicinePrice(medicineprice);
			medicineprice.setPrice(null);
			medicinepriceService.uptMedicinePrice(medicineprice);
			// medicinepriceService.delMedicinePrice(medicineprice);
		} else {
			medicineprice = medicinepriceService.getAMedicinePrice(medicineprice);
			medicineprice.setProdate(null);
			medicinepriceService.uptMedicinePrice(medicineprice);
		}
		return "MedicinePriceList";
	}

	public String UpdateMedicinePrice() {
		medicinepriceService.uptMedicinePrice(medicineprice);
		return "MedicinePriceList";
	}

	private List<TMedpromiddle> medicinepriceList;

	public List<TMedpromiddle> getMedicinepriceList() {
		return medicinepriceList;
	}

	public void setMedicinepriceList(List<TMedpromiddle> medicinepriceList) {
		this.medicinepriceList = medicinepriceList;
	}

	// 分页的属性设置
	private int page = 1; // 第几页
	private PageBean pageBean; // 包含分布信息的bean

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
	public String ListMedicinePrice() {
		String hql = "";
		if (type.equals("price"))
			hql = "where price !=''";
		else
			hql = "where prodate !=''";
		this.pageBean = medicinepriceService.queryForPage(10, page, medicineprice, hql);
		medicinepriceList = pageBean.getList();// 有分页的获取列表
		return "toList";
	}

	static String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		MedicinePriceAction.type = type;
	}

	private String hpvalue = "";

	public String getHpvalue() {
		return hpvalue;
	}

	public void setHpvalue(String hpvalue) {
		this.hpvalue = hpvalue;
	}

	@SuppressWarnings("unchecked")
	public String SearchMedicinePrice() {
		try {
			hpvalue = new String(hpvalue.getBytes("iso8859-1"), "UTF-8");
			DebugUtil.debugInfo(hpvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql = "";
		if (type.equals("price"))
			sql = "where price like '%" + hpvalue + "%' or medid like '%" + hpvalue + "%'";
		else
			sql = "where prodate like '%" + hpvalue + "%' or value like '%" + hpvalue + "%'";
		/*
		 * "' or manager like '%"+hpvalue+"%' or"+
		 * " phone like '%"+hpvalue+"%' or adress like '%"+hpvalue+"%'";
		 */
		this.pageBean = medicinepriceService.queryForPage(10, page, medicineprice, sql);
		medicinepriceList = pageBean.getList();// 有分页的获取列表
		return "toList";
	}

	public String getMedicinePriceA() {
		medicineprice = medicinepriceService.getAMedicinePrice(medicineprice);
		medicines = medicineService.getMedicine();
		producters = producterService.getProducter();
		return "success";
	}

	// 批量删除
	private String ID;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String DelMoreMedicinePrice() {
		String ids[] = ID.split(",");
		for (int i = 0; i < ids.length; i++) {
			int j = Integer.parseInt(ids[i]);
			TMedpromiddle cc = new TMedpromiddle();
			cc.setId(j);
			if (type.equals("price")) {
				medicineprice.setPrice(null);
				medicinepriceService.uptMedicinePrice(cc);
				// medicinepriceService.delMedicinePrice(medicineprice);
			} else {
				medicineprice.setProdate(null);
				medicinepriceService.uptMedicinePrice(cc);
			}
			// medicinepriceService.delMedicinePrice(cc);
		}
		return "MedicinePriceList";
	}
}

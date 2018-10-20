package com.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.mapping.Collection;

import com.entity.TAllorder;
import com.entity.TAllorderdetail;
import com.entity.TMedicine;
import com.entity.TMedicinefatory;
import com.entity.TMedpromiddle;
import com.entity.TProducter;
import com.entity.TUser;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IAllorderService;
import com.service.IAllorderdetailService;
import com.service.IMedicinePriceService;
import com.service.IMedicineService;
import com.service.IMedicinefatoryService;
import com.service.IProducterService;
import com.util.DebugUtil;
import com.util.PageBean;
import com.util.ShoppingCartUtil;

public class AllorderAction extends BaseAction {
	/**
	 * 
	 */

	private static final long serialVersionUID = -8956532806103594522L;

	private TAllorder allorder;

	private String medicineid;

	private TAllorderdetail allorderdetail;

	private static List<TAllorderdetail> allorderdetails;

	private IAllorderdetailService allorderdetailService;

	private IMedicinefatoryService medicinefatoryService;

	private IMedicinePriceService medicinepriceService;

	private IAllorderService allorderService;

	private IMedicineService medicineService;

	private IProducterService producterService;

	private List<TMedicine> medicines;

	private List<TProducter> producters;

	private List<TMedpromiddle> medprices;

	private String sessionName;

	private List<TMedicinefatory> medicinefatory;

	@Resource(name = "allorderService")
	public void setAllorderService(IAllorderService allorderService) {
		this.allorderService = allorderService;
	}

	@Resource(name = "medicineService")
	public void setMedicineService(IMedicineService MedicineService) {
		this.medicineService = MedicineService;
	}

	@Resource(name = "producterService")
	public void setProducterService(IProducterService producterService) {
		this.producterService = producterService;
	}

	@Resource(name = "allorderdetailService")
	public void setAllorderdetailService(IAllorderdetailService allorderdetailService) {
		this.allorderdetailService = allorderdetailService;
	}

	@Resource(name = "medicinefatoryService")
	public void setMedicineFatoryService(IMedicinefatoryService MedicinefatoryService) {
		this.medicinefatoryService = MedicinefatoryService;
	}

	@Resource(name = "medicinepriceService")
	public void setMedicinepriceService(IMedicinePriceService medicinepriceService) {
		this.medicinepriceService = medicinepriceService;
	}

	public List<TAllorderdetail> getAllorderdetails() {
		return allorderdetails;
	}

	public void setAllorderdetails(List<TAllorderdetail> allorderdetails) {
		AllorderAction.allorderdetails.clear();
		AllorderAction.allorderdetails = allorderdetails;
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

	public void setMedicineid(String medicineid) {
		this.medicineid = medicineid;
	}

	public List<TMedpromiddle> getMedprices() {
		return medprices;
	}

	public void setMedprices(List<TMedpromiddle> medprices) {
		this.medprices = medprices;
	}

	public String getSessionName() {
		return sessionName;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	/*
	 * // 跳转新增页面 public String toAddProduct() { return "toAdd"; }
	 */
	@SuppressWarnings("unchecked")
	public String toAddAllorder() {
		Map session = ActionContext.getContext().getSession();
		TUser user = (TUser) session.get("loginUser");
		if (user != null) {
			//判断用户成功，获取到相关信息
			if ("in".equals(getSession().getAttribute("type"))) {
				//入库
				// 药品入库规则(用户名字,药物编号,供应商编号)
				if (allorderdetail != null && allorderdetail.getTMedicine() != null && allorderdetail.getTProducter() != null) {
					if (allorderdetail.getTMedicine().getId() > 0 && allorderdetail.getTProducter().getId() > 0
							&& allorderdetail.getNum().length() > 0) {
						allorderdetail.setTMedicine(medicineService.getAMedicine(allorderdetail.getTMedicine()));
						allorderdetail.setTProducter(producterService.getAProducter(allorderdetail.getTProducter()));
						if (user != null) {
							String msg = user.getName() + "@in," + allorderdetail.getTMedicine().getId() + ","
									+ allorderdetail.getTProducter().getId();
							System.out.println(msg);
							DebugUtil.debugInfo("AllorderAction:" + msg);
							session.put(msg, allorderdetail);
						}
					}
				}
				return "success";
			} else if ("out".equals(getSession().getAttribute("type"))) {
				if (allorderdetail != null && allorderdetail.getTMedicine() != null && allorderdetail.getTProducter() != null) {
					if (allorderdetail.getTMedicine().getId() > 0 && allorderdetail.getTProducter().getId() > 0
							&& allorderdetail.getNum().length() > 0) {
						allorderdetail.setTMedicine(medicineService.getAMedicine(allorderdetail.getTMedicine()));
						allorderdetail.setTProducter(producterService.getAProducter(allorderdetail.getTProducter()));
						if (user != null) {
							String msg = user.getName() + "@in," + allorderdetail.getTMedicine().getId() + ","
									+ allorderdetail.getTProducter().getId();
							System.out.println(msg);
							DebugUtil.debugInfo("AllorderAction:" + msg);
							session.put(msg, allorderdetail);
						}
					}
				}
			}
			return "AllorderOut";
		}
		return "success";
	}

	/**
	 * 删除购物车
	 * @return
	 */
	public String removeAllorder() {
		Map session = ActionContext.getContext().getSession();
		try {
			sessionName = new String(sessionName.getBytes("iso8859-1"), "UTF-8");
			DebugUtil.debugInfo(sessionName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		session.remove(sessionName);// sessionName 要删除的编号
		return "remove";
	}

	public String toAddAllorderdetail() {
		// TODO 2018-5-6
		if ("in".equals(getSession().getAttribute("type"))) {
			// 药品
			medicines = medicineService.getMedicine();
		} else if ("out".equals(getSession().getAttribute("type"))) {
			//TODO
			medicinefatory = medicinefatoryService.getMedicinefatory();
			for(int i=0;i<medicinefatory.size();i++){
				DebugUtil.debugInfo(medicinefatory.get(i).getMedname()+"----");
				DebugUtil.debugInfo(medicinefatory.get(i).getTMedicine().getId());
			}
		}

		return "success";
	}

	public List<TMedicinefatory> getMedicinefatory() {
		return medicinefatory;
	}

	public void setMedicinefatory(List<TMedicinefatory> medicinefatory) {
		this.medicinefatory = medicinefatory;
	}

	public TAllorderdetail getAllorderdetail() {
		return allorderdetail;
	}

	public void setAllorderdetail(TAllorderdetail allorderdetail) {
		this.allorderdetail = allorderdetail;
	}

	// 新增提交
	public String AddAllorder() {
		// 1添加订单信息
		// 2添加 订单详细表信息(关联上面1 的表，另外关联药品和供应商)
		ShoppingCartUtil cartUtil = new ShoppingCartUtil("in");
		List<TAllorderdetail> allorderdetails = cartUtil.getCartInfo(getSession());
		Set<TAllorderdetail> setAllorderdetails = null;
		if (allorderdetails != null) {
			setAllorderdetails = new HashSet<TAllorderdetail>(allorderdetails);
		}
		allorder.setTAllorderdetails(setAllorderdetails);
		allorder.setSum(cartUtil.getCountCartInfo(getSession()) + "");
		allorder.setTUser(cartUtil.getCurrentUser(getSession()));
		allorder.setStatus("未审核");
		// 修改支付方式的输入 改为select2018-5-4
		int paytype = Integer.parseInt(allorder.getPaytype());
		if (paytype == 1) {
			allorder.setPaytype("现金支付");
		} else if (paytype == 2) {
			allorder.setPaytype("网银支付");
		}
		allorderService.insAllorder(allorder);
		// 3.清除购物车
		cartUtil.removeCartInfo(getSession());
		return "AllorderList";
	}
	public String OutAllorder() {
		// 1添加订单信息
		// 2添加 订单详细表信息(关联上面1 的表，另外关联药品和供应商)
		ShoppingCartUtil cartUtil = new ShoppingCartUtil("out");
		List<TAllorderdetail> allorderdetails = cartUtil.getCartInfo(getSession());
		Set<TAllorderdetail> setAllorderdetails = null;
		if (allorderdetails != null) {
			setAllorderdetails = new HashSet<TAllorderdetail>(allorderdetails);
		}
		allorder.setTAllorderdetails(setAllorderdetails);
		allorder.setSum(cartUtil.getCountCartInfo(getSession()) + "");
		allorder.setTUser(cartUtil.getCurrentUser(getSession()));
		allorder.setStatus("未审核");
		// 修改支付方式的输入 改为select2018-5-4
		int paytype = Integer.parseInt(allorder.getPaytype());
		if (paytype == 1) {
			allorder.setPaytype("微信支付");
		} else if (paytype == 2) {
			allorder.setPaytype("银行卡");
		}
		allorderService.insAllorder(allorder);
		// 3.清除购物车
		cartUtil.removeCartInfo(getSession());
		return "AllorderList";
	}
	public String DelAllorder() {
		allorderService.delAllorder(allorder);
		return "AllorderList";
	}

	public String UpdateAllorder() {
		if ("审核通过".equals(allorder.getStatus())) {
			GregorianCalendar gc = new GregorianCalendar();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			gc.setTime(d);
			gc.add(1, 1);
			String d2 = df.format(d);
			String d3 = df.format(gc.getTime());
			for (TAllorderdetail tad : allorderdetails) {
				String hql = " where ";
				if (tad.getTMedicine().getId() != null)
					hql = hql + " TMedicine.id=" + tad.getTMedicine().getId();
				else
					return null;
				if (tad.getTProducter().getId() != null)
					hql = hql + " and TProducter.id=" + tad.getTProducter().getId();
				else
					return null;
				// hql=hql+" and valuetime =" +d2;
				TMedicinefatory mt2 = medicinefatoryService.getAMedicinefatory(hql);
				if (mt2 != null) {
					int num1 = Integer.valueOf(mt2.getShengyuliang());
					int num2 = Integer.valueOf(tad.getNum());
					int num = 0;
					if (allorder.getOrdertype() == 1 || allorder.getOrdertype() == 2)
						num = num1 + num2;
					else {
						if (num1 > num2)
							num = num1 - num2;
					}
					mt2.setShengyuliang(String.valueOf(num));
					medicinefatoryService.uptMedicinefatory(mt2);
				} else {
					TMedicinefatory mt = new TMedicinefatory();
					mt.setTMedicine(tad.getTMedicine());
					mt.setTProducter(tad.getTProducter());
					mt.setMedname(tad.getTMedicine().getName());
					mt.setComeprice(tad.getPrice());
					mt.setShengyuliang(tad.getNum());
					mt.setProducttime(d2);
					mt.setValuetime(d3);
					medicinefatoryService.insMedicinefatory(mt);
				}
			}
			allorderService.uptAllorder(allorder);
		}
		if (allorder.getOrdertype() == 1 || allorder.getOrdertype() == 2)
			return "AllorderList";
		return "AllorderList";
	}

	private List<TAllorder> allorderList;

	static String type;

	public List<TAllorder> getAllorderList() {
		return allorderList;
	}

	public void setAllorderList(List<TAllorder> allorderList) {
		this.allorderList = allorderList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		AllorderAction.type = type;
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
	public String ListAllorder() {
		this.pageBean = allorderService.queryForPage(10, page, allorder, type);
		// TODO 2018-5-5
		DebugUtil.debugInfo("2018-5-5->" + type);
		getSession().setAttribute("type", type);
		allorderList = pageBean.getList();// 有分页的获取列表
		if (type.equals("all"))
			return "AllList";
		return "toList";
	}

	public String getAllorderA() {
		allorder = allorderService.getAAllorder(allorder);
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

	public String DelMoreAllorder() {
		String ids[] = ID.split(",");
		for (int i = 0; i < ids.length; i++) {
			int j = Integer.parseInt(ids[i]);
			TAllorder order = new TAllorder();
			order.setId(j);
			allorderService.delAllorder(order);
		}
		return "AllorderList";
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

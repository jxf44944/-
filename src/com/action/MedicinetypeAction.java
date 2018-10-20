package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.entity.TMedicinetype;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IMedicinetypeService;
import com.util.DebugUtil;
import com.util.PageBean;

public class MedicinetypeAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private TMedicinetype medicinetype;
	
	private IMedicinetypeService medicinetypeService;

	@Resource(name="medicinetypeService")
	public void setMedicinetypeService(IMedicinetypeService MedicinetypeService) {
		this.medicinetypeService = MedicinetypeService;
	}

	public TMedicinetype getMedicinetype() {
		return medicinetype;
	}

	public void setMedicinetype(TMedicinetype Medicinetype) {
		this.medicinetype = Medicinetype;
	}

/*	// 跳转新增页面
	public String toAddProduct() {
		return "toAdd";
	}*/
	public String toAddMedicinetype(){
		return "success";
	}
	// 新增提交
	public String AddMedicinetype() {
		medicinetypeService.insMedicinetype(medicinetype);
		return "MedicinetypeList";
	}

	public String DelMedicinetype() {
		medicinetypeService.delMedicinetype(medicinetype);
		return "MedicinetypeList";
	}

	public String UpdateMedicinetype() {
		medicinetypeService.uptMedicinetype(medicinetype);
		return "MedicinetypeList";
	}
	
	private List<TMedicinetype> MedicinetypeList;
	
	public List<TMedicinetype> getMedicinetypeList() {
		return MedicinetypeList;
	}

	public void setMedicinetypeList(List<TMedicinetype> MedicinetypeList) {
		this.MedicinetypeList = MedicinetypeList;
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
	public String ListMedicinetype() {
		this.pageBean=medicinetypeService.queryForPage(10, page, medicinetype,"");
		MedicinetypeList = pageBean.getList();//有分页的获取列表
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
	public String SearchMedicinetype() {
		try {
			hpvalue = new String(hpvalue.getBytes("iso8859-1"), "UTF-8");
			DebugUtil.debugInfo(hpvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql="where protypename like '%"+hpvalue+"%' or remark like '%"+hpvalue+"%'";
		this.pageBean=medicinetypeService.queryForPage(10, page, medicinetype,sql);
		MedicinetypeList = pageBean.getList();//有分页的获取列表
		return "toList";
	}

	public String getMedicinetypeA() {
		medicinetype =medicinetypeService.getAMedicinetype(medicinetype);
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
	public String DelMoreMedicinetype() {
		String ids[]=ID.split(",");
		for(int i=0;i<ids.length;i++){
			int j=Integer.parseInt(ids[i]);
			TMedicinetype cc=new TMedicinetype();
			cc.setProtypeid(j);
			medicinetypeService.delMedicinetype(cc);
		}
		return "MedicinetypeList";
	}
}

package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.entity.THospital;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IHospitalService;
import com.util.DebugUtil;
import com.util.PageBean;

public class HospitalAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private THospital hospital;
	
	private IHospitalService hospitalService;

	@Resource(name="hospitalService")
	public void setHospitalService(IHospitalService HospitalService) {
		this.hospitalService = HospitalService;
	}

	public THospital getHospital() {
		return hospital;
	}

	public void setHospital(THospital Hospital) {
		this.hospital = Hospital;
	}

/*	// 跳转新增页面
	public String toAddProduct() {
		return "toAdd";
	}*/
	public String toAddHospital(){
		return "success";
	}
	// 新增提交
	public String AddHospital() {
		hospitalService.insHospital(hospital);
		return "HospitalList";
	}

	public String DelHospital() {
		hospitalService.delHospital(hospital);
		return "HospitalList";
	}

	public String UpdateHospital() {
		hospitalService.uptHospital(hospital);
		return "HospitalList";
	}
	
	private List<THospital> HospitalList;
	
	public List<THospital> getHospitalList() {
		return HospitalList;
	}

	public void setHospitalList(List<THospital> HospitalList) {
		this.HospitalList = HospitalList;
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
			HospitalAction.type = type;
		}
	@SuppressWarnings("unchecked")
	public String ListHospital() {
		this.pageBean=hospitalService.queryForPage(10, page, hospital,"");
		HospitalList = pageBean.getList();//有分页的获取列表
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
	public String SearchHospital() {
		try {
			hpvalue = new String(hpvalue.getBytes("iso8859-1"), "UTF-8");
			DebugUtil.debugInfo(hpvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql="where name like '%"+hpvalue+"%' or manager like '%"+hpvalue+"%' or"+
				" phone like '%"+hpvalue+"%' or adress like '%"+hpvalue+"%'";
		this.pageBean=hospitalService.queryForPage(10, page, hospital,sql);
		HospitalList = pageBean.getList();//有分页的获取列表
		return "toList";
	}
	
	public String getHospitalA() {
		hospital =hospitalService.getAHospital(hospital);
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
	public String DelMoreHospital() {
		String ids[]=ID.split(",");
		for(int i=0;i<ids.length;i++){
			int j=Integer.parseInt(ids[i]);
			THospital hpl=new THospital();
			hpl.setId(j);
			hospitalService.delHospital(hpl);
		}
		return "HospitalList";
	}
}

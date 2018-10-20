package com.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import com.entity.TProducter;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IProducterService;
import com.util.DebugUtil;
import com.util.PageBean;

public class ProducterAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5738902705137420783L;

	private TProducter producter;
	
	private IProducterService producterService;

	@Resource(name="producterService")
	public void setProducterService(IProducterService ProducterService) {
		this.producterService = ProducterService;
	}

	public TProducter getProducter() {
		return producter;
	}

	public void setProducter(TProducter Producter) {
		this.producter = Producter;
	}

/*	// 跳转新增页面
	public String toAddProduct() {
		return "toAdd";
	}*/
	public String toAddProducter(){
		return "success";
	}
	// 新增提交
	public String AddProducter() {
		producterService.insProducter(producter);
		return "ProducterList";
	}

	public String DelProducter() {
		producterService.delProducter(producter);
		return "ProducterList";
	}

	public String UpdateProducter() {
		producterService.uptProducter(producter);
		return "ProducterList";
	}
	
	private List<TProducter> ProducterList;
	
	public List<TProducter> getProducterList() {
		return ProducterList;
	}

	public void setProducterList(List<TProducter> ProducterList) {
		this.ProducterList = ProducterList;
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
			ProducterAction.type = type;
		}
	
	@SuppressWarnings("unchecked")
	public String ListProducter() {
		this.pageBean=producterService.queryForPage(10, page, producter,"");
		ProducterList = pageBean.getList();//有分页的获取列表
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
	public String SearchProducter() {
		try {
			hpvalue = new String(hpvalue.getBytes("iso8859-1"), "UTF-8");
			DebugUtil.debugInfo(hpvalue);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String sql="where name like '%"+hpvalue+"%' or adress like '%"+hpvalue+"%' or"+
				" code like '%"+hpvalue+"%' or phone like '%"+hpvalue+"%'";
		this.pageBean=producterService.queryForPage(10, page, producter,sql);
		ProducterList = pageBean.getList();//有分页的获取列表
		return "toList";
	}

	public String getProducterA() {
		producter = producterService.getAProducter(producter);
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
	public String DelMoreProducter() {
		String ids[]=ID.split(",");
		for(int i=0;i<ids.length;i++){
			int j=Integer.parseInt(ids[i]);
			TProducter cc=new TProducter();
			cc.setId(j);
			producterService.delProducter(cc);
		}
		return "ProducterList";
	}
}

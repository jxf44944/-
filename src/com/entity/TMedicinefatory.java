package com.entity;

/**
 * TMedicinefatory entity. @author MyEclipse Persistence Tools
 */

public class TMedicinefatory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1474456318831778200L;
	// Fields

	private Integer id;
	private TMedicine TMedicine;
	private TProducter TProducter;
	private String medname;
	private String comeprice;
	private String sellpricenow;
	private String sellpricebef;
	private String updatetime;
	private String producttime;
	private String valuetime;
	private String shengyuliang;
	private String jinhuoliang;

	// Constructors

	/** default constructor */
	public TMedicinefatory() {
	}

	/** minimal constructor */
	public TMedicinefatory(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TMedicinefatory(Integer id, TMedicine TMedicine,
			TProducter TProducter, String medname, String comeprice,
			String sellpricenow, String sellpricebef, String updatetime,
			String producttime, String valuetime, String shengyuliang,
			String jinhuoliang) {
		this.id = id;
		this.TMedicine = TMedicine;
		this.TProducter = TProducter;
		this.medname = medname;
		this.comeprice = comeprice;
		this.sellpricenow = sellpricenow;
		this.sellpricebef = sellpricebef;
		this.updatetime = updatetime;
		this.producttime = producttime;
		this.valuetime = valuetime;
		this.shengyuliang = shengyuliang;
		this.jinhuoliang = jinhuoliang;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TMedicine getTMedicine() {
		return this.TMedicine;
	}

	public void setTMedicine(TMedicine TMedicine) {
		this.TMedicine = TMedicine;
	}

	public TProducter getTProducter() {
		return this.TProducter;
	}

	public void setTProducter(TProducter TProducter) {
		this.TProducter = TProducter;
	}

	public String getMedname() {
		return this.medname;
	}

	public void setMedname(String medname) {
		this.medname = medname;
	}

	public String getComeprice() {
		return this.comeprice;
	}

	public void setComeprice(String comeprice) {
		this.comeprice = comeprice;
	}

	public String getSellpricenow() {
		return this.sellpricenow;
	}

	public void setSellpricenow(String sellpricenow) {
		this.sellpricenow = sellpricenow;
	}

	public String getSellpricebef() {
		return this.sellpricebef;
	}

	public void setSellpricebef(String sellpricebef) {
		this.sellpricebef = sellpricebef;
	}

	public String getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getProducttime() {
		return this.producttime;
	}

	public void setProducttime(String producttime) {
		this.producttime = producttime;
	}

	public String getValuetime() {
		return this.valuetime;
	}

	public void setValuetime(String valuetime) {
		this.valuetime = valuetime;
	}

	public String getShengyuliang() {
		return this.shengyuliang;
	}

	public void setShengyuliang(String shengyuliang) {
		this.shengyuliang = shengyuliang;
	}

	public String getJinhuoliang() {
		return this.jinhuoliang;
	}

	public void setJinhuoliang(String jinhuoliang) {
		this.jinhuoliang = jinhuoliang;
	}

	@Override
	public String toString() {
		return "TMedicinefatory [id=" + id + ", medname=" + medname + ", comeprice=" + comeprice + ", sellpricenow=" + sellpricenow
				+ ", sellpricebef=" + sellpricebef + ", updatetime=" + updatetime + ", producttime=" + producttime + ", valuetime=" + valuetime
				+ ", shengyuliang=" + shengyuliang + ", jinhuoliang=" + jinhuoliang + "]";
	}



}
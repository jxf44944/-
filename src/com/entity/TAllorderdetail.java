package com.entity;

/**
 * TAllorderdetail entity. @author MyEclipse Persistence Tools
 */

public class TAllorderdetail implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 3040624965428702252L;
	private Integer id;
	private TMedicine TMedicine;
	private TProducter TProducter;
	private TAllorder TAllorder;
	private String price;//价格
	private String num;
	private String sum;

	// Constructors

	/** default constructor */
	public TAllorderdetail() {
	}

	/** full constructor */
	public TAllorderdetail(TMedicine TMedicine, TProducter TProducter,
			TAllorder TAllorder, String price, String num, String sum) {
		this.TMedicine = TMedicine;
		this.TProducter = TProducter;
		this.TAllorder = TAllorder;
		this.price = price;
		this.num = num;
		this.sum = sum;
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

	public TAllorder getTAllorder() {
		return this.TAllorder;
	}

	public void setTAllorder(TAllorder TAllorder) {
		this.TAllorder = TAllorder;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSum() {
		return this.sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "TAllorderdetail [id=" + id + ", price=" + price + ", num="
				+ num + ", sum=" + sum + "]";
	}
	
}
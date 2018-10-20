package com.entity;

/**
 * TMedpromiddle entity. @author MyEclipse Persistence Tools
 */

public class TMedpromiddle implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -261140417075184241L;
	private Integer id;
	private TMedicine TMedicine;
	private TProducter TProducter;
	private String price;
	private String prodate;
	private int value;

	// Constructors

	/** default constructor */
	public TMedpromiddle() {
	}

	/** minimal constructor */
	public TMedpromiddle(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public TMedpromiddle(Integer id, TMedicine TMedicine,
			TProducter TProducter, String price,String prodate,int value) {
		this.id = id;
		this.TMedicine = TMedicine;
		this.TProducter = TProducter;
		this.price = price;
		this.prodate=prodate;
		this.value=value;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProdate() {
		return prodate;
	}

	public void setProdate(String prodate) {
		this.prodate = prodate;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TMedpromiddle [id=" + id + ", TMedicine=" + TMedicine
				+ ", TProducter=" + TProducter + ", price=" + price
				+ ", prodate=" + prodate + ", value=" + value + "]";
	}
}
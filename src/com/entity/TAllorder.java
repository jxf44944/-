package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TAllorder entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class TAllorder implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6137603079991377098L;
	private Integer id;
	private THospital THospital;
	private TUser TUser;
	private String ordercode;
	private String sum;
	private String status;
	private String time;
	private Integer ordertype;
	private String orderreason;
	private String paytype;
	private Set TAllorderdetails = new HashSet(0);

	// Constructors

	/** default constructor */
	public TAllorder() {
	}

	/** full constructor */
	public TAllorder(THospital THospital, TUser TUser, String ordercode,
			String sum, String status, String time, Integer ordertype,
			String orderreason, String paytype, Set TAllorderdetails) {
		this.THospital = THospital;
		this.TUser = TUser;
		this.ordercode = ordercode;
		this.sum = sum;
		this.status = status;
		this.time = time;
		this.ordertype = ordertype;
		this.orderreason = orderreason;
		this.paytype = paytype;
		this.TAllorderdetails = TAllorderdetails;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public THospital getTHospital() {
		return this.THospital;
	}

	public void setTHospital(THospital THospital) {
		this.THospital = THospital;
	}

	public TUser getTUser() {
		return this.TUser;
	}

	public void setTUser(TUser TUser) {
		this.TUser = TUser;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getSum() {
		return this.sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getOrdertype() {
		return this.ordertype;
	}

	public void setOrdertype(Integer ordertype) {
		this.ordertype = ordertype;
	}

	public String getOrderreason() {
		return this.orderreason;
	}

	public void setOrderreason(String orderreason) {
		this.orderreason = orderreason;
	}

	public String getPaytype() {
		return this.paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}

	public Set getTAllorderdetails() {
		return this.TAllorderdetails;
	}

	public void setTAllorderdetails(Set TAllorderdetails) {
		this.TAllorderdetails = TAllorderdetails;
	}


}
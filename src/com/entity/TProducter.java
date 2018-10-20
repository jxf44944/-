package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TProducter entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class TProducter implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988777625155681187L;
	private Integer id;
	private String name;
	private String adress;
	private String code;
	private String phone;
	private String time;
	private Set TAllorderdetails = new HashSet(0);
	private Set TMedicinefatories = new HashSet(0);
	private Set TMedpromiddles = new HashSet(0);

	// Constructors

	/** default constructor */
	public TProducter() {
	}

	/** full constructor */
	public TProducter(String name, String adress, String code, String phone,
			String time, Set TAllorderdetails, Set TMedicinefatories,
			Set TMedpromiddles) {
		this.name = name;
		this.adress = adress;
		this.code = code;
		this.phone = phone;
		this.time = time;
		this.TAllorderdetails = TAllorderdetails;
		this.TMedicinefatories = TMedicinefatories;
		this.TMedpromiddles = TMedpromiddles;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set getTAllorderdetails() {
		return this.TAllorderdetails;
	}

	public void setTAllorderdetails(Set TAllorderdetails) {
		this.TAllorderdetails = TAllorderdetails;
	}

	public Set getTMedicinefatories() {
		return this.TMedicinefatories;
	}

	public void setTMedicinefatories(Set TMedicinefatories) {
		this.TMedicinefatories = TMedicinefatories;
	}

	public Set getTMedpromiddles() {
		return this.TMedpromiddles;
	}

	public void setTMedpromiddles(Set TMedpromiddles) {
		this.TMedpromiddles = TMedpromiddles;
	}

	@Override
	public String toString() {
		return "TProducter [id=" + id + ", name=" + name + ", adress=" + adress
				+ ", code=" + code + ", phone=" + phone + ", time=" + time
				+ "]";
	}


}
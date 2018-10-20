package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * THospital entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class THospital implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8079339989553041349L;
	private Integer id;
	private String name;
	private String adress;
	private String phone;
	private String time;
	private String manager;
	private Set TAllorders = new HashSet(0);

	// Constructors

	/** default constructor */
	public THospital() {
	}

	/** full constructor */
	public THospital(String name, String adress, String phone, String time,
			String manager, Set TAllorders) {
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.time = time;
		this.manager = manager;
		this.TAllorders = TAllorders;
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

	public String getManager() {
		return this.manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Set getTAllorders() {
		return this.TAllorders;
	}

	public void setTAllorders(Set TAllorders) {
		this.TAllorders = TAllorders;
	}



}
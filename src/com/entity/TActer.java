package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TActer entity. @author MyEclipse Persistence Tools
 */

public class TActer implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8974670699993603056L;
	private Integer acterid;
	private String actername;
	@SuppressWarnings("unchecked")
	private Set TMiddles = new HashSet(0);
	@SuppressWarnings("unchecked")
	private Set TUsers = new HashSet(0);

	// Constructors

	/** default constructor */
	public TActer() {
	}

	/** full constructor */
	@SuppressWarnings("unchecked")
	public TActer(String actername, Set TMiddles, Set TUsers) {
		this.actername = actername;
		this.TMiddles = TMiddles;
		this.TUsers = TUsers;
	}

	// Property accessors

	public Integer getActerid() {
		return this.acterid;
	}

	public void setActerid(Integer acterid) {
		this.acterid = acterid;
	}

	public String getActername() {
		return this.actername;
	}

	public void setActername(String actername) {
		this.actername = actername;
	}

	@SuppressWarnings("unchecked")
	public Set getTMiddles() {
		return this.TMiddles;
	}

	@SuppressWarnings("unchecked")
	public void setTMiddles(Set TMiddles) {
		this.TMiddles = TMiddles;
	}

	@SuppressWarnings("unchecked")
	public Set getTUsers() {
		return this.TUsers;
	}

	@SuppressWarnings("unchecked")
	public void setTUsers(Set TUsers) {
		this.TUsers = TUsers;
	}

	

}
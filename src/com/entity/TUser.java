package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class TUser implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6195856165487425334L;
	private Integer id;
	private TActer TActer;
	private String username;
	private String name;
	private String password;
	private String phone;
	private String adress;
	private String qq;
	private String email;
	private String remark;
	private Set TAllorders = new HashSet(0);

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** full constructor */
	public TUser(TActer TActer, String username, String name, String password,
			String phone, String adress, String qq, String email,
			String remark, Set TAllorders) {
		this.TActer = TActer;
		this.username = username;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.adress = adress;
		this.qq = qq;
		this.email = email;
		this.remark = remark;
		this.TAllorders = TAllorders;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TActer getTActer() {
		return this.TActer;
	}

	public void setTActer(TActer TActer) {
		this.TActer = TActer;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getTAllorders() {
		return this.TAllorders;
	}

	public void setTAllorders(Set TAllorders) {
		this.TAllorders = TAllorders;
	}


}
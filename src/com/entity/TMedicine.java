package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TMedicine entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class TMedicine implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 620929333249631474L;
	private Integer id;
	private TMedicinetype TMedicinetype;
	private String number;
	private String name;
	private String guige;
	private String danwei;
	private String othername;
	private String time;
	private Set TAllorderdetails = new HashSet(0);
	private Set TMedicinefatories = new HashSet(0);
	private Set TMedpromiddles = new HashSet(0);

	// Constructors

	/** default constructor */
	public TMedicine() {
	}

	/** full constructor */
	public TMedicine(TMedicinetype TMedicinetype, String number, String name,
			String guige, String danwei, String othername, String time,
			Set TAllorderdetails, Set TMedicinefatories, Set TMedpromiddles) {
		this.TMedicinetype = TMedicinetype;
		this.number = number;
		this.name = name;
		this.guige = guige;
		this.danwei = danwei;
		this.othername = othername;
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

	public TMedicinetype getTMedicinetype() {
		return this.TMedicinetype;
	}

	public void setTMedicinetype(TMedicinetype TMedicinetype) {
		this.TMedicinetype = TMedicinetype;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuige() {
		return this.guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}

	public String getDanwei() {
		return this.danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	public String getOthername() {
		return this.othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
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
		return "TMedicine [id=" + id + ", number=" + number + ", name=" + name
				+ ", guige=" + guige + ", danwei=" + danwei + ", othername="
				+ othername + ", time=" + time + "]";
	}

}
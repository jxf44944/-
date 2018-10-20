package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TMedicinetype entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class TMedicinetype implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -515361778800916230L;
	private Integer protypeid;
	private String protypename;
	private String time;
	private String remark;
	private Set TMedicines = new HashSet(0);

	// Constructors

	/** default constructor */
	public TMedicinetype() {
	}

	/** full constructor */
	public TMedicinetype(String protypename, String time, String remark,
			Set TMedicines) {
		this.protypename = protypename;
		this.time = time;
		this.remark = remark;
		this.TMedicines = TMedicines;
	}

	// Property accessors

	public Integer getProtypeid() {
		return this.protypeid;
	}

	public void setProtypeid(Integer protypeid) {
		this.protypeid = protypeid;
	}

	public String getProtypename() {
		return this.protypename;
	}

	public void setProtypename(String protypename) {
		this.protypename = protypename;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Set getTMedicines() {
		return this.TMedicines;
	}

	public void setTMedicines(Set TMedicines) {
		this.TMedicines = TMedicines;
	}

}
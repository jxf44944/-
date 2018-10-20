package com.entity;

/**
 * TMiddle entity. @author MyEclipse Persistence Tools
 */

public class TMiddle implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -4034163697712431862L;
	private Integer middleid;
	private TActer TActer;
	private TLimit TLimit;

	// Constructors

	/** default constructor */
	public TMiddle() {
	}

	/** full constructor */
	public TMiddle(TActer TActer, TLimit TLimit) {
		this.TActer = TActer;
		this.TLimit = TLimit;
	}

	// Property accessors

	public Integer getMiddleid() {
		return this.middleid;
	}

	public void setMiddleid(Integer middleid) {
		this.middleid = middleid;
	}

	public TActer getTActer() {
		return this.TActer;
	}

	public void setTActer(TActer TActer) {
		this.TActer = TActer;
	}

	public TLimit getTLimit() {
		return this.TLimit;
	}

	public void setTLimit(TLimit TLimit) {
		this.TLimit = TLimit;
	}



}
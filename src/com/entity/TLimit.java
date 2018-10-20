package com.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * TLimit entity. @author MyEclipse Persistence Tools
 */
@SuppressWarnings("unchecked")
public class TLimit implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6237332244397912386L;
	private Integer limitid;
	private String limitname;
	private String url;
	private Integer rank;
	private Set TMiddles = new HashSet(0);

	// Constructors

	/** default constructor */
	public TLimit() {
	}

	/** full constructor */
	public TLimit(String limitname, String url, Integer rank, Set TMiddles) {
		this.limitname = limitname;
		this.url = url;
		this.rank = rank;
		this.TMiddles = TMiddles;
	}

	// Property accessors

	public Integer getLimitid() {
		return this.limitid;
	}

	public void setLimitid(Integer limitid) {
		this.limitid = limitid;
	}

	public String getLimitname() {
		return this.limitname;
	}

	public void setLimitname(String limitname) {
		this.limitname = limitname;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Set getTMiddles() {
		return this.TMiddles;
	}

	public void setTMiddles(Set TMiddles) {
		this.TMiddles = TMiddles;
	}



}
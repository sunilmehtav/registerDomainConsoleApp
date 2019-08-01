package com.neustar.model;

public class CartItem {
	
	private String domain;
	private Integer noOfYears;
	
	public CartItem(String domain, Integer noOfYears) {
		super();
		this.domain = domain;
		this.noOfYears = noOfYears;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Integer getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(Integer noOfYears) {
		this.noOfYears = noOfYears;
	}
	
	
}

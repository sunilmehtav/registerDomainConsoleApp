package com.neustar.model;

public class Model {
	
	private String type;//Zone or Premium
	private String domain;
	private Integer price;
	
	public Model(){}
	
	public Model(String type, String domain, Integer price) {
		super();
		this.type = type;
		this.domain = domain;
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}

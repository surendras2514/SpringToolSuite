package com.spring.FirstSpringDemo;

public class AccountBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AccountBean [name=" + name + "]";
	}
	

}

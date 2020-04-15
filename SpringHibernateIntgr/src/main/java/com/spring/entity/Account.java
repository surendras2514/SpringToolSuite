package com.spring.entity;

public class Account {
	private int id;
	private String holder;
	private double balance;
	
	

	public Account() {
		super();
	}
	public Account(int id, String holder, double balance) {
		super();
		this.id = id;
		this.holder = holder;
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHolder() {
		return holder;
	}
	public void setHolder(String holder) {
		this.holder = holder;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", holder=" + holder + ", balance=" + balance + "]";
	}
	
	
	

}

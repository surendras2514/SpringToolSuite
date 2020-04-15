package com.spring.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	
	@GeneratedValue
	@Column(name = "ID")
	private int id;
	
	@Column(name = "Acc holder")
	private String holder;
	
	@Column(name = "balance")
	private double balance;
	
	
	

	public Account() {
	
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
	
	
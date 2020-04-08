package com.RESTAPI.assignment;

public class User {

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private int phone;
	
	
	
	
	public User(String firstname2, String lastname2, String username2, String password2, String email2, int phone2) {
		// TODO Auto-generated constructor stub
		this.firstname = firstname2;
		this.lastname = lastname2;
		this.username = username2;
		this.password = password2;
		this.email = email2;
		this.phone = phone2;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	
}

package com.spring.json;

public class Message {
	
	private long id;
	private String customerName;
	private String ownerName;
	private String message ;
	private String postid;
	
	
	
	public Message() {
		super();
	}
	public Message(long id, String customerName, String ownerName, String message, String postid) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.ownerName = ownerName;
		this.message = message;
		this.postid = postid;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", customerName=" + customerName + ", ownerName=" + ownerName + ", message="
				+ message + ", postid=" + postid + "]";
	}
}

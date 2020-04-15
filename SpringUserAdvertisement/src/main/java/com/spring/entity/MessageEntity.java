package com.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE_TABLE")
public class MessageEntity {
	
	@GeneratedValue
	@Id
	@Column(name="id")
	private long id;
	
	@Column(name="Customer")
	private String customerName;
	
	@Column(name="Owner")
	private String ownerName;
	
	@Column(name="Message")
	private String message ;
	
	@Column(name="postid")
	private String postid;
	
	
	
	public MessageEntity() {
		
	}
	public MessageEntity( String customerName, String ownerName, String message, String postid) {
		
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

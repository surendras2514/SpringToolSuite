package com.spring.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ADVERTISE_TABLE")
public class AdvertiseEntity {
	
	
	@GeneratedValue
	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="POSTID")
	private String postid;
	
	@Column(name="STATUS")
	private String status;
	
	@Column(name="Uploaded_date")
	private Date date;

	public AdvertiseEntity() {
		super();
	}
	public AdvertiseEntity(String title, String name, String category, String description, String postid, String status,
			Date date) {
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.postid = postid;
		this.status = status;
		this.date = date;
		
	}



	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AdvertiseEntity [id=" + id + ", title=" + title + ", name=" + name + ", category=" + category
				+ ", description=" + description + ", postid=" + postid + ", status=" + status + "]";
	}
	
	
	

}

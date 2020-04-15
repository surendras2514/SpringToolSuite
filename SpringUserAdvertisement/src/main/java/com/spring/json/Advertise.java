package com.spring.json;

import java.sql.Date;

public class Advertise {
	private long id;
	private String title;
	private String name;
	private String category;
	private String description;
	private String postid;	
	private String status;
	private Date date;
	
	
	public Advertise() {
		
	}


	public Advertise(long id, String title, String name, String category, String description, String postid,
			String status, Date date) {
		super();
		this.id = id;
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
		return "Advertise [id=" + id + ", title=" + title + ", name=" + name + ", category=" + category
				+ ", description=" + description + ", postid=" + postid + ", status=" + status + "]";
	}
	

	
	

}

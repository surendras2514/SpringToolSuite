package com.spring.FirstSpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmployeeBean {

	private String name;
	
	@Autowired
	@Qualifier("project_1")
	private ProjectBean project;
	
	public EmployeeBean() {
	}

	public EmployeeBean(ProjectBean project) {
		this.project = project;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProjectBean getProject() {
		return project;
	}
	public void setProject(ProjectBean project) {
		this.project = project;
	}
}

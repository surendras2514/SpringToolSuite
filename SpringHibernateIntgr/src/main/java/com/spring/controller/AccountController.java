package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.spring.services.Accountservice;

// @RestController
public class AccountController {
	
	// @Autowired
	private Accountservice accountService;
	
	

}


/*
@RequestMapping(value="/employee", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return "{ \"result\": \"Success\"}";
	}
*/
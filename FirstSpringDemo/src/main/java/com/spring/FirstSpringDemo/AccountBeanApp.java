package com.spring.FirstSpringDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountBeanApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("Beans_simple.xml");
	AccountBean ebean = (AccountBean)iocContainer.getBean("account");
	System.out.println("Project Name: " + ebean.getName());


	}

}

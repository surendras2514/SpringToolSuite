package mySpring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.FirstSpringDemo.EmployeeBean;

public class AccountBean1App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("myBeans.xml");
	AccountBean1 ebean = (AccountBean1)iocContainer.getBean("account1");
	System.out.println("Project Name: " + ebean.getName());
	System.out.println("Project id: " + ebean.getId());
	
	iocContainer.registerShutdownHook();
	//System.out.println("Bean Destroying");
	
	}

}

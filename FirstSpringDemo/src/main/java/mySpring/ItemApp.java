package mySpring;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext iocContainer = 
				new ClassPathXmlApplicationContext("items.xml");
		double sum=0;
	//Item ebean = (Item)iocContainer.getBean("item1");
	//Item ebean = (Item)iocContainer.getBeansOfType(Item.class);
		Map<String,Item> beanMap= (Map<String, Item>)iocContainer.getBeansOfType(Item.class);
		for(String s1:beanMap.keySet()) {
			Item item=beanMap.get(s1);
			sum=sum+item.getPrice();
		}
		System.out.println(sum);
	}

}

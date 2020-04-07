package mySpring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class AccountBean1 implements BeanNameAware,InitializingBean,DisposableBean {
	private String name;
	private String id;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "AccountBean1 [name=" + name + ", id=" + id + "]";
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	public void afterAllMethods() {
		System.out.println("Executing init-methods ");
	}
	public void destroyBean() {
		System.out.println("Destroying ioc bean");
	}
	public void setBeanName(String name) {
		System.out.println("The bean name is:"+ name);
		
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("It will now define the bean: "+beanFactory);
		
	}
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("Class Loader: "+classLoader);
		
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside afterPropertiesSet()");
		
	}
	public void destroy() throws Exception {
		System.out.println("Implements Disposable bean");
		
	}
	
	

}

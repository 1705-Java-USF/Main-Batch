package com.revature.bean;

import java.io.Serializable;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class GenericBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, DisposableBean,
		InitializingBean, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9219787712018606585L;
	private String secret;
	private String beanName; // IMPORTANT, caseing and spelling matter!
								// consider beanName a keyword, if it helps.

	//Provided by you, the viewer
	public GenericBean() {
		System.out.println("STEP 1: Instantiating");
	}

	//Provided by InitializingBean interface
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("STEP 7: Properties set for: " + beanName);

	}

	//Provided by DisposableBean interface
	@Override
	public void destroy() throws Exception {
		System.out.println("STEP 10: Destroying: " + beanName);

	}

	//Provided by ApplicationContextAware interface
	@Override
	public void setApplicationContext(ApplicationContext app) throws BeansException {
		System.out.println("STEP 5: Setting application context: " + app);

	}

	//Provided by BeanFactoryAware
	@Override
	public void setBeanFactory(BeanFactory bf) throws BeansException {
		System.out.println("STEP 4: BeanFactoryAware: " + bf);

	}
	
	//Provided by BeanNameAware
	@Override
	public void setBeanName(String beanName) {
		System.out.println("STEP 3: BeanNameAware: " + (this.beanName = beanName));
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
		System.out.println("STEP 2: Populating properties");
	}
	
	public String getBeanName(){
		return beanName;
	}
	
	public void checkOutThisCustomInit(){
		System.out.println("STEP 8: Custom init method");
	}
	
	public void whoaCustomDestroy(){
		System.out.println("STEP 11: Custom destroy");
	}
}

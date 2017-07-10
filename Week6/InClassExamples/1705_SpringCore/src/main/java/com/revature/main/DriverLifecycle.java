package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.bean.GenericBean;

public class DriverLifecycle {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle.xml");
		//STEPS 1-9 have finished
		
		System.out.println(context.getBean("genericBean", GenericBean.class).getSecret());
		((AbstractApplicationContext) context).close();
		Thread.sleep(10000);
		//Steps 10-11 Have started/finished
	}

}

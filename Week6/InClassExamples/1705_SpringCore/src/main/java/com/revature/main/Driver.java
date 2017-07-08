package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.bean.HelloBean;

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * ApplicationContext is our Spring Container. It encapsulates all mapped
		 * beans for use in our project.
		 * There are 3 different versions of the ApplicationContext we can use:
		 * -ClassPathXmlApplicationContext: 
		 * 			Create instance of container and configure using xml located in project.
		 * -FileSystemXmlApplicationContext
		 * 			Create instance of container and configure using xml on a file system
		 * -XmlWebApplicationContext
		 * 			Create instance of container and configure using xml located on application server
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloBean hb = (HelloBean)context.getBean("helloBean");
		System.out.println(hb.getMessage());
		
		
	}

}

package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.Dao;
import com.revature.dao.SessionFactory;

public class Driver {
	public static void main(String args[]){
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = context.getBean("dao", Dao.class);
		SessionFactory sf = dao.getSessionFactory();
		dao.getSomething("1");
	}
}

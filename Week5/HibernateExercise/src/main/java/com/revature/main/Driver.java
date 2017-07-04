package com.revature.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Driver {

	static SessionFactory sessionFactory;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Driver driver = new Driver();
		sessionFactory = driver.createSessionFactory();

	}
	
	public SessionFactory createSessionFactory(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
		System.out.println("Built Session Factory");
		return sessionFactory;
	}

}

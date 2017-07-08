package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.bean.Person;

public class Driver2 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		Person bob1 = (Person)context.getBean("personBean");
		System.out.println(bob1);
		
		Person bob2 = (Person)context.getBean("personBean");
		bob2.setName("Bobby");
		System.out.println("bob2: " + bob2);
		System.out.println("bob1: " + bob1);
		
		System.out.println("\n=====PROTOTYPE EXAMPLE=====\n");
		
		Person protoBob1 = (Person)context.getBean("personBeanProto");
		Person protoBob2 = (Person)context.getBean("personBeanProto");
		protoBob1.getOccupation().setSalary(75000);
		protoBob2.getOccupation().setSalary(250000);
		System.out.println("Bob1: " + protoBob1);
		System.out.println("Bob2: " + protoBob2);
		
		System.out.println("\n=====AUTOWIRE BYNAME EXAMPLE=====\n");
		
		Person autoBob1 = (Person)context.getBean("personBeanByName");
		System.out.println(autoBob1);
		
		System.out.println("\n=====AUTOWIRE BYTYPE EXAMPLE=====\n");
		
		Person autoBob2 = (Person)context.getBean("personBeanByType");
		System.out.println(autoBob2);
	}

}

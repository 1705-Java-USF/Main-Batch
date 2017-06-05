package com.revature.hmwk1.question7;

import java.util.ArrayList;

public class Driver {
	// Q7. Sort two employees based on their name, department, and age
	// using the Comparator interface

	public static void main(String[] args) {
		// create list of employees and call custom sort
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee("Jane", "Software", 45));
		list.add(new Employee("Alan", "Manager", 49));
		list.add(new Employee("Tim", "Human Resources", 30));
		list.add(new Employee("Bob", "AppDev", 34));
		list.add(new Employee("Tim", "Manager", 35));
		list.add(new Employee("Alan", "Manager", 32));
		list.sort(new CompareName());
		System.out.println(list);
		list.sort(new CompareDepartment());
		System.out.println(list);
		list.sort(new CompareAge());
		System.out.println(list);
		
	}
}

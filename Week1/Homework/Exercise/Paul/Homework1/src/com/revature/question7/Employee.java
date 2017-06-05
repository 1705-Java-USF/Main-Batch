package com.revature.question7;

import java.util.Comparator;
/*
 * Comparator interface used for Employee class
 * Sorts the order so that when function is called
 * Objects display in the order of name, age, department name
 * 
 */
public class Employee implements Comparator<Employee> {


	private String name;
	private int age;
	private String departmentName;
	
		public String getName() {
		return name;
	}
		/*
		 * getters and setters for the private instances implemented  
		 */
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
		//Override toString() constructor, telling application what to display when 
		//Comparator Interface is called 
		@Override
		public String toString() {
			return "ComparatorInterface [name=" + name + ", age= " + age + ", departmentName="
					+ departmentName + "]";
		}
		
		//constructor to create objects for employee class
		public  Employee(String firstName, int age, String departmentName) {
			this.name = firstName;
			this.age = age;
			this.departmentName = departmentName;
		}
		
		//compare method to compare employees 
		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.compare(e1, e2);
		}
	
}

package com.revature.java_hw.q7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeeSort{

	public static void main(String[] args) {
		//Make an array list with two new employees in it
		List <Employee> l = new ArrayList<>();
		l.add(new Employee("Bobbert", "Accounting", 40));
		l.add(new Employee("Adam", "Management", 30));
		
		//Prints the array before sorting.
		System.out.println("=====Original Order=====");
		for(int i=0; i<l.size(); i++) {
			System.out.println(l.get(i));
		}
		
		//Sort using the ComparatorByName class and print the array
		l.sort(new ComparatorByName());
		System.out.println("\n=====Compare by Name=====");
		for(int i=0; i<l.size(); i++) {
			System.out.println(l.get(i));
		}

		//Sort using the ComparatorByDepartment class and print the array
		l.sort(new ComparatorByDepartment());
		System.out.println("\n=====Compare by Department=====");
		for(int i=0; i<l.size(); i++) {
			System.out.println(l.get(i));
		}

		//Sort using the ComparatorByAge class and print the array
		l.sort(new ComparatorByAge());
		System.out.println("\n=====Compare by Age=====");
		for(int i=0; i<l.size(); i++) {
			System.out.println(l.get(i));
		}
	}
}

//POJO Employee class with name, department, and age.
class Employee {
	private String name;
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
}

//Comparator class that sorts by name
class ComparatorByName implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

//Comparator class that sorts by department
class ComparatorByDepartment implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}

//Comparator class that sorts by age
class ComparatorByAge implements Comparator<Employee>{
	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getAge() < o2.getAge())
			return -1;
		else if( o1.getAge() == o2.getAge())
			return 0;
		else
			return 1;
	}
}

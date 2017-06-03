package com.revature.q7;

import java.util.Comparator;

public class Employee implements Comparator<Employee>{

	private String department;
	private String name;
	private int age;
	
	public Employee(){
		
	}
	
	public Employee(String department, String name, int age) {
		super();
		this.department = department;
		this.name = name;
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
    public String toString() {
        return "Dept: " + department + "\tName: " + name + "\tAge: " + age;
    }

	@Override
	public int compare(Employee o1, Employee o2) {
		
		int i = o1.department.compareTo(o2.department);
		if(i != 0)return i;
		
		i = o1.name.compareTo(o2.name);
		if(i != 0)return i;
		
		return o1.age - o2.age;
	}

}

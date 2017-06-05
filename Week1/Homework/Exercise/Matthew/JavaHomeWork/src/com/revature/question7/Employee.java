package com.revature.question7;

public class Employee {
	private String name; 
	private String department;
	private int age;
	
	public Employee(String name, String department, int age) //Must initialize all variables through constructor
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() { //Getter and setter for name
		return name;
	}

	public void setName(String name) { 
		this.name = name;
	}

	public String getDepartment() { //Getter and setter for Department
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() { //Getter and Setter for Age
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

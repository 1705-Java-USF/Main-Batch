package com.revature.hmwk1.question7;

public class Employee {
	// Pojo employee
	private String name;
	private String department;
	private int age;
	
	public Employee(String nm, String dp, int ag) {
		this.name = nm;
		this.department = dp;
		this.age = ag;
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
		return "{" + name + ", " + department + ", " + age + "}";
	}
}

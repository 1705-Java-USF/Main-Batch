package com.assignment.q7;

import java.util.Comparator;

//Employee POJO 
public class Employee 
{
	private String name;
	private String dep;
	private Integer age;
	
	public Employee()
	{
		this.name = "Default";
		this.dep = "Default";
		this.age = 0;
	}
	
	public Employee(String n, String d, int a)
	{
		this.name = n;
		this.dep = d;
		this.age = a;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "[Name: " + name + ", Dep: " + dep + ", Age: " + age + "]";
	}	

}

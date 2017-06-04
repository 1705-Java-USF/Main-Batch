package com.revature.question7;

public class Person {
	
	private String name;
	private int age;
	private String department;
	// constructor for person
	public Person(String name, int age, String department){
		this.name = name;
		this.age = age;
		this.department = department;
	}
	//get the string name
	public String getName(){
		return name;
	}
	//set the name
	public void setName(String name){
		this.name = name;
	}
	//get the age of the person
	public int getAge(){
		return age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	//get the department 
	public String getDepartment(){
		return department;
	}
	
	public void setDepartment(String department){
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", department =" + department + "]";
	}
	
	//method to compare people
	public int compareTo(Person p) {
		if(this.age < p.age){
			return -1; 
		}
		if(this.age > p.age){
			return 1; 
		}
		return 0; 
	}

}

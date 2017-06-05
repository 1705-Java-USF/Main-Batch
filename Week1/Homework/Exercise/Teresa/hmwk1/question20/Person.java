package com.revature.hmwk1.question20;

public class Person {
	// create pojo to store and retrieve file information
	private String firstName;
	private String lastName;
	private String age;
	private String state;
	
	public Person(String a, String b, String c, String d) {
		this.firstName = a;
		this.lastName = b;
		this.age = c;
		this.state = d;
	}
	
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nAge: " + age + "\nState: " + state;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}

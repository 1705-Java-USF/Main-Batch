package com.assignment.q20;

public class Person 
{
	private String firstName;
	private String lastName;
	private String age;
	private String state;
	
	public void printPerson()
	{
		System.out.println("Name: " + this.firstName + " " + this.lastName);
		System.out.println("Age: " + this.age + " years");
		System.out.println("State: " + this.state);
		System.out.println("\n");
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}

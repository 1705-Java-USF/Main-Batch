package com.revature.question20;

public class Person {
	/*
	 * This class holds name, age and state information
	 * It also provides  a method to print out the information to the console
	 */
	private String name;
	private int age;
	private String state;

	public Person(String name, int age, String state) {
		super();
		this.name = name;
		this.age = age;
		this.state = state;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	/*
	 * Prints the information on the person.
	 */
	public void printPerson() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age + " years");
		System.out.println("State: " + state + " State");
	}

}

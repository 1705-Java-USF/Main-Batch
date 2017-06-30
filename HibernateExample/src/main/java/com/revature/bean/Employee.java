package com.revature.bean;

public class Employee {
	
	/*
	 * This is called the persistent class
	 * 
	 * Typical beans should have the following:
	 * - at least a default constructor/no args constructor
	 * - an identifier property for the primary key for the table
	 * - NOTE: all getters and setters MUST follow the casing and naming convention as follows:
	 * 		get/setPropertyName
	 * 
	 * In order to ensure persistent classes are used, it must be included in your configuration file
	 */
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int salary;
	
	public Employee()
	{
		
	}
	
	public Employee(String firstName, String lastName, String email, int salary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public Employee(int id, String firstName, String lastName, String email, int salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	

}

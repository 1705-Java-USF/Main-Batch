package com.revature.pojos;

public class Employee {

	private int employee_id;
	private String username, password, firstname, lastname, email, title;
	
	public Employee(int id, String user, String pass, String first, String last, String e, String title) {
		this.employee_id = id;
		this.username = user;
		this.password = pass;
		this.firstname = first;
		this.lastname = last;
		this.email = e;
		this.title = title;
	}

	@Override
	public String toString() {
		return title + ": " + firstname + " " + lastname + " HAS ID " + employee_id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}

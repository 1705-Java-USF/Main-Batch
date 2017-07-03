package com.revature.pojos;

public class User {
	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int roleId;
	
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", roleId=" + roleId + "]";
	}
	
	public User(int id, String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}

	public User() {
		super();
	}
	
	//Minimum not null fields
	public User(String username, String password, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.roleId = roleId;
	}
	//Not null fields and email
	public User(String username, String password, String email, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.roleId = roleId;
	}
	//Not null fields and first/last name
	public User(String username, String password, String firstName, String lastName, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.roleId = roleId;
	}
	//Not null fields, first/last name, and email
	public User(String username, String password, String firstName, String lastName, String email, int roleId) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.roleId = roleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	
}

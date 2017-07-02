package com.revature.pojo;

public class Users {
	
	private int id;
	private String username;
	private String password;
	private String fname;
	private String lname;
	private String email;
	private int ur_id;
	
	public Users(int id, String username, String password, String fname, String lname, String email, int ur_id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.ur_id = ur_id;
	}
	
	public Users(int id, String username, String password, int ur_id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.ur_id = ur_id;
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

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUr_id() {
		return ur_id;
	}

	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", fname=" + fname + ", lname="
				+ lname + ", email=" + email + ", ur_id=" + ur_id + "]";
	}
		
}

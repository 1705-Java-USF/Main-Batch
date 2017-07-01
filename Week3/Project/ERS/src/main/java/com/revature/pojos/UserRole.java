package com.revature.pojos;

import org.apache.log4j.Logger;

public class UserRole {
	final static Logger logger = Logger.getLogger(UserRole.class);
	
	private int id;
	private String role;
	
	public UserRole(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [id=" + id + ", role=" + role + "]";
	}
}

package com.revature.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Component
public class User {
	/*
	 * JavaX offers a library that can be used to
	 * automate validation of bean objects.
	 * This will be done via the validator library.
	 */
	
	@NotEmpty(message="Username cannot be empty")
	@Size(min=4, max=20)
	private String username;

	@NotEmpty(message="Password cannot be empty")
	private String password;
	
	
	public User(){
		
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


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
}

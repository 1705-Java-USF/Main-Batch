package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImpl;
import com.revature.pojo.EmployeeObject;

public class ValidateLogin {
	
	public EmployeeObject validateLogin(String username, String pass) {
		
		UserDAO userDao = new UserDAOImpl();  // creating userDAO object
		EmployeeObject person = new EmployeeObject();  // creating person object
		
		// going to UserDAOImpl to check if the username and password are correct, 
		// put it in a person object
		System.out.println("VL 1 -Calling DAO imp to run sql stmt w/ username: " + username);
		person = userDao.selectEmployeeByUsername(username); 
		
		if (username.equals(person.getUser_username()) && pass.equals(person.getUser_password()))
		{
			return person;
		}
		else {
			System.out.println("Validate Login - Received null emp");
			return null;
		}
	}
}
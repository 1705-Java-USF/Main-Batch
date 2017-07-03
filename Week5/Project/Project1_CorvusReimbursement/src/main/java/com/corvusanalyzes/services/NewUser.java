package com.corvusanalyzes.services;

import com.corvusanalyzes.dao.UsersDAO;
import com.corvusanalyzes.dao.UsersDAOInterface;
import com.corvusanalyzes.pojos.User;

public class NewUser {
	
	public void insertNewUser(String username, String password, String firstname, String lastname, String email, String role) {
		UsersDAOInterface users = new UsersDAO();
		User user = new User(username, password, firstname, lastname, email, role);
		users.createUser(user);
	}
}

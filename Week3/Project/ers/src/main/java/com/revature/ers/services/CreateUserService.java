package com.revature.ers.services;

import javax.servlet.http.HttpServletRequest;

import com.revature.ers.DataObjects.User;
import com.revature.ers.dao.Dao;
import com.revature.ers.dao.UserDaoImpl;

public class CreateUserService {

	public static int createUser(HttpServletRequest request)
	{
		Dao<User> udi = new UserDaoImpl();
		User u = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String userRole = request.getParameter("userRole");
		u.setUsername(username);
		u.setPassword(password);
		u.setFirstname(firstname);
		u.setLastname(lastname);
		u.setUserRole(userRole);
		u.setEmail(email);
		return udi.create(u);
		
	}
}

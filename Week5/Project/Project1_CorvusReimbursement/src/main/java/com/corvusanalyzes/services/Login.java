package com.corvusanalyzes.services;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.corvusanalyzes.dao.UsersDAO;
import com.corvusanalyzes.dao.UsersDAOInterface;
import com.corvusanalyzes.pojos.User;

public class Login {
	final static Logger logger = Logger.getRootLogger();
	
	public boolean validateLogin(String username, String password) {
		UsersDAOInterface users = new UsersDAO();
		return password.equals(users.selectPasswordByUsername(username)) ? true : false;
	}
	
	public void setupSession(String username, HttpSession session) {
		UsersDAOInterface users = new UsersDAO();
		User user = users.selectUserByUsername(username);
		setUserToSession(user, session);
		logger.debug("User " + username + " logged in successfully.");
	}
	
	private void setUserToSession(User user, HttpSession session) {
		session.setAttribute("username", user.getUsername());
		session.setAttribute("firstname", user.getFirstname());
		session.setAttribute("lastname", user.getLastname());
		session.setAttribute("email", user.getEmail());
		session.setAttribute("role", user.getRole());
	}
}

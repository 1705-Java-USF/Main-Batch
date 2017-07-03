package com.corvusanalyzes.services;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.corvusanalyzes.dao.UsersDAO;
import com.corvusanalyzes.dao.UsersDAOInterface;

public class UpdateUser {
	public String updateUserCredentials(HttpSession session, String username, String firstname, String lastname, String email, String oldpassword, String newpassword) {
		if(username.isEmpty())
			username = session.getAttribute("username").toString();
		else if(!isUsernameUnique(username))
			return "Username Taken";
		if(firstname.isEmpty())
			firstname = session.getAttribute("firstname").toString();
		if(lastname.isEmpty())
			lastname = session.getAttribute("lastname").toString();
		if(email.isEmpty())
			email = session.getAttribute("email").toString();

		String password = determinePassword(session, oldpassword, newpassword);
		if(password.equals("Old Password Is Incorrect"))
			return password;
		
		UsersDAOInterface users = new UsersDAO();
		users.updateUser(username, password, firstname, lastname, email, session.getAttribute("username").toString());
		session.setAttribute("username", username);
		return "OK";
	}
	
	/* 
	 * If old password was left empty, set current password as password.
	 * If old password != current password, return error.
	 * If old password was filled and correct, set new password as password.
	 */
	private String determinePassword(HttpSession session, String oldpassword, String newpassword) {
		UsersDAOInterface users = new UsersDAO();
		String username = session.getAttribute("username").toString();
		if(oldpassword.isEmpty())
			return users.selectPasswordByUsername(username);
		else if(!doesOldPasswordMatchCurrent(username, oldpassword))
			return "Old Password Is Incorrect";
		else
			return newpassword;
	}

	public boolean isUsernameUnique(String username) {
		UsersDAOInterface users = new UsersDAO();
		List<String> usernames = new ArrayList<>();
		usernames = users.selectAllUsernames();
		
		for(String u : usernames) {
			if(username.equals(u)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean doesOldPasswordMatchCurrent(String username, String oldpassword) {
		UsersDAOInterface users = new UsersDAO();
		String currentPassword = users.selectPasswordByUsername(username);
		if(currentPassword.equals(oldpassword)) return true;
		else return false;
	}
}

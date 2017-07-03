package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.User;

public class Login {

	UserDao userDao = new UserDaoImpl();
	public boolean validateLogin(String username, String password) {
		MyLogger.logger.trace("Validating login for " + username);
		User user = userDao.selectUserByUsername(username);
		return (password.equals(user.getPassword()) && user.getRoleId() != userDao.getRoleId("Fired"));
	}
}

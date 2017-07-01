package com.revature.services;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.pojos.User;

public class Login {
	public User validateLogin(String user, String pass){
		UserDAO uDao = new UserDAOImp();
		
		User u = uDao.selectFromLogin(user, pass);
		
		return u;
	}
}

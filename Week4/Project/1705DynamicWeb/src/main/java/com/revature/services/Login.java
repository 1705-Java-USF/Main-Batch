package com.revature.services;

import com.revature.pojo.Users;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImp;

public class Login {

	public boolean validateLogin(String user, String pass) {

		UserDao dao = new UserDaoImp();


		try {
			Users r = dao.selectUsersByUsername(user);
			if ((r.getU_USERNAME()).equals(user) && (r.getU_PASSWORD()).equals(pass)) {
				return true;
			} else {
				
				return false;
			}

		} catch (NullPointerException e) {
			return false;
		}
	}
}

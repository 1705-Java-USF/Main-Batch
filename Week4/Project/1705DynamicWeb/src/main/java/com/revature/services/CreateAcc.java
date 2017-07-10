package com.revature.services;

import java.sql.SQLException;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImp;
import com.revature.pojo.Users;

public class CreateAcc {

	public boolean storeNewUser(String username, String password, String fname, String lname, String email) {
		UserDao dao = new UserDaoImp();

		Users u = new Users(username, password, fname, lname, email);
		if(dao.createUser(u)){
			return true;
		} else{
			return false;
		}
	}
}

package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImp;
import com.revature.pojo.Users;

public class UpdateUser {

	public boolean Updater(String user, String userNew, String pass, String fname, String lname, String email) {
		UserDao dao = new UserDaoImp();

		if (!(pass.isEmpty())) {
			dao.updateUserPass(user, pass);
		}
		if (!(fname.isEmpty())) {
			dao.updateUserFname(user, fname);
		}
		if (!(lname.isEmpty())) {
			dao.updateUserLname(user, lname);
		}
		if (!(email.isEmpty())) {
			dao.updateUserEmail(user, email);
		}
		if (!(userNew.isEmpty())) {
			if (dao.updateUserUsername(user, userNew)) {

			} else {
				return false;
			}

		}
		return true;
	}
}
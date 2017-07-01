package com.revature.services;

import java.sql.Timestamp;

import com.revature.dao.ReimbursementDAO;
import com.revature.dao.ReimbursementDAOImp;
import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOImp;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class Update {

	UserDAO uDao = new UserDAOImp();
	ReimbursementDAO rDao = new ReimbursementDAOImp();
	
	public void createUser(String fname, String lname, String uname, String pass, String email){
		User u = new User(0, uname, pass, fname, lname, email, 1);
		uDao.createUser(u);
	}
	
	public void updatePassword(User u, String password){
		u.setPassword(password);
		uDao.updateUser(u);
	}
	
	public void updateReimbursement(int id, int resolveId, int status){
		Reimbursement r = rDao.selectReimbursementById(id);
		r.setReimb_status(status);
		r.setResolved(new Timestamp(System.currentTimeMillis()));
		r.setResolver_id(resolveId);
		rDao.updateReimbursement(r);
	}
	
	public void promote(int id){
		User u = uDao.selectUserById(id);
		u.setUr_id(2);
		uDao.updateUser(u);
	}
}

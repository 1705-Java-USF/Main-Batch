package com.revature.services;

import java.sql.Timestamp;

import javax.servlet.http.Part;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbusementDaoImp;
import com.revature.pojo.Reimbursement;

public class CreateReim {

	public void storeNewReim(double amount, String desc, int uid, int rtype, Part receipt) {
		ReimbursementDao dao = new ReimbusementDaoImp();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		Reimbursement r = new Reimbursement(amount, desc, timestamp, uid, rtype,receipt);
		dao.createReimbursement(r);
	}
}

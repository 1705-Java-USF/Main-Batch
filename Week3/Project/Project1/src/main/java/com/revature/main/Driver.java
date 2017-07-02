package com.revature.main;

import java.sql.Timestamp;

import com.revature.dao.DaoReimbursementImpl;
import com.revature.dao.DaoUserImp;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.Users;

public class Driver {

	public static void main(String[] args) {
		
		DaoUserImp dao = new DaoUserImp();
		DaoReimbursementImpl dao2 = new DaoReimbursementImpl();
		//Users user = new Users(2, "KingOfTheLand", "lbj23", "LeBron", "James", "theland@yahoo.com", 2);
		//Reimbursement reim = new Reimbursement(1, 86.34, "Limited free on-campus parking parking availability", null, new Timestamp(System.currentTimeMillis()), null, 1, 1, 1, 1);
		//Users receivedUser = dao.selectUserByUsername("SnipeHandles");
		
		//System.out.println(receivedUser.toString());
		//receivedUser.setEmail("sharpshooter88@gmail.com");
		
		//dao.createUser(user);
		//dao.deleteUserByUsername("SnipeHandles");
		//dao.updateUser(receivedUser);
		//dao2.createReim(reim);
	}

}

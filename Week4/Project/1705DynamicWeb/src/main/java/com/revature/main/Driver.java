package com.revature.main;

import java.sql.Timestamp;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbusementDaoImp;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImp;
import com.revature.pojo.Reimbursement;
import com.revature.pojo.Users;


public class Driver {

	public static void main(String[] args) {
		ReimbursementDao dao = new ReimbusementDaoImp();
		UserDao daou = new UserDaoImp();

		/*
		 * Users fc = new Users("Jonathan", "nahh", "jj","jj", "jj");
		 * 
		 * dao.createUser(fc);
		 */

		/*
		 * Users r = dao.selectUsersByUsername("lebron");
		 * System.out.println(r.getU_USERNAME());
		 */

		/* dao.deleteUserByUsername("jkj"); */
		/*
		 * String newU = "Smcud"; String oldU = "it@works";
		 */

		/*
		 * dao.updateUserEmail(oldU, "it@works"); dao.updateUserFname(oldU,
		 * "Sade"); dao.updateUserLname(oldU, "Cudjoe");
		 * dao.updateUserPass(oldU, "jonathan"); dao.updateUserUsername(oldU,
		 * newU);
		 */

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		System.out.println(timestamp);

		// Reimbursement r = new Reimbursement(43.6, "Test", timestamp, 2, 1,
		// "Test");

		// dao.createReimbursement(r);
		// dao.deleteReim(5);
		// dao.denyRequest(3, 4);

		/*List<Users> receivedFCT = daou.selectUsers();
		for (Users f : receivedFCT) {

			System.out.println(
					"ID: \t" + f.getU_ID() + "\nUser:\t" + f.getU_USERNAME() + "\nFname: \t" + f.getU_FIRSTNAME());

		}*/
		
		List<Reimbursement> listr = dao.listAllReimsM(3);
		for (Reimbursement r : listr){
			System.out.println("Reimbursement [R_ID=" + r.getR_ID() + ", R_AMOUNT=" + r.getR_AMOUNT() + ", description=" + r.getDescription() + ", R_Submitted=" + r.getR_Submitted() + ", R_resolved=" + r.getR_resolved() + ", U_ID_AUTHOR="
				+ r.getU_ID_AUTHOR() + ", U_ID_RESOLVER=" + r.getU_ID_RESOLVER() + ", RT_ID=" + r.getRT_ID() + ", RS_ID=" + r.getRS_ID() + "]");
			
		}
		
		
	}

}

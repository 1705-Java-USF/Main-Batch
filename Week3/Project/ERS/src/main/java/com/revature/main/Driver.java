package com.revature.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.*;
import com.revature.pojos.*;

public class Driver {

	final static Logger logger = Logger.getLogger(Driver.class);
	
	public static void main(String[] args) {
		

		System.out.println("======USERS======");
		UserDAO uDao = new UserDAOImp();
		
		List<User> users = uDao.selectUsers();
		for(User u : users){
			System.out.println(u);
		}
		
		//User u = uDao.selectFromLogin("nathanialf", "deleter");
		
		System.out.println("\n======USER ROLES======");
		
		UserRoleDAO urDao = new UserRoleDAOImp();
		
		List<UserRole> roles = urDao.selectUserRoles();
		for(UserRole u : roles){
			System.out.println(u);
		}
		
		/*
		UserRole ur = new UserRole(0, "manager");
		UserRole ur = new UserRole(0, "employee");
		urDao.createUserRole(ur);
		*/
		
		System.out.println("\n======REIMBS======");
		ReimbursementDAO rDao = new ReimbursementDAOImp();
		
		List<Reimbursement> reimbs = rDao.selectReimbursements();
		for(Reimbursement rei : reimbs){
			System.out.println(rei);
		}
		
		
		System.out.println("\n======REIMB STATUS======");
		
		ReimbursementStatusDAO rsDao = new ReimbursementStatusDAOImp();
		/*
		ReimbursementStatus rstat = new ReimbursementStatus(0,"pending");
		rsDao.createReimbursementStatus(rstat);
		*/
		List<ReimbursementStatus> status = rsDao.selectReimbursementStatus();
		for(ReimbursementStatus rs : status){
			System.out.println(rs);
		}
		

		System.out.println("\n======REIMB TYPE======");
		
		ReimbursementTypeDAO rtDao = new ReimbursementTypeDAOImp();
		/*
		ReimbursementType rtype = new ReimbursementType(0,"travel");
		rtDao.createReimbursementType(rtype);
		*/
		List<ReimbursementType> types = rtDao.selectReimbursementTypes();
		for(ReimbursementType rt : types){
			System.out.println(rt);
		}
	}
}

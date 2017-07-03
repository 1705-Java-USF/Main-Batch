package com.revature.test;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.MyLogger;

public class JUnitTesting {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		MyLogger.logger.trace("===Before JUnitTesting===");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		MyLogger.logger.trace("===After JUnitTesting===");
	}

	@Before
	public void setUp() throws Exception {
		MyLogger.logger.trace("===Before Test===");
	}

	@After
	public void tearDown() throws Exception {
		MyLogger.logger.trace("===After Test===");
	}
	
	@Test
	public void testAddUser() {
		MyLogger.logger.trace("===Testing Adding User===");
		UserDao userDao = new UserDaoImpl();
		User user = new User("RandUser", "RandPassword", userDao.getRoleId("Employee"));
		List<User> users = userDao.selectEmployees();
		int originalCount = users.size();
		userDao.createUser(user);
		users = userDao.selectEmployees();
		userDao.deleteUserById(userDao.selectUserByUsername("RandUser").getId());
		assertEquals(originalCount + 1, users.size());
	}
	
	@Test
	public void testAddReimbursement() {
		MyLogger.logger.trace("===Testing Adding Reimbursement===");
		ReimbursementDao reimDao = new ReimbursementDaoImpl();
		Reimbursement reim = new Reimbursement(3.14, "Description", null,
				new Timestamp(System.currentTimeMillis()), 1, 1, 1);
		List<Reimbursement> reims = reimDao.selectReimbursements();
		int originalCount = reims.size();
		reimDao.createReimbursement(reim);
		reims = reimDao.selectReimbursements();
		reimDao.deleteReimbursementById(reims.get(reims.size()-1).getId());
		
		assertEquals(originalCount + 1, reims.size());
	}
}

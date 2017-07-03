package com.revature.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.revature.dao.ReinBurstDao;
import com.revature.dao.ReinBurstDaoImp;
import com.revature.dao.UserDaoImp;
import com.revature.pojo.ErsUser;
import com.revature.pojo.ReinBurst;
import com.revature.service.CreateAccount;
import com.revature.service.GetReinBurst;
import com.revature.service.UserInteract;

public class Test 
{
	static CreateAccount ca;
	static UserInteract ui;
	static UserDaoImp uDao;
	static ErsUser testUser;
	
	static GetReinBurst grb;
	static ReinBurstDaoImp rbd;
	static ReinBurst testRein;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		ui = new UserInteract();
		uDao = new UserDaoImp();
		testUser = new ErsUser(100, "usrname", "pass", "val", "fir", "mail@mail.com", 1);
		uDao.createUserSP(testUser);
		
		grb = new GetReinBurst();
		rbd = new ReinBurstDaoImp();
		testRein = new ReinBurst(1, 12, "submitted", 1, 1, 1);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void userIdTest() 
	{
		assertEquals(new Integer(100), testUser.getuId());
	}
	
	@org.junit.Test
	public void getUser1() 
	{
		
		assertNotNull(uDao.selectAllUsers());
	}
	
	@org.junit.Test
	public void getUser2() 
	{
		assertNotNull(ui.getAllUsers());

	}
	
	@org.junit.Test
	public void reinIdTest() 
	{
		assertEquals(new Integer(12), testRein.getAmmount());
	}
	
	@org.junit.Test
	public void getRein1() 
	{
		
		assertNotNull(grb.getAll(1));
	}
	
	@org.junit.Test
	public void getRein2() 
	{
		assertNotNull(rbd.selectAllReinBurst(1));

	}

}

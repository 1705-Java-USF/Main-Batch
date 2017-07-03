package com.revature.ers.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ers.DataObjects.User;
import com.revature.util.ColumnNameUtil;

public class UserDaoTest {
	Dao<User> dao;
	User outU;
	User inU;
	List<User> inUs;
	String u1;
	String p1;
	String e1;
	String f1;
	String l1;
	String ur1;
	String u2;
	String p2;
	String e2;
	String f2;
	String l2;
	String ur2;
	String u3;
	String p3;
	String e3;
	String f3;
	String l3;
	String ur3;
	String u4;
	String p4;
	String e4;
	String f4;
	String l4;
	String ur4;
	String u5;
	String p5;
	String e5;
	String f5;
	String l5;
	String ur5;
	private Logger logger = Logger.getLogger(UserDaoTest.class);
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new UserDaoImpl();
		outU = new User();
		u1 = "ATestingUserName1";
		p1 = "ATestingPassword1";
		e1 = "TestEmail@test.net1";
		f1 = "ATestingFirstName1";
		l1 = "ATestingLastName1";
		ur1= "employee";
		
		u2 = "ATestingUserName2";
		p2 = "ATestingPassword2";
		e2 = "TestEmail@test.net2";
		f2 = "ATestingFirstName2";
		l2 = "ATestingLastName2";
		ur2= "employee";
		
		u3 = "ATestingUserName3";
		p3 = "ATestingPassword3";
		e3 = "TestEmail@test.net3";
		f3 = "ATestingFirstName3";
		l3 = "ATestingLastName3";
		ur3= "employee";
		
		u4 = "ATestingUserName4";
		p4 = "ATestingPassword4";
		e4 = "TestEmail@test.net4";
		f4 = "ATestingFirstName4";
		l4 = "ATestingLastName4";
		ur4= "employee";
		
		u5 = "ATestingUserName5";
		p5 = "ATestingPassword5";
		e5 = "TestEmail@test.net5";
		f5 = "ATestingFirstName5";
		l5 = "ATestingLastName5";
		ur5= "employee";
		
	}

	@After
	public void tearDown() throws Exception {
		dao = null;
		outU = null;
		inU = null;
		inUs = null;
		u1 = null;
		p1 = null;
		e1 = null;
		f1 = null;
		l1 = null;
		ur1 = null;
		
		u2 = null;
		p2 = null;
		e2 = null;
		f2 = null;
		l2 = null;
		ur2 = null;
		
		u3 = null;
		p3 = null;
		e3 = null;
		f3 = null;
		l3 = null;
		ur3 = null;
		
		u4 = null;
		p4 = null;
		e4 = null;
		f4 = null;
		l4 = null;
		ur4 = null;
	}

	@Test
	public void testCreate()
	{
		logger.debug("test Creating");
		outU.setUsername(u1);
		outU.setPassword(p1);
		outU.setEmail(e1);
		outU.setFirstname(f1);
		outU.setLastname(l1);
		outU.setUserRole(ur1);
		dao.create(outU);
		inUs = dao.selectAll();
		int id = -1;
		for(User u : inUs)
		{
			if(u.equals(outU))
			{
				id = u.getUserId();
				logger.debug("Found user id: " + id);
				dao.deleteById(id); //clean up
				logger.debug("Delete user");
				return;
			}
		}
		fail("User not found");
		
	}
	@Test
	public void testDeleteById()
	{
		logger.debug("testDeleteByID()");
		outU.setUsername(u2);
		outU.setPassword(p2);
		outU.setEmail(e2);
		outU.setFirstname(f2);
		outU.setLastname(l2);
		outU.setUserRole(ur2);
		dao.create(outU);
		int id = -1;
		
		inUs = dao.selectAll();
		for(User u : inUs)
		{
			if(u.equals(outU))
			{
				id = u.getUserId(); 
				logger.debug("found user");
			}
		}
		if(id == -1)
		{
			fail("User not found");
		}
		dao.deleteById(id);
		logger.debug("user deleted");
		inUs = dao.selectAll();
		for(User u : inUs)
		{
			if(u.equals(outU))
			{
				fail("Should be deleted");
			}
		}
		logger.debug("user succesfully deleted");
	}
	@Test
	public void testSelectAll()
	{
		logger.debug("testSelectAll()");
		outU.setUsername(u3);
		outU.setPassword(p3);
		outU.setEmail(e3);
		outU.setFirstname(f3);
		outU.setLastname(l3);
		outU.setUserRole(ur3);
		dao.create(outU);
		inUs = dao.selectAll();
		int id = -1;
		logger.info(inUs.size());
		for(User u : inUs)
		{
			if(u.equals(outU))
			{
				id = u.getUserId();
				dao.deleteById(id); //clean up
				logger.debug("user deleted test succesful");
				return;
			}else
			{
				logger.info(u.toString() + " : " + outU.toString());
			}
		}
		fail("User not found");
	}
	@Test
	public void testSelectByID()
	{
		logger.debug("testSelectByID()");
		inU = dao.selectById(3);
		assertEquals(inU.getUsername(), "username2" );
		assertEquals(inU.getPassword(), "wordpass");
		assertEquals(inU.getFirstname(), "Bob");
		assertEquals(inU.getLastname(), "Billy");
		assertEquals(inU.getEmail(), "bob.billy@fakemail.gov" );
		assertEquals(inU.getUserRole(), "manager" );
		
	}
	@Test
	public void testSelectBy()
	{
		logger.debug("testSelectBy()");
		outU.setUsername(u4);
		outU.setPassword(p4);
		outU.setEmail(e4);
		outU.setFirstname(f4);
		outU.setLastname(l4);
		outU.setUserRole(ur4);
		dao.create(outU);
		Map<String, String> columnValueMap = new HashMap<String, String>();
		columnValueMap.put(ColumnNameUtil.USERNAME, u4);
		columnValueMap.put(ColumnNameUtil.PASSWORD, p4);
		List<User> inUs = dao.selectBy(columnValueMap);
		int id;
		for(User u : inUs)
		{
			logger.warn(u);
			if(u.equals(outU))
			{
				
				id = u.getUserId();
				dao.deleteById(id); //clean up
				logger.debug("user deleted test succesful");
				return;
			}
		}
		fail("User not found");
		
	}
	@Test
	public void testUpdateBy()
	{
		logger.debug("testUpdateBy()");
		outU.setUsername(u5);
		outU.setPassword(p5);
		outU.setEmail(e5);
		outU.setFirstname(f5);
		outU.setLastname(l5);
		outU.setUserRole(ur5);
		dao.create(outU);
		Map<String, String> conditions = new HashMap<String, String>();
		Map<String, String> nameValue = new HashMap<String, String>();
		String conName1 = ColumnNameUtil.USERNAME;
		String conValue1 = u5;
		conditions.put(conName1,  conValue1);
		String name1 = ColumnNameUtil.LASTNAME;
		String value1 = "Bobbert";
		nameValue.put(name1, value1);
		dao.updateBy(nameValue, conditions);
		List<User> inUs = dao.selectBy(conditions);
		int id = -1;
		if(!(inUs.size() > 0) || !inUs.get(0).getLastname().equals("Bobbert"))
		{
			fail("Failure to update row");
			
		}
		id = inUs.get(0).getUserId();
		dao.deleteById(id);
		inU = dao.selectById(id);
		if(inU != null)
		{
			fail("Failure to delete test record");
		}
	}
}

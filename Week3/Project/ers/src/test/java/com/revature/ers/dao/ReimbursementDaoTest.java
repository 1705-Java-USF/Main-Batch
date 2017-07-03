package com.revature.ers.dao;

import static org.junit.Assert.fail;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.ers.DataObjects.Reimbursement;
import com.revature.ers.DataObjects.User;
import com.revature.util.ColumnNameUtil;

public class ReimbursementDaoTest {
	private Logger logger = Logger.getLogger(ReimbursementDaoTest.class);
	ReimbursementDaoImpl rdi;
	Reimbursement r1;
	User u1;
	int uid1;
	double a1;
	String d1;
	String s1;
	String t1;
	
	Reimbursement r2;
	double a2;
	String d2;
	String s2;
	String t2;
	
	Reimbursement r3;
	double a3;
	String d3;
	String s3;
	String t3;
	
	Reimbursement r4;
	double a4;
	String d4;
	String s4;
	String t4;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		rdi = new ReimbursementDaoImpl();
		r1 = new Reimbursement();
		u1 = new User();
		uid1 = 3;
		u1.setUserId(uid1);
		a1 = 1337;
		d1 = "This is a testing description";
		s1 = "pending";
		t1 = "travel";
		r1.setAmount(a1);
		r1.setAuthor(u1);
		r1.setDescription(d1);
		r1.setReimbursementStatus(s1);
		r1.setReimbursementType(t1);
		r1.setSubmittedTime(LocalDateTime.now());
		
		
		r2 = new Reimbursement();
		a2 = 4562;
		d2 = "This is another testing description";
		s2 = "pending";
		t2 = "travel";
		r2.setAmount(a2);
		r2.setAuthor(u1);
		r2.setDescription(d2);
		r2.setReimbursementStatus(s2);
		r2.setReimbursementType(t2);
		r2.setSubmittedTime(LocalDateTime.now());
		
		r3 = new Reimbursement();
		a3 = 4562;
		d3 = "This is another testing description";
		s3 = "pending";
		t3 = "travel";
		r3.setAmount(a3);
		r3.setAuthor(u1);
		r3.setDescription(d3);
		r3.setReimbursementStatus(s3);
		r3.setReimbursementType(t3);
		r3.setSubmittedTime(LocalDateTime.now());
		
		r4 = new Reimbursement();
		a4 = 88788987.1;
		d4 = "Testing this description?";
		s4 = "pending";
		t4 = "travel";
		r4.setAmount(a4);
		r4.setAuthor(u1);
		r4.setDescription(d4);
		r4.setReimbursementStatus(s4);
		r4.setReimbursementType(t4);
		r4.setSubmittedTime(LocalDateTime.now());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createDeleteTest()
	{
		rdi.create(r1);
		List<Reimbursement> rs = rdi.selectAll();
		boolean found = false;
		for(Reimbursement r : rs)
		{
			if(r.getAmount() == a1 && r1.getDescription().equals(d1))
			{
				rdi.deleteById(r.getId());
				found = true;
			}
		}
		if(!found)
		{
			fail("Failure to create or find");
		}
		rs = rdi.selectAll();
		for(Reimbursement r : rs)
		{
			if(r.getAmount() == a1 && r1.getDescription().equals(d1))
			{
				fail("Failure to delete");
			}
		}
	}
	@Test
	public void selectByMap()
	{
		rdi.create(r2);
		Map<String, String> map = new HashMap<String, String>(0);
		
		String amountColumnName = ColumnNameUtil.AMOUNT;
		String descrColumnName = ColumnNameUtil.DESCRIPTION;
		map.put(amountColumnName, Double.toString(a2));
		map.put(descrColumnName, d2);
		List<Reimbursement> rs = rdi.selectBy(map);
		boolean found = false;
		for(Reimbursement r : rs)
		{
			if(r.getAmount() == a2 && r2.getDescription().equals(d2))
			{
				rdi.deleteById(r.getId());
				found = true;
			}
		}
		if(!found)
		{
			fail("Failure to find");
		}
		
		
	}
	@Test
	public void selectById()
	{
		rdi.create(r3);
		List<Reimbursement> rs = rdi.selectAll();
		for(Reimbursement r: rs)
		{
			if(r.getAmount() == a3 && r.getDescription().equals(d3))
			{
				Reimbursement s = rdi.selectById(r.getId());
				if(s.getAmount() != a3 || !s.getDescription().equals(d3)){
					fail("failure to find");
				}
			}
		}
	}
	@Test
	public void testUpdateBy()
	{
		rdi.create(r4);
		Map<String, String> conditions = new HashMap<String, String>();
		Map<String, String> nameValue = new HashMap<String, String>();
		String conName1 = ColumnNameUtil.AMOUNT;
		String conName2 = ColumnNameUtil.DESCRIPTION;
		String val1 = Double.toString(a4);
		String val2 = d4;
		conditions.put(conName1, val1);
		conditions.put(conName2, val2);
		
		String nVal1 = "88.88";
		String nVal2 = "I am the new fresh description";
		nameValue.put(conName1, nVal1);
		nameValue.put(conName2, nVal2);
		rdi.updateBy(nameValue, conditions);
		List<Reimbursement> rs = rdi.selectBy(nameValue);
		
		
		if(!(rs.size() >0 ) || (rs.get(0).getAmount() != Double.parseDouble(nVal1)) || !(rs.get(0).getDescription().equals( nVal2)))
		{
			logger.error(rs.size());
			if(rs.size() > 0)
			{
				logger.error(rs.get(0).getAmount());
				logger.error(Double.parseDouble(nVal1));
				logger.error(rs.get(0).getDescription());
				logger.error(nVal2);
			}
			fail("Failure to update");
		}
		int id = rs.get(0).getId();
		rdi.deleteById(id);
		if(rdi.selectById(id) != null)
		{
			fail("Failure to delete");
		}
		
		
	}

}

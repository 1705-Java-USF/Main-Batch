package com.revature.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.services.Action;

public class ActionTest {
	
	Action a;
	String url;
	String expected;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		a = new Action();
		url = "/test/crap/SeRvLeT.do";
		expected = "servlet";
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void actionTest() {
		String result = a.getAction(url);
		assertEquals(result, expected);
	}

}

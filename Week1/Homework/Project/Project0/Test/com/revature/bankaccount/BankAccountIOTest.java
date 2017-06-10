package com.revature.bankaccount;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class BankAccountIOTest {

	@Test
	public void fileTest() {
		File file = new File("CustomerInfo.txt");
		assertTrue(file.exists());
	}

}



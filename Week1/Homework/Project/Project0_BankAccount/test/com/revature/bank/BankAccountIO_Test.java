package com.revature.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class BankAccountIO_Test {
	
	// Test if the file that BankAccountIO is reading from exists in the directory.
	@Test
	public void doesFileExist() {
        File file = new File("accounts.txt");
        assertTrue(file.exists());
	}
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	@Test
	public void writeFile() throws IOException {
		File file = folder.newFile("accountsTest.txt");
		File file2 = new File("accounts.txt");
		BankAccountIO.writeFile(file.getAbsolutePath());
		BankAccountIO.writeFile(file2.getAbsolutePath());
		assertEquals(file.length(), file2.length());
	}
}

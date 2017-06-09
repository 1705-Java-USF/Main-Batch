package com.revature.bank;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class BankAccountIO_Test {
	/* Can't find a reasonable way to test reading a file without 
	 * 	placing the readFile (not test) method in a different class.
	 * But even then, I can't seem to figure out why or even the 
	 * 	proper way to do it given that (1) it has no need to return
	 * 	anything and (2) it seems I would need to pass in some object
	 * 	other than just the fileName so I could test it.
	@Rule
    public TemporaryFolder folder = new TemporaryFolder();
	
	
	@Test
	public void readFile() throws IOException {
		File file = folder.newFile("accountsTest.txt");
		file
	}
	*/
	
	/* Requires user input to test. Not a good test case.
	@Test
	public void askUserToReadOrWrite() {
		int userReadOrWrite = BankAccountIO.askUserToReadOrWrite();
		
		assertEquals(0 | 1, userReadOrWrite);
	}
	*/
	
	/*
	 * Similar to readFile(), writeFile() doesn't seem to be possible unless I can
	 * 	pass some kind of Writer object in.
	 */
}

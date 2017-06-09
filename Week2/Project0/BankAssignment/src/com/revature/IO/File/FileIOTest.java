package com.revature.IO.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FileIOTest {
	FileIO fio;
	String writeFileName;
	String readFileName;
	ArrayList<Object> testStrings;
	String test1;
	String test2;
	String test3;
	String readString1;
	String readString2;
	String readString3;
	String readString4;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		writeFileName = "FileWriteTest.txt";
		readFileName = "FileReadTest.txt";
		testStrings = new ArrayList<Object>();
		test1 = "This is the first test line";
		test2 = "";
		test3 = "This is the third test line.";
		
		testStrings.add(test1);
		testStrings.add(test2);
		testStrings.add(test3);
		readString1 = "This is the first line in the test file";
		readString2 = "";
		readString3 = "This is the third line in the test file";
		readString4 = "There isn't anything in the second line";
	}

	@After
	public void tearDown() throws Exception {
		writeFileName = null;
		readFileName = null;
		test1 = null;
		test2 = null;
		test3 = null;
		
	}

	@Test
	public void testWrite() {
		fio = new FileIO(writeFileName);
		ArrayList<String> test = new ArrayList<String>();
		test.add(test1);
		test.add(test2);
		test.add(test3);
		try {
			fio.write(testStrings);
			test = fio.read();
			assertEquals(test1, test.get(0).toString());
			assertEquals(test2, test.get(1).toString());
			assertEquals(test3, test.get(2).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void testRead() {
		fio = new FileIO(readFileName);
		ArrayList<String> readStrings;
		try{
			readStrings = fio.read();
			assertEquals(readString1, readStrings.get(0));
			assertEquals(readString2, readStrings.get(1));
			assertEquals(readString3, readStrings.get(2));
			assertEquals(readString4, readStrings.get(3));
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testGetFilename() {
		fio = new FileIO(readFileName);
		assertEquals(readFileName, fio.getFilename());
	}

	@Test
	public void testSetFileName() {
		fio = new FileIO(readFileName);
		fio.setFileName(writeFileName);
		assertEquals(writeFileName, fio.getFilename());
	}

}

/* Demetrus Atkinson */
package com.revature.project000;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/* class adds BankAccounts to a .txt file */
public class BankAccountID {

	public static void main(String[] args) throws Exception {
		// setUpBeforeClass starts off first
		BankTest.setUpBeforeClass();
		Logging lm = new Logging(); // logger to check for events
		lm.objectCreated(); // log for any new objects created
		BankTest bt = new BankTest(); // class for unit testing
		lm.objectCreated();
		BankAccountID bid = new BankAccountID();
		lm.objectCreated();

		// file to read and write (append) to
		String filePath = "C:\\Users\\DDA\\Documents\\workspace-sts-3.8.4.RELEASE\\project000\\src\\com\\revature\\project000\\AccountDetails.txt";

		try {
			bt.setUp(); // unit testing setup
			bid.readFile(filePath);
			bt.tearDown(); // tear down after finished

			bt.setUp();
			bid.writeFile(filePath);
			bt.tearDown();

		} catch (Exception e) {
			Logging.logException(); // log exception

		}
		BankTest.tearDownAfterClass(); // class/file is done processing
	}

	public void readFile(String filePath) throws IOException {
		Logging lrf = new Logging(); // log for read events
		lrf.objectCreated();

		// reader
		BufferedReader br = new BufferedReader(new FileReader(filePath));

		String s = "";
		// read file and log exceptions
		try {
			while ((s = br.readLine()) != null) {

			}

		} catch (FileNotFoundException e) {
			lrf.logFileNotFound();

		} catch (IOException e) {
			lrf.logIOException();
		} finally {
			br.close();
		}
	}

	public void writeFile(String filePath) throws IOException {
		Logging lwf = new Logging(); // log for write events

		// add accounts to file
		BankAccount freddie = new BankAccount(687651567, "Freddie", 257007.24);
		lwf.objectCreated();

		BankAccount sallie = new BankAccount(12488700, "Sallie", 8214785.35);
		lwf.objectCreated();

		BankAccount fannie = new BankAccount(453397800, "Fannie", 18.56);
		lwf.objectCreated();

		// printer for file
		PrintWriter pw = new PrintWriter(new FileWriter(filePath, true));
		lwf.objectCreated();

		ArrayList<BankAccount> accounts = new ArrayList<>();
		lwf.objectCreated();

		// add elements to ArrayList
		accounts.add(freddie);
		accounts.add(sallie);
		accounts.add(fannie);

		// log for when objects are now ready to print
		lwf.readyToPrint();

		// log for if nothing is written to the file
		if (accounts.size() == 0) {
			lwf.logInfo();
		}
		// print to file
		for (int i = 0; i < accounts.size(); i++) {
			pw.println(accounts.get(i));
		}

		// log for closing writer
		pw.flush();
		pw.close();
		lwf.logDebug();

	}
}
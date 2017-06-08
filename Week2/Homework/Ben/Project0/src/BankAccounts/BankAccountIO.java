package BankAccounts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

import org.apache.log4j.*;
import org.junit.*;

public class BankAccountIO
{
	static Logger logger = Logger.getLogger(BankAccountIO.class);
	
	public static void main(String[] args) throws IOException
	{
		logger.trace("Main method called. Calling I/O loop code....");
		iOLoop();
	}
	
	@BeforeClass
	public static void iOLoop() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		
		String filepath = ".super secure bank data.l33thax";
		
		logger.trace("Sending usage data to console...");
		
		ps.println("Type 1 to write to the file.");
		ps.println("Type 2 to read from the file.");
		ps.println("Type 3 to change the filepath. (Be careful or you might crash it.)");
		ps.println("Type 0 to quit.");
		int userInput = sc.nextInt();
		while(userInput!=0)
		{
			if(userInput==1)
				(new BankAccountIO()).writeMethod(filepath);
			else if(userInput==2)
				(new BankAccountIO()).readMethod(filepath);
			else if(userInput==3)
			{
				String temp = "";
				while(temp.equals(""))
					temp = sc.nextLine();
				
				logger.warn("Filepath changed from " + filepath + " to " + temp);
				filepath = temp;
			} else
			{
				logger.trace("User entered non-recognized information.");
			}
			
			logger.trace("Awaiting user input...");
				
			userInput = sc.nextInt();
		}
		logger.trace("User entered 0. Closing scanner and exiting program....");
		sc.close();
	}
	
	@Test
	public void writeMethodTester() throws IOException
	{
		writeMethod(".super secure bank data.l33thax");
	}
	
	@Test
	public void readMethodTester() throws IOException
	{
		readMethod(".super secure bank data.l33thax");
	}

	public void writeMethod(String filename) throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		
		logger.trace("BufferedWriter successfully created. Creating new bank accounts.");
		
		BankAccount a = new BankAccount(1, "John", 120.50);
		BankAccount b = new BankAccount(2, "Amy", 3000.0);
		BankAccount c = new BankAccount(3, "Austin", 460.70);
		
		logger.trace("Created bank accounts. Adding accounts to HashSet.");
		
		HashSet<BankAccount> hs = new HashSet<BankAccount>();
		
		hs.add(a);
		hs.add(b);
		hs.add(c);
		
		logger.trace("Accounts added to HashSet. Writing to file....");
		
		for(BankAccount ba : hs)
		{
			bw.write(ba.bankAccountNumber + ":" + ba.customerName + ":" + ba.balance + "\n");
			logger.trace(ba.bankAccountNumber + ":" + ba.customerName + ":" + ba.balance);
		}
		
		bw.close();
		
		logger.trace("Write function complete. Returning HashSet.");

		System.out.println(hs);
	}
	
	public void readMethod(String filename) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = br.readLine();

		logger.trace("BufferedReader successfully created. Reading in bank accounts.");
		
		HashSet<BankAccount> hs = new HashSet<BankAccount>();
		
		while(line != null)
		{
			String[] lines = line.split(":");	
			BankAccount ba = new BankAccount(Integer.parseInt(lines[0]), lines[1], Double.parseDouble(lines[2]));
			hs.add(ba);
			logger.trace("Successfully wrote bank account " + lines[0] + " belonging to " + lines[1] + " to HashSet.");
			line = br.readLine();
		}
		
		logger.trace("While loop escaped. Closing reader and returning HashSet.");
		
		br.close();

		System.out.println(hs);
	}
}
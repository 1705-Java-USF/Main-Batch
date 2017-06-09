import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class BankAccountIO 
{
	BufferedReader reader;
	BufferedWriter writer;
	static LinkedList<BankAccount> clientList = new LinkedList<>();
	final static Logger logger = Logger.getLogger(BankAccountIO.class);
	
	public static void main(String[] args) 
	{
		BankAccountIO bank = new BankAccountIO();
		String fileName = "bankInput.txt";
		
		try 
		{
			bank.readFile(fileName);
			System.out.println("Accounts Created: " + bank.numAccounts());
			bank.userInput();
			bank.writeFile(fileName);
		} 
		catch (IOException e) 
		{
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		finally
		{
			logger.info("Done.");
			System.out.println("Done.");
		}
	}
	
	public void readFile(String fileName) throws IOException
	{
		String buffer = "";
		String[] bufferArr;
		try 
		{
			reader = new BufferedReader(new FileReader(fileName));
			
			while((buffer = reader.readLine()) != null)
			{
				bufferArr = buffer.split(":");
				
				clientList.add(new BankAccount(Integer.parseInt(bufferArr[0]), bufferArr[1], Double.parseDouble(bufferArr[2])));
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			//e.printStackTrace();
			logger.error(e.getMessage());
		}
		finally
		{
			if(reader != null)
				reader.close();
		}
	}
	
	public void writeFile(String fileName) throws IOException
	{
		//Client List is already initialized in readFile()!!!!!
		
		writer = new BufferedWriter(new FileWriter(fileName));
		
		for(BankAccount acc : clientList)
		{
			//System.out.println(acc.toString());
			writer.write(acc.toString());
		}
	
		if(writer != null);
			writer.close();
		
	}
	
	public void userInput() throws IOException
	{
		Scanner scan = new Scanner(System.in);
		String buffer = "", name;
		Double money = new Double(0.0);
		Integer accNum = new Integer(clientList.size());
		accNum++;
		try
		{
			System.out.print("Enter Name:\t");
			name = scan.nextLine();
			System.out.print("Enter Account\nBalance:\t");
			buffer = scan.nextLine();
			money = Double.parseDouble(buffer);
			clientList.add(new BankAccount(accNum, name, money));
		}
		catch(InputMismatchException e)
		{
			//e.printStackTrace();
			logger.error(e.getMessage());
			logger.info("No account created");
		}
		catch(NumberFormatException e)
		{
			//e.printStackTrace();
			logger.error(e.getMessage());
			logger.info("No account created");
		}
		finally
		{
			scan.close();
		}
		
	}

	public int numAccounts()
	{
		return clientList.size();
	}
}

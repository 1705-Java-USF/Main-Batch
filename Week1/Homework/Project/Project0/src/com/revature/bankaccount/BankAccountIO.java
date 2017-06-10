package com.revature.bankaccount;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
//import org.apache.log4j.Logger;
//import java.util.Scanner;



public class BankAccountIO {
	
	//final static Logger logger = Logger.getLogger(BankAccountIO.class);

	public static void main(String[] args) throws IOException {
		 // The name of the file to open.
        String fileName = "CustomerInfo.txt";


        
        try {
/*        	String BANumber;
        	String CusName;
        	String Balance;
        	
        	Scanner input = new Scanner(System.in);
        	System.out.println("Add Bank Account Number");
        	BANumber = input.nextLine();
        	System.out.println("Add Customer Name");
        	CusName = input.nextLine();
        	System.out.println("Add Balance");
        	Balance = input.nextLine();*/
        	
        	List<CustomerInfo> bankAccounts = new ArrayList<>();
        	//Array list to add the 3 bank accounts
        	//They are pulled from my CustomerInfo class
        	bankAccounts.add(new CustomerInfo(1, "Mike", 100000.51));
        	bankAccounts.add(new CustomerInfo(2, "Jones", 26023423.44));
        	bankAccounts.add(new CustomerInfo(3, "Elmo", 5534344.56));
        	
        	
            FileWriter fileWriter = new FileWriter(fileName, true);
           
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

    		for(CustomerInfo ba : bankAccounts) {
    			bufferedWriter.write(String.valueOf(ba.getBankAccountNumber()) + ":");
    			bufferedWriter.write(ba.getName() + ":");
    			bufferedWriter.write(String.valueOf(ba.getBalance()) + "\n");
    		}
/*            bufferedWriter.write("\n");
            bufferedWriter.write(BANumber);
            bufferedWriter.write(":");
            bufferedWriter.write(CusName);
            bufferedWriter.write(":");
            bufferedWriter.write(Balance);*/
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
        }
//=======================================================================================================       
		String line = null;
		try
		{
			FileInputStream fstream = new FileInputStream("CustomerInfo.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while((line=br.readLine())!=null) //repeat until end of file
			{
				String[] words = line.split(":"); //split line to words
				//System.out.println("\n");
				System.out.println("ID:      "+words[0]); //printing ID
				System.out.println("Name:    "+words[1]); //printing Name
				System.out.println("Ammount: "+words[2]);//printing Amount
					
			}
			br.close(); //finally close the buffer
		}
		catch(IOException ie)
		{System.out.println(ie);}
	}

}



package project0;

import java.io.*;
import java.util.*;
import org.apache.log4j.*;;

public class BankAccountIO {

	static BufferedReader br;
	final static Logger logger = Logger.getLogger(BankAccountIO.class);

	public static void main(String[] args) throws IOException {

		BasicConfigurator.configure();
		String FilePath = "src/myfile.txt";

		writeFile(FilePath);
		readFile(FilePath);

	}

	static void writeFile(String FilePath) throws IOException {

		ArrayList<AccountInfo> bankAccount = new ArrayList<AccountInfo>();
		
		BufferedWriter bw = null;
		File file = new File("src/myfile.txt");
		FileWriter fw = new FileWriter(file);

		for (int i = 0; i < 3; i++) {
			
			AccountInfo account = new AccountInfo();

			//logger.info("--- Retrieving information ---");
			logger.info("--- Retrieving information ---");
			account.setBankAccountNumber(i);
			account.setCustomerName("");
			account.setBalance(i);
			logger.info("\n");

			bankAccount.add(account);
		}
		
		logger.info(bankAccount);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}

			bw = new BufferedWriter(fw);
			
			for (AccountInfo i : bankAccount)
			{
				bw.write(i.toString());
			}
			
			logger.info("File written Successfully");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				logger.info("Error in closing the BufferedWriter" + ex);
			}
		}

	}

	static void readFile(String FilePath) throws IOException {

		String thisLine = null;
		String[] accountValues = null;

		try {

			br = new BufferedReader(new FileReader(FilePath));

			while ((thisLine = br.readLine()) != null) {
				accountValues = thisLine.split(":");
				logger.info("\nReading from file:");
				logger.info(Arrays.toString(accountValues));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close();
			}
		}

	}
}

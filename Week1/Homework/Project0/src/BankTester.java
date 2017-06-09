import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BankTester 
{

	static BankAccountIO bank;
	static BankAccount account;
	static BankAccount account2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		//
		bank = new BankAccountIO();
		account = new BankAccount();
		account2 = new BankAccount(1, "John", 1000.0);
	}
	
	//Test that bank accounts start at 0, before input file is read
		@Test
		public void bankTest() 
		{
			assertEquals(0, bank.numAccounts());
		}
	
	//Test Default constructor 
	@Test
	public void accountExists1() 
	{
		assertEquals(new Integer(-1), account.getBankAccountNumber());
	}
	//Test Default constructor 
	@Test
	public void balanceExisits1() 
	{
		assertEquals(new Double(0.0), account.getBalance());
	}
	
	//Test Default constructor 
	@Test
	public void nameExisits1() 
	{
		assertNotNull(account.getBankAccountNumber());
	}
	
	//Test constructor with parameters
	@Test
	public void accountExists2() 
	{
		assertEquals(new Integer(1), account2.getBankAccountNumber());
	}
	//Test constructor with parameters
	@Test
	public void balanceExisits2() 
	{
		assertEquals(new Double(1000.0), account2.getBalance());
	}
	
	//Test constructor with parameters
	@Test
	public void nameExisits2() 
	{
		assertNotNull(account2.getBankAccountNumber());
	}

}

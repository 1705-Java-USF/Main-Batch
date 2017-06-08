package BankAccounts;

public final class BankAccount implements Comparable<BankAccount>
{
	long bankAccountNumber;
	String customerName;
	double balance;
	
	BankAccount(long bca, String cusName, double blnc)
	{
		bankAccountNumber = bca;
		customerName = cusName;
		balance = blnc;
	}
	
	@Override
	public String toString()
	{
		return bankAccountNumber+":"+customerName+":"+balance;
	}

	@Override
	public int compareTo(BankAccount o)
	{
		return (int) (bankAccountNumber - o.bankAccountNumber);
	}
}

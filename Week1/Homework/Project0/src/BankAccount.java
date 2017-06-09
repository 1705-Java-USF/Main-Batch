
public class BankAccount 
{
	private Integer bankAccountNumber;
	private String customerName;
	private Double balance;
	
	public BankAccount()
	{
		this.bankAccountNumber = -1;
		this.customerName = "Default";
		this.balance = 0.0;
	}
	
	public BankAccount(Integer bankAccountNumber, String customerName, Double balance) 
	{
		this.bankAccountNumber = bankAccountNumber;
		this.customerName = customerName;
		this.balance = balance;
	}

	public Integer getBankAccountNumber() 
	{
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Integer bankAccountNumber) 
	{
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}

	public Double getBalance() 
	{
		return balance;
	}

	public void setBalance(Double balance) 
	{
		this.balance = balance;
	}

	@Override
	public String toString() 
	{
	//return "Account Number= " + bankAccountNumber + ", Customer Name= " + customerName + ", Balance= " + balance + "\n";
		
		return(bankAccountNumber + ":" + customerName + ":" + balance + "\n");
	}

	
}

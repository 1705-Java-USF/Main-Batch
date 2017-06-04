package CoreJavaHomework.src.q4;

public class Q4
{
	//This program is meant to calculate N factorial.
	public static void main(String[] args)
	{
		//No N is given, so I make one up.
		final double N = 42;
		
		System.out.println(factorial(N));	//Print the factorial of N.
	}
	
	private static double factorial(double n)
	{
		if(n==0) return 1;	//This is part of the definition of factorial.
		return n*factorial(n-1);	//This is the rest of the definition.
	}
}

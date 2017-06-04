package CoreJavaHomework.src.q2;

public class Q2
{
	public static void main(String[] args)
	{
		//We use 25 because that's what the documentation calls for.
		final int MAX_FIB = 25;
		
		//I set nMinus2 to -1 for pedantic accuracy reasons. In actuality, this value is never read.
		int nMinus2 = -1;
		//I set nMinus1 to 1 so that I get 1 when I add the values currently in nMinus1 and n.
		int nMinus1 = 1;
		//We set n to zero because the documentation calls for outputting 0.
		int n = 0;
		
		for(int i=0; i<MAX_FIB; i++)
		{
			System.out.println(n);
			
			//Here I move every number back a step and generate the next number.
			nMinus2 = nMinus1;
			nMinus1 = n;
			//The next number is given by the sum of the two before it.
			//This is the definition of the Fibonacci sequence.
			n = nMinus1 + nMinus2;
		}
	}
}

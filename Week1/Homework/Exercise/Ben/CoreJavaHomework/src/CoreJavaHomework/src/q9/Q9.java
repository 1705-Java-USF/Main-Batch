package CoreJavaHomework.src.q9;

import java.util.ArrayList;

public class Q9
{
	//"Create an ArrayList which stores numbers from 1 to 100
	// and prints out all the prime numbers to the console."
	public static void main(String[] args)
	{
		//This merely constructs the original arraylist.
		ArrayList<Integer> numbers = new ArrayList<Integer>(100);
		for(int i=0; i<100; i++)
		{
			numbers.add(i+1);	//the for loop has 0-based indexing, while the array has 1-based.
		}
		
		//For every number in "numbers,"
		for(int curr : numbers)
		{
			//(A prime number is only divisible by itself and 1.
			// 1 is only divisible by itself and 1.
			// Thus, 1 is a prime number.)
			boolean isPrime = true;
			for(int i=2; i<=Math.sqrt(curr); i++) //(All factors come in pairs, one member of each must be the square root or less)
			{
				if(curr % i == 0)	//If it has a factor less than or equal to its square root
				{
					isPrime = false; //It's not prime
					break;			//And requires no further calculations.
				}
			}
			
			//If it's prime,
			if(isPrime)
			{
				//print it.
				System.out.println(curr);
			}
		}
	}
}

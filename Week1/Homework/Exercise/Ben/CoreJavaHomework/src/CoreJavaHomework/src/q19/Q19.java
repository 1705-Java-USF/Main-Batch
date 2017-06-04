package CoreJavaHomework.src.q19;

import java.util.ArrayList;
import java.util.Arrays;

public class Q19 {
	/*Create an ArrayList and insert integers 1 through 10.
	 * Display the ArrayList.
	 * Add all the even numbers up and display the result.
	 * Add all the odd numbers up and display the result.
	 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	 */
	public static void main(String[] args)
	{
		//Again, 1 is evenly divisible only by itself and 1. Thus, 1 is prime.
		//Note that this only includes primes less than 53,
		// so the intial ArrayList cannot be 53 or larger.
		final Integer[] primes = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
				
		//Create an ArrayList and insert integers 1 through 10.
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0; i<10; i++)	al.add(i+1);
		
		//Display the ArrayList
		System.out.println(al);
		
		//Add all the even numbers up and display the result.
		int total = 0;
		for(int i : al)	if(i%2==0) total+=i; //For every int in al, if it's even, add it to the total.
		System.out.println(total);
		
		//Add all the odd numbers up and display the result.
		total = 0;
		for(int i : al)	if(i%2!=0) total+=i; //For every int in al, if it's odd, add it to the total.
		System.out.println(total);
		
		//I know that it's always 10
		//But there's nothing wrong with writing an algorithm for the general case.
		int length = al.size();
		//Remove all the prime numbers from the ArrayList and print out the remaining ArrayList.
		for(int i=2; i<=length; i++)
		{
			al.removeAll(Arrays.asList(primes));
		}
		System.out.println(al);
	}
}
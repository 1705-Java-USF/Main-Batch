package CoreJavaHomework.src.q17;

import java.io.PrintStream;
import java.util.Scanner;

public class Q17 {
	/*Write a program that calculates the simple interest on the principal,
	 * rate of interest, and number of years provided by the user.
	 * Enter principal, rate and time through the console using the Scanner class.
Interest = Principal* Rate* Time*/
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		//While not technically necessary, I give the user basic instructions here.
		PrintStream ps = new PrintStream(System.out);
		ps.println("Please input Principal, Rate of Interest, and Number of Years.");
		ps.println("Please input only numbers, with Rate of Interest as a decimal.");
		
		//Here I read in the numbers. I use long and double because integers will be cast automatically.
		long principal = sc.nextLong();
		double rate = sc.nextDouble();
		int years = sc.nextInt();
		
		//Here I calculate interest.
		double interest = principal*rate*years;
		
		ps.println("Your simple interest is $" + interest);

		sc.close();
	}

}

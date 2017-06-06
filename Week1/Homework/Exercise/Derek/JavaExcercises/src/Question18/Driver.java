package Question18;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		//Subclass obj and scanner
		Subclass s = new Subclass();
		Scanner sc=new Scanner(System.in);
		
		//Asks for a string input and prints to console,
		//and returns true or false after uppercase check.
		System.out.println("Str: ");
		String inputString = sc.nextLine();
		System.out.println(s.methodB(inputString));
		
		//Asks for a string input and prints to console
		//the converted all uppercase version of the input.
		System.out.println("Str: ");
		String inputString2 = sc.nextLine();
		System.out.println(s.methodS(inputString2));
		
		//Asks for a string input and prints to console
		//the converted int with 10 added to it.
		System.out.println("Str: ");
		String inputString3 = sc.nextLine();
		System.out.println(s.methodI(inputString3));		
		sc.close();
	}

}

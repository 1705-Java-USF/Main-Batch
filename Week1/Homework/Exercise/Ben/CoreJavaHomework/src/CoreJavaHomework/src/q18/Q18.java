package CoreJavaHomework.src.q18;

import java.io.PrintStream;
import java.util.Scanner;

public class Q18 extends Q18AbstractClass
{
	/*Provide the following three implementations in the subclass corresponding to the abstract methods
	 * in the superclass: 
1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
2. Convert all of the lower case characters to uppercase in the input string, and return the result. 
3. Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.
*/
	public static void main(String[] args)
	{
		//This simplifies input/output, but isn't necessary to do anything.
		// Effectively, every instance of "sc" could instead be "System.in"
		// and every instance of "ps" could instead be "System.out"
		// sc and ps are just faster to type.
		Scanner sc = new Scanner(System.in);
		PrintStream ps = new PrintStream(System.out);
		
		//I have to create an instance of this class to access the non-static methods within.
		Q18 q18 = new Q18();
		
		ps.println("Give me a string and I'll tell you if there are uppercases!");
		ps.println(q18.checkForUppercase(sc.nextLine()));

		ps.println("GIVE ME A STRING AND I'LL SHOUT IT BACK!");
		ps.println(q18.toUpper(sc.nextLine()));

		ps.println("Give me a number and I'll add ten!");
		ps.println(q18.parseIntAndAddTen(sc.nextLine()));
		
		sc.close();
	}

	@Override
	boolean checkForUppercase(String in)
	{
		//If the string is equivalent to the version where all capitals are lowercase,
		//Then the string doesn't contain uppercase characters.
		return in.compareTo(in.toLowerCase())!=0;
	}

	@Override
	String toUpper(String in)
	{
		return in.toUpperCase();
	}

	@Override
	int parseIntAndAddTen(String in) {
		int value = Integer.parseInt(in);
		return value+10;
	}

}

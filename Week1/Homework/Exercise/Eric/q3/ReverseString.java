package q3;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		// scanner object to retrieve input
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a string to reverse: ");
		// Get string to reverse
		String rev = sc.next();
		if (sc != null) // close scanner
			sc.close();
		ReverseString rs = new ReverseString();
		System.out.println(rs.stringReverse(rev));
	}
	
	// stringReverse method - returns the reverse of string s using recursion
	public String stringReverse(String s){
		// if 1 character or less, you can't really reverse it
		if (s.length() < 2)
			return s;
		// build a string with the first character then the reverse of the rest of the string
		else
			return s.substring(s.length() - 1, s.length()) + stringReverse(s.substring(0, s.length() - 1));
	}

}
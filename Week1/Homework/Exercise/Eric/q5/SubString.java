package q5;

import java.util.Scanner;

public class SubString {

	public static void main(String[] args) {
		// get input string and index using a scanner object
		SubString ss = new SubString();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a string: ");
		String test = sc.next(); 
		System.out.print("Please enter length of new substring (starting from 0): ");
		int i = sc.nextInt();
		if (sc != null) // close scanner
			sc.close();
		
		//generate the substring
		System.out.println(ss.subString(test, i));
	}
	
	public String subString(String str, int idx){
		// idx == 0 -> empty string
		if (idx == 0){
			return "";
		}
		// idx == 1 -> first character
		else if (idx == 1){
			return "" + str.charAt(0);
		}
		// Otherwise, recurse and and concatenate with the last character
		else {
			return subString(str, idx - 1) + str.charAt(idx -1);
		}
	}

}

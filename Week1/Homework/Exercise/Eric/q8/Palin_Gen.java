package q8;

import java.util.ArrayList;
import java.util.Arrays;

public class Palin_Gen {

	public static void main(String[] args) {
		Palin_Gen pg = new Palin_Gen();
		// ArrayList of strings to check for palindromes
		ArrayList<String> sl = new ArrayList<>(Arrays.asList("karan",
				"madam", "tom", "civic", "radar", "sexes", "jimmy", "refer",
				"billy", "did"));
		// ArrayList of the palindromes from the first list
		ArrayList<String> pal_sl = new ArrayList<>();
		
		// iterate through string list and store palindromes in a new list
		for (String str : sl){
			if (pg.isPalindrome(str)){
				// use stringbuilder to reverse the string
				StringBuilder sb = new StringBuilder(str);
				pal_sl.add(sb.reverse().toString());
			}
		}
		
		System.out.println("List:\n" + sl + "\nHas palindromes: ");
		
		System.out.println(pal_sl);
		
	}
	
	// isPalindrome - return true if str is a palindrome
	public boolean isPalindrome(String str){
		
		// use StringBuilder methods to compare string to it's reverse
		// if it matches it's reverse, it must be a palindrome
		StringBuilder sb = new StringBuilder(str);
		// compareTo returns 0 if str and it's reverse are the same string
		if (sb.toString().compareTo(sb.reverse().toString()) == 0)
			return true;
		else
			return false;
	}

}

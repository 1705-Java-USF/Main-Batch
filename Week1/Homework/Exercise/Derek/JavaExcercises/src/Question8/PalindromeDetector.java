package Question8;

import java.util.ArrayList;

import Question3.StringReversed;

public class PalindromeDetector {
	
	//Bunch of constant names in a string array.
	static final String[] STRS = {
			"karan", 
			"madam", 
			"tom",
			"civic", 
			"radar", 
			"sexes", 
			"jimmy",
			"kayak", 
			"john",  
			"refer", 
			"billy",
			"did"
		};
	
	public static void main(String[] args) {
		
		//Makes an ArrayList strsAL and uses a loop to add all strings
		//in STRS to strsAL so they are all in the ArrayList.
		ArrayList<String> strsAL = new ArrayList<>();
		for (String str : STRS) {
			strsAL.add(str);
		}
		
		//Prints the string ArrayList of palindromes to the console.
		ArrayList<String> palindromes = findPalindromes(strsAL);
		System.out.println(palindromes);
	}
	
	/*
	 * Method to take in an ArrayList of strings and loops through each
	 * string of the list, checking for if the string equals the reverse
	 * of itself (using StringReversed function from before).
	 * If it finds one that does it will add it to the
	 * foundPalindromes ArrayList and then return the list of palindromes.
	 */
	public static ArrayList<String> findPalindromes(ArrayList<String> list) {
		
		ArrayList<String> foundPalindromes = new ArrayList<>();
		
		for (String str :  list) {
			if (str.equals(StringReversed.reverse(str))) {
				foundPalindromes.add(str);
			}
		}
		
		return foundPalindromes;
	}
}

package CoreJavaHomework.src.q8;

import java.util.ArrayList;

public class Q8 {
	//Here, I need to make an array list to hold several strings, and scan it for palindromes.
	//Then, place the palindromes into a new ArrayList.
	public static void main(String[] args) {
		final String[] INPUTS = {"karan", "madam", "tom", "civic", "radar", "sexes", "jimmy", "kayak", "john",  "refer", "billy", "did"};
		
		//Define the array lists
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		//And set up the first to have the strings it should.
		for(String in : INPUTS)
		{
			strings.add(in);
		}
		
		//For every string in the arraylist "strings,"
		for(String in : strings)
		{
			//If it's a palindrome,
			if(in.compareTo(reverse(in))==0)
			{
				//Add it to the arraylist "palindromes"
				palindromes.add(in);
			}
		}
		
		//Output the results in "palindromes"
		for(String out : palindromes)
		{
			System.out.println(out);
		}
	}

	//This function uses recursion to reverse a string.
	private static String reverse(String in)
	{
		//First, if it can't be split into two smaller strings, it's short enough to return the string itself.
		int size = in.length();
		if(size<2)
		{
			return in;
		}
		//Otherwise, split it in half and return the two halves in opposite order.
		String a = in.substring(0, size/2);
		String b = in.substring(size/2);
		return reverse(b)+reverse(a);
	}
}

package CoreJavaHomework.src.q16;

public class Q16 {
	/*Q16. Write a program to display the number of characters for a string input.
	 * The string should be entered as a command line argument using (String [ ] args).*/
	public static void main(String[] args)
	{
		//I decide to process all the strings passed in, just to be safe.
		for(int i=0; i<args.length; i++)
		{
			//I print out the string number (with zero-based indexing) and the string length.
			System.out.println("String " + i + ": " + args[i].length());
		}
	}

}

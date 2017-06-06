package Question16;

public class CharsInString {
	
	public static void main(String[] args) {
		
		//Amount to represent total characters in string argument user provides.
		int amount = 0;
		
		//Makes sure it is only the first argument (singular).
		//Any further arguments are ignored as we only want one argument
		//(judging by directions).
		//Goes through each char in string and prints them out,
		//Then displays the total amount of characters in string input argument.
		for(int i = 0; i < args[0].length(); i++) {
			String s = args[0];
			char chars = s.charAt(i);
			System.out.print(chars + " ");
			amount++;			
		}
		
		//Print to console the total number of chars.
		System.out.println("\nThe number of characters is " + amount);
	}
}

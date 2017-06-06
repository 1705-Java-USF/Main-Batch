package Question3;

public class StringReversed {
	
	//Declaring the string with final to be a non-temporary var.
	static final String str = "I'm awesome!";
	
	public static void main(String[] args) {
		
		//Taking a String Reversed object and calling the reverse function
		//on the str string, then printing to the console the reversed version.
		System.out.println(StringReversed.reverse(str));
	}
	
	//Reverse string function
	public static String reverse(String str) {
		
		//Exception for a one letter string
		if (str.length() <= 1) {
		    return str;
		}
		
		//Otherwise, take the substring from 0 to one less than the length, and reverse it so that
		//it is added on to the last char from the string (the '!' in this case being the last one).
		return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
	}
}

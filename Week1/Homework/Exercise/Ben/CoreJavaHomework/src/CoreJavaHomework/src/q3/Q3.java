package CoreJavaHomework.src.q3;

public class Q3
{
	//In this class, I am to create reverse a string without using a temporary variable.
	public static void main(String[] args)
	{
		//Since no other string is given, I make up my own string.
		String input = "gnirtS raboof pu-edaM";
		
		//My approach is that I "pop" characters off of the string and print them to the console. 
		while(input.length()!=0) //Here, I check to ensure the string isn't empty. If it is, I'm done.
		{
			//Here, I print the last character in the string.
			System.out.print(input.charAt(input.length()-1));
			//Here, I remove the last character from the string.
			input = input.substring(0, input.length()-1);
		}
	}
}

package q16;

public class CharCount {
	
	public static void main(String[] args){
		// Check for arguments
		if (args.length  == 0)
			System.out.println("Please include arguments and run again (any arguments will do)");
		else{
			// uses string builder to combine all arguments into a single string
			StringBuilder sb = new StringBuilder();
			// appends each string to the StringBuilder
			for (int i = 0; i < args.length; i++){
				if (i == 0)
					sb.append(args[i]);
				else // add a space after the first argument
					sb.append(" " + args[i]);
			}
			// simply return length of the concatenated string
			System.out.println("Contains " + sb.length() + " characters (including whitespace)");
		}
	}
	
}

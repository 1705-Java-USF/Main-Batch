package q18;

// sub class implementing the abstract methods
public class SubClass extends SuperClass {

	@Override
	// test for a string to see if it contains any upper case letters
	public boolean hasUpper(String str) {
		// go character by character to check for any upper case letters
		for (int i = 0; i < str.length(); i++){
			// convert string to a character array and use isUpperCase to check
			if (Character.isUpperCase(str.toCharArray()[i])){
				return true;
			}
		}
		// return false if none found
		return false;
	}

	@Override
	// converts any lowercase characters to upper case
	public String makeUpper(String str) {
		// uses stringbuilder in case the string is quite long
		StringBuilder res = new StringBuilder();
		// append res with the uppercase conversion
		// toUpperCase won't change anything that's not a lowercase character
		for (int i = 0; i < str.length(); i++){
			res.append(Character.toUpperCase(str.toCharArray()[i]));
		}
		// converts back to a string
		return  res.toString();
	}

	@Override
	// converts a string to an integer, adds 10, and prints
	public void printInt(String str) {
		int n;
		// use a try catch block in case the str can't
		// be converted to an integer
		try {
			// parseInt will throw an exception if str isn't
			// in numeric characters
			n = Integer.parseInt(str);	
			n += 10; // add 10
			// print result
			System.out.println("Integer of " + n + " + 10: " + n);
		} catch (NumberFormatException e){
			// custom error result
			System.out.println("String wasn't able to converted to an int");
			e.printStackTrace();
		}
	}
}

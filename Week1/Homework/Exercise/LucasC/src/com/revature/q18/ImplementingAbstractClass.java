package com.revature.q18;

public class ImplementingAbstractClass extends AbstractClass {

	@Override
	public void upperCaseChecker(String str) {
		
		boolean upperCase = false;
		int count = 0;
		
		for (int i = 0; i < str.length(); i++)
		{
			if (Character.isUpperCase(str.charAt(i)))
			{
				upperCase = true;
				count++;
			} 
		}
		System.out.println("\nFirst method: checking for upper case chars");
		if (upperCase == true)
		{
			System.out.println(count + " upper case characters were found");
		}
		else
		{
			System.out.println("No upper case chars were found");
		}
		
	}

	@Override
	public void lowerCaseConverter(String str) {

		for (int i = 0; i < str.length(); i++)
		{
			str = str.toUpperCase();
		
		}
		System.out.println("\nSecond method: converting lower case to upper case chars.");
		System.out.println(str);

	}

	@Override
	public void stringConverter(String str) {
		
		int count = 0;

		for (int i = 0; i < str.length(); i++) {

			//count += Integer.parseInt(str);
			count += Character.getNumericValue(str.charAt(i));
		}
		
		System.out.println("\nThird method: converting string to int, and adding 10 to it");
		System.out.println("String converted to int. Value becomes: " + count);
		System.out.println("String value + 10: " + (count + 10));

	}

}

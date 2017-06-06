package com.assignment.q18;

public class SubClass extends Super
{

	@Override
	public boolean upperCheck(String str) 
	{
		//Iterate though passed in string
		for(int i = 0;  i < str.length(); i++)
		{
			//Check for upper case and return true
			if(Character.isUpperCase(str.charAt(i)))
				return true;
		}
		return false;
	}

	@Override
	public String toUpperCase(String str) 
	{
		//This problem could easily be solved with this one liner: return str.toUpperCase();
	
		//Create new empty string
		String newStr = "";
		
		//Iterate though passed in string
		for(int i = 0;  i < str.length(); i++)
		{
			//If character is not upper case use Character wrapper class to change it to upper
			//then cast it back to char and append to new string
			if(!Character.isUpperCase(str.charAt(i)))
			{
				Character temp = new Character(' ');
				temp = Character.toUpperCase(str.charAt(i));
				newStr += (char) temp;			
			}
			//Else character is already in upper case, therefore append as is
			else
			{
				newStr += str.charAt(i);
			}
		}
		//Return new string
		return newStr;
	}

	@Override
	public int strToInt(String str) 
	{
		//Start counter at 0
		int count = 0;
		
		//Iterate though string
		for(int i = 0;  i < str.length(); i++)
		{
			//Convert character value to integer and add to count
			count += (int)str.charAt(i);
		}
		
		//Retur count plus 10
		return (count + 10);
	}

}

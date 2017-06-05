package com.revature.question5;

public class SubStringer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "This is a string, it will be cut off";
		System.out.println((substring(s,31)));
	}
	
	//substring from 0 to i (exclusive)
	public static String substring(String in, int i) 
	{
		if(i > in.length()){
			return in; //avoids out of bounds error
		}
		char[] charOut = new char[i];
		for(int a = 0; a < i; a++) // loops through filling the character array until it reaches the index
		{
			charOut[a] = in.toCharArray()[a];
		}
		return new String(charOut);
	}
}

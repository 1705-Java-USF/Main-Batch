package com.revature.q5;

public class Main {
	public static void main(String args[]){
		String s = "Hello, World";
		System.out.println(substr(s, 4));
	}
	public static String substr(String s, int idx)
	{
		//empty string containing sub string
		String str = "";
		for(int i = 0;  i < idx; i++){
			//append chars up to specified index
			str += s.charAt(i);
		}
		return str;
	}
}

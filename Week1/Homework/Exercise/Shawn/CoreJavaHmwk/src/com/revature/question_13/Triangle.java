package com.revature.question_13;

/*
 * If start and end of string (str) are the same, add the opposite character as the first character.
 * If start and end of string (str) are different, add first character value to the end of the string. 
 */

public class Triangle {
	public static void main(String[] args) {
		String str = "0";
		
		while(!str.equals("0 1 0 1 0")) {
			System.out.println(str);
			
			if(compareStartTo0(str)) {
				if(compareEndTo0(str))
					str = "1 " + str;
				if(compareEndTo1(str))
					str += " 0";
			} else if(compareStartTo1(str)) {
				if(compareEndTo1(str))
					str = "0 " + str;
				if(compareEndTo0(str))
					str += " 1";
			}
		}
	}
	
	private static boolean compareStartTo0(String str) {
		return str.substring(0, 1).equals("0");
	}
	private static boolean compareEndTo0(String str) {
		return str.substring(str.length() - 1, str.length()).equals("0");
	}
	private static boolean compareStartTo1(String str) {
		return str.substring(0, 1).equals("1");
	}
	private static boolean compareEndTo1(String str) {
		return str.substring(str.length() - 1, str.length()).equals("1");
	}
}

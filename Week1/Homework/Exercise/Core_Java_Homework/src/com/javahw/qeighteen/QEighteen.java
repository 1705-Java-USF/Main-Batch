package com.javahw.qeighteen;

public class QEighteen {

	public static void main(String[] args) {
		SubClass sc = new SubClass();
		
		String[] testStrs = {"lowercased","UPPER","12345"};
	
		for(int i = 0; i < testStrs.length - 1; i++){
			System.out.println(sc.isAnyCharUpperCase(testStrs[i]));
			System.out.println(sc.lowerToUpper(testStrs[i]));
			System.out.println("====");
		}
		
		System.out.println(sc.stringToIntegerPlusTen(testStrs[2]));
		
	}

}

package com.revature.day2;

public class StringBuilderAndBuffer {

	public static void main(String[] args) {
		
		String s1 = "dogs";
		String s2 = "dogs";
		String s3 = new String("dogs");
		
		
		
		System.out.println("s1 == s2: " + (s1 == s2));			//T
		System.out.println("s1 == s3: " + (s1 == s3));			//F
		System.out.println("s1.equals(s2): " + s1.equals(s2));	//T
		System.out.println("s1.equals(s3): " + s1.equals(s3));	//T
		
		System.out.println(s3.substring(1,2)); //START with left index, end BEFORE 2nd index
		System.out.println(s3);
		
		String s4 = s3.substring(2,3);
		System.out.println(s4);
		
		System.out.println("===============");
		int size = 100000000;
		System.out.println("Looping " + size + " times!");
		String str = "";
		StringBuilder sbui = new StringBuilder("");
		StringBuffer sbuf = new StringBuffer("");

		long curtime;
		
		/*
		curtime = System.currentTimeMillis();
		for(int i = 0; i < size; i++){
			str = str + "a";
		}
		System.out.println("String: " + (System.currentTimeMillis() - curtime));
		*/
		curtime = System.currentTimeMillis();
		for(int i = 0; i < size; i++){
			sbui.append("a");
		}
		System.out.println("StringBuilder: " + (System.currentTimeMillis() - curtime));
		
		curtime = System.currentTimeMillis();
		for(int i = 0; i < size; i++){
			sbuf.append("a");
		}
		System.out.println("StringBuffer: " + (System.currentTimeMillis() - curtime));
		
		
		
		/*
		System.out.println("======Fun With Strings=======");
		System.out.println(1 + 2 + 3);
		System.out.println("1" + "2" + "3");
		System.out.println(1 + 2 + 3 + "s");
		System.out.println('c' + 1 + 2 + "s" + (3 + 4));
		System.out.println("s" + s2 + 2 + 3);
		*/
		
	}

}

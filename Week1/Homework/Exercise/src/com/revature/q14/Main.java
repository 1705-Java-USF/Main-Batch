package com.revature.q14;

import java.util.Calendar;
import java.util.Date;

public class Main {
	public static void main(String[] args){
		int N = 3;
		switch(N){
		case 1:
			//Uses Math.sqrt
			System.out.println("Square root of 49 is: " + Math.sqrt(49));
			break;
		case 2:
			//Uses Date
			Date today = Calendar.getInstance().getTime();
			System.out.println(today);
			break;
		case 3:
			//Uses split
			String s = "I am learning Core Java";
			String vals[] = s.split(" ");
			for(String v : vals)
				System.out.println(v);
			break;
		}
	}
}

package com.revature.question14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String input;
		System.out.println("type a number from 1 to 3");
		int choice = Integer.parseInt(in.nextLine());
		String[] sarr;
		switch(choice)
		{
		case 1:
			System.out.println(Math.sqrt(25));
			break;
		case 2:
			Calendar c = new GregorianCalendar();
			//c.getTime();
			DateFormat df = new SimpleDateFormat();
			System.out.println(df.format(c.getTime()));
			break;
		case 3:
			String s = "I am learning Core Java";
			sarr = s.split(" ");
			for(String a : sarr)
			{
				System.out.println(a);
			}
			break;
		default:
			System.out.println("Not a valid choice");
			break;
		}
	}

}

package com.javahw.qfourteen;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QFourteen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try{
			System.out.println("Input a number between 1-3");
			int a = scan.nextInt();
			
			System.out.println("Input a string");
			scan.nextLine();
			String str = scan.nextLine();
			
			scan.close();
			
			String[] strArr;
			
			
			switch(a){
			case 1:
				//Find square root of a number
				System.out.println(Math.sqrt(25));
				break;
			case 2:
				//Display todays date
				System.out.println(LocalDate.now());
				break;
			case 3:
				//Split the string and store into string array
				strArr = str.split(" ");
				for(String s : strArr){
					System.out.println(s);
				}
				break;
			}
		}catch(InputMismatchException e){
			System.out.println("Invalid Input");
		}
	}

}

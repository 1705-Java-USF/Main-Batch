package com.revature.question12;

import java.util.ArrayList;


public class QuestionTwelve {

	public static void main(String[] args) {
		
		//Creating an array list to hold integers
		ArrayList<Integer> array = new ArrayList<Integer>(100);

		
		//a for loop to add integers from 1-100
		for (int i = 1; i <= 100; i++)
		{
		   array.add(i);
		}
		
		
		//enhanced for loop to check if number is even then prints it
		for (int i : array){
			if(i % 2 == 0){
				System.out.print(i + ", ");
			}
		}
	}
}


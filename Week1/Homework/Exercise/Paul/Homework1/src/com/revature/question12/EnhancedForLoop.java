package com.revature.question12;

import java.util.ArrayList;

public class EnhancedForLoop {

	public static void main(String[] args) {
		//Array List to store numbers from 1 - 100
		//utilized a for loop to get numbers from 1 - 100
				
		ArrayList<Integer> list = new ArrayList<>();
				
		//adds numbers 1 - 100 (1 is odd) to array list 
			for(int i = 2; i <= 100; i++){
				list.add(i);
			}
			
			//for loop to go through numbers and 
			//remove the numbers that are not even from
			//the array list
			for(int i = 1; i <= list.size() - 1; i++){
				if(!isEven(list.get(i))){
					list.remove(list.get(i));
					i--;
				}
			}
			//enhanced for loop used to print each int in ArrayList list
			System.out.println("=====Even Numbers: Enhanced For Loop====" + "\n");
			for(int num : list){
			System.out.println(num);
			}
	}
	
	//checks whether an int is even or odd.
		public static boolean isEven(int n) {
		    //check if n is divisible by 2
		    if (n % 2 == 0) {
		    	return true;
		    }else{
		    	return false;
		    }
		    	
		}

}

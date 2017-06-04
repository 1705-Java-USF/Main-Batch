package com.revature.question2;

public class HomeworkQuestionTwo {
	public static void main (String[] args){
		
		//number of Fibonacci's numbers to print
		int l = 25;
		
		long[] series = new long[l];
		
		//create the first 2 numbers in Fibonacci's sequence
		series[0] = 0;
		series [1] = 1;
		
		//Create Fibonacci's series and store in array
		for(int i = 2; i < l; i++){
			series[i] = series[i-1] + series[i-2];
		}
		
		//Print Fibonacci's series
		System.out.println("the fibonacci series up to 25:");
		for(int i = 0; i < l; i++){
			System.out.print(series[i] + ",");
		}
		
	}

}


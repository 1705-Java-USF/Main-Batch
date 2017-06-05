package com.javahw.qnine;

import java.util.ArrayList;
import java.util.List;

public class QNine {
	
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		//Insert numbers 1-100 to list 
		for(int i = 1; i <= 100; i++){
			l.add(i);
		}
		
		int timesDivisible = 0;
		//Iterate through list
		for(int num : l){
			timesDivisible = findNumOfFactors(num);
			
			//Prime number has exactly two integer factors
			if(timesDivisible == 2)
				System.out.println(num);	
		}
		
	}
	
	//Find number of factors
	public static int findNumOfFactors(int num){
		int factors = 0;
		for(int i = 1; i <= num; i++ ){
			if(num%i == 0)
				factors++;
		}
		return factors;
	}

}

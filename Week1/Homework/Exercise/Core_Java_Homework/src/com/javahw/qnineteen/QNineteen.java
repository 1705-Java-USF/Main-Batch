package com.javahw.qnineteen;

import com.javahw.qnine.*;

import java.util.ArrayList;
import java.util.List;

public class QNineteen {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		
		//Insert numbers 1-10 into ArrayList
		for(int i = 1; i <= 10; i++){
			l.add(i);
		}
		
		//Display ArrayList
		System.out.println(l);
		
		int oddSum = 0;
		
		//Add odd numbers and display to console
		for(int i = 0; i < 9; i += 2){
			oddSum += l.get(i);
		}
		System.out.println(oddSum);
		
		
		//Remove the prime numbers and display list
		for(int i = 0; i < l.size(); i++){
			if(QNine.findNumOfFactors(l.get(i)) == 2){
				l.remove(i);
				i = 0;
			}
		}
		
		System.out.println(l);
	}
}

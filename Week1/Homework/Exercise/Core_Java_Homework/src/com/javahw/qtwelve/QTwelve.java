package com.javahw.qtwelve;

public class QTwelve {

	public static void main(String[] args) {
		int[] numArr = new int[100];
		//Store numbers from 1-100 in array
		for(int i = 1; i <= 100; i++){
			numArr[i-1] = i;
		}
		
		//Print even numbers in array
		for(int num : numArr){
			if(num%2 == 0){
				System.out.println(num);
			}
		}
	}

}

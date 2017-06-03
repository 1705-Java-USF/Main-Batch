package com.revature.q4;

public class Main {
	public static void main(String args[]){
		int N = 5;
		int prod = 1;
		//multiplies the product by i for every number between 0 and N
		//including N
		for(int i = N; i > 1; i--)
			prod *= i;
		System.out.println(prod);
	}
}

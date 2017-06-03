package com.revature.q2;

public class Main {
	public static void main(String args[]){
		//25 element array
		int arr[] = new int[25];
		//initial elements
		arr[0] = 0;
		arr[1] = 1;
		//sums the previous two numbers into the current
		for(int i = 2; i < 25; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		//prints the 25th element
		System.out.println(arr[24]);
	}

}

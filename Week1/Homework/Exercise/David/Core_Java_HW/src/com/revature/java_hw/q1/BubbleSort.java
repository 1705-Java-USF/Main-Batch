package com.revature.java_hw.q1;

public class BubbleSort {

	public static void main(String[] args) {
		//Initialize given array
		int[] nums = {1,0,5,6,3,2,3,7,9,8,4};
		
		
		BubbleSort q = new BubbleSort();
		q.bubbleSort(nums);
		
		//Prints all numbers besides the last, followed by a comma
		for(int i=0; i < nums.length - 1; i++) {
			System.out.print(nums[i] + ",");
		}
		
		//Prints the last number without the comma.
		System.out.println(nums[nums.length-1]);
	}
	
	//Sorts an array of integers using the bubbleSort algorithm.
	public void bubbleSort(int[] nums) {
		//Last unsorted number starts as the index of the last number in the array
		int lastUnsorted = nums.length-1;
		do {
			//newend will be the last unsorted number after each iteration
			int newend = 0;
			//Loops through all unsorted numbers
			for(int i=0; i<lastUnsorted; i++) {
				//If the current number and next number are out of order, swap them
				if(nums[i] > nums[i+1]) {
					int temp = nums[i];
					nums[i] = nums[i+1];
					nums[i+1] = temp;
					//Last swap in each iteration means the remaining numbers are already sorted
					//The last unsorted number will be i
					newend = i;
				}
			}
			//Update lastUnsorted with the index to the new last unsorted number
			lastUnsorted = newend; 
		} while (lastUnsorted != 0); //Do this loop until all of the numbers have been sorted.
	}
}

package com.revature.question1;

public class Sorter {
	public static void main(String[] args)
	{
		int[] nums = {1,0,5,6,3,2,3,7,9,8,4}; //initial array
		Sorter s = new Sorter();
		s.bubbleSort(nums);
		for(int i: nums) // print out array
		{
			System.out.print(i + ", ");
		}
		
	}
	public void bubbleSort(int[] in)
	{
		boolean done = true; 
		for(int i = 0; i < in.length-1; i++) //iterate though array
		{
			if(in[i] > in[i+1] ) //if the next index is smaller swap them
			{
				int j = in[i];
				in[i] = in[i+1];
				in[i+1] = j;
				done = false; //flag to go through the array again when
			}
		}
		if(!done)
		{
			bubbleSort(in); //Iterate through array again.
		}
	}
	
}

package q12;

import java.util.ArrayList;

public class PrintEvens {

	public static void main(String[] args){
		PrintEvens pe = new PrintEvens();
		ArrayList<Integer> nums = new ArrayList<>();
		
		// build an ArrayList from 1 to 100
		for (int i = 1; i < 101; i++){
			nums.add(i);
		}
		
		// uses enhanced for loop to cycle through arrayList to print out all even numbers
		for (int num : nums){
			if (pe.isEven(num))
			System.out.println(num);
		}
	}
	
	// isEven method - returns true if i is an even number
	public boolean isEven(int i){
		if (i % 2 == 0) // even numbers are divisible by 2
			return true;
		else
			return false;
	}
	
}

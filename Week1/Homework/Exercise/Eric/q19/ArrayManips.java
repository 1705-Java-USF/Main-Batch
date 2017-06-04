package q19;

import java.util.ArrayList;
import q9.PrintPrimes; // import for prime removal

public class ArrayManips {

	public static void main(String[] args){
		
		// Initialize and fill the ArrayList
		ArrayList<Integer> nums = new ArrayList<>();
		for (int i = 1; i < 11; i++){
			nums.add(i);
		}
		
		// Output initial list
		System.out.println("Initial ArrayList:");
		System.out.println(nums);
		
		// stores even sum
		int sum_evens = 0;
		
		for (int num : nums){
			if (num % 2 == 0) // if current number even, add it to sum
				sum_evens += num;
		}
		
		// output
		System.out.println("Sum of even numbers: " + sum_evens);
		
		// stores odd sum
		int sum_odds = 0;
		
		for (int num : nums){
			if (num % 2 != 0) // if current number odd, add it to the sum
				sum_odds += num;
		}
		
		// output
		System.out.println("Sum of odd numbers: " + sum_odds);
		
		// Utilizes method from problem 9
		PrintPrimes pp = new PrintPrimes();
		
		for (int i = 0; i < nums.size(); i++){
			// check for primality 
			if (pp.is_prime(nums.get(i))){
				nums.remove(i); // remove from arraylist
				i--; // decrease by one to compensate for arraylist shrinking
			}
		}
		
		// output
		System.out.println("All non-prime numbers from the ArrayList: ");
		System.out.println(nums);
		
	}
	
}

package q1;

public class BubbleSort {

	public static void main(String[] args){
		BubbleSort bs = new BubbleSort();
		// initialize array as specified
		int[] nums = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		bs.sort(nums);
		
		// output of sorted array
		for (int num : nums){
			System.out.print(num + " ");
		}
		System.out.println("");
	}
	 
	//sort method - takes an array of ints and uses bubble sort to sort the array 
	public void sort(int[] l){
		boolean done; // boolean to keep track of whether two values were swapped
		do {
			done = true; // assume this is final pass through array
			// parses through the array, checking to see if two adjacent values
			// are not in order
			for (int i = 0; i < l.length - 1; i++){
				// swaps two adjacent values if the first is smaller than the next
				if (l[i] > l[i+1]){
					done = false; // values swapped, so needs to reiterate
					int j = l[i]; // temporary variable to store one swapped element
					l[i] = l[i+1];
					l[i+1] = j;
				}
			}
		} while (!done);
	}
}

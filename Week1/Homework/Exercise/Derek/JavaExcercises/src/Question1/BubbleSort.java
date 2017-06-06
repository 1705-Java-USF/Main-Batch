package Question1;

public class BubbleSort {

	public static void main(String[] args) {
		
		//Creating BubbleSort object and integer array
		BubbleSort b = new BubbleSort();
		int[] nums = {1,0,5,6,3,2,3,7,9,8,4};
		
		//Bubble sort the nums array
		//Print each element separated by commas
		b.sortBubbleArray(nums);
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ", ");
		}		
	}
	
	public void sortBubbleArray(int[] numArray) {
		
		//Assign length of array to n for simplicity
		int n = numArray.length;
		
		//Use a nested loop to check for each previous element
		//being greater then the next element in the array to swap
		//Otherwise continue the loop if no instance found of that case
		//In the end it will sort from smallest to highest
		for(int j = 0; j < n; j++) {
			for(int i = 1; i < (n - j); i++) {
				int temp = 0;
				if(numArray[i-1] > numArray[i]) {
					temp = numArray[i-1];
					numArray[i-1] = numArray[i];
					numArray[i] = temp;
				}
			}
		}
	}

}

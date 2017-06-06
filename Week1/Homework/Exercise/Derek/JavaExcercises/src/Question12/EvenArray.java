package Question12;

public class EvenArray {

	public static void main(String[] args) {
		
		/*
		 * Array of 100 integers with a regular FOR loop to store 1 to 100 in it.
		 * Then using a enhanced for FOR loop to print out each entry.
		 */
		int[] nums = new int[101];
		
		for(int i = 1; i < nums.length; i++) {
			nums[i] = i;
		}
		
		for (int num : nums) {
			System.out.println(num);
		}
		
	}

}

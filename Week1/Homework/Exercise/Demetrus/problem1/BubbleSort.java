/* Demetrus Atkinson
 * 
 */
package com.revature.problem1;

public class BubbleSort {

	public static void main(String[] args) {

		int[] array = { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		System.out.print("Original Array: ");

		// display original array
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}

		int temp; // holds the largest value for swapping

		// go through array and make comparisons
		for (int i = 0; i < array.length - 1; i++) { // go through entire array
			for (int j = i + 1; j < array.length; j++) { // always one index
															// ahead so
															// comparisions can
															// be made

				// swap (if needed)
				if (array[i] > array[j]) {
					// temp stores one of the values (the larger one) so it can
					// be saved for when the swap occurs
					temp = array[i];

					// move the current array[j] value on spot ahead to the j-1
					// (or i) index
					array[i] = array[j];

					// the temp holder variable can now be used for array[j] and
					// the swap is complete
					array[j] = temp;
				}
			}
		}
	
		System.out.println();
		System.out.print("Sorted Array After Bubble Sort: ");
		// print sorted array
		for (int k = 0; k < array.length; k++) {
			System.out.print(array[k]);
		}
	}
}

package com.revature.question16;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int total = 0;
		for (String s : args) { // Loop through arguments
			total += s.length(); // track total length of the arguments
			System.out.println("Length: " + s.length()); // Print out the length
															// of current
															// argument
		}
		System.out.println("Total: " + total); // print out total length of the
												// arguments
	}

}

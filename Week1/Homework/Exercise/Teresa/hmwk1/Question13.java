package com.revature.hmwk1;

import java.util.ArrayList;

public class Question13 {
	// Q13. Display the triangle on the console as follows using any type of loop
	// 0
	// 1 0
	// 1 0 1
	// 0 1 0 1
	
	// create variables
	private ArrayList<String> list;
	private String line;
	private boolean swt;
	final int LINES = 4;
	
	public Question13 () {
		// create arraylist owith strings of each line to print
		list = new ArrayList<String>();
		swt = true;
		for (int i = 0; i < LINES; i++) {
			line = "";
			for (int j = 0; j < i+1; j++) {
				if (swt) {
					line += "0 ";
					swt = false;
				} else {
					line += "1 ";
					swt = true;
				}
			}
			list.add(line);
		}
		// print all lines
		printLines();
	}

	private void printLines() {
		// uses enhanced for loop to print each line of triangle
		for (String str : list) {
			System.out.println(str);
		}
		
	}
}

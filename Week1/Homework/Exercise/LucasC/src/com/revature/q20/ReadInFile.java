package com.revature.q20;

import java.io.*;

public class ReadInFile {
	
	static BufferedReader in;
	final static String FILENAME = "Data";

	public static void main(String[] args) {
		
		try {
			in = new BufferedReader(new FileReader(FILENAME));  // file reader

			String line;

			while ((line = in.readLine()) != null) {  // keep reading file lines until there's a blank line
				
				String vals[] = line.split(":"); // every time there's a ':', then put it on the next index
				
				System.out.println("Name: " + vals[0] + " " + vals[1]);  
				System.out.println("Age: " + vals[2]);
				System.out.println("State: " + vals[3] + "\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}

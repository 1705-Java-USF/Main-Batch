package com.revature.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	static BufferedReader br;
	final static String FILENAME = "Data.txt";

	public static void main(String[] args) {
		try {
			//reader of the file
			br = new BufferedReader(new FileReader(FILENAME));

			//will store the current line of the file
			String s;

			//gos through each line of the file until the end
			while ((s = br.readLine()) != null) {
				//splits the string into an array with a ':' as a delimited
				String vals[] = s.split(":");
				//prints the output
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

package com.revature.java_hw.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
	public static BufferedReader br;
	
	public static void main(String[] args) throws IOException { //Throws IOException from br.close()
		//Try statement to handle specific exceptions given in catch blocks
		try {
			br = new BufferedReader(new FileReader("Data.txt"));
			
			String str;
			//Read in the file Data.txt one line at a time
			while((str = br.readLine()) != null) {
				//Split the line into an array of strings
				String[] arr = str.split(":");
				//Print out the array into the format requested.
				System.out.println("Name: " + arr[0] + " " + arr[1]);
				System.out.println("Age: " + arr[2] + " years");
				System.out.println("State: " + arr[3] + " State\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//Close the buffer
			if(br != null)
				br.close();
		}
	}

}

package com.revature.question_20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		
		try {
			br = new BufferedReader(new FileReader("Data.txt"));
			String line;
			String[] fileSeparated;
			
			// Split each line by ':' and print accordingly.
			while( (line = br.readLine()) != null) {
				fileSeparated = line.split(":");
				System.out.println("Name: " + fileSeparated[0] + " " + fileSeparated[1]);
				System.out.println("Age: " + fileSeparated[2] + " years");
				System.out.println("State: " + fileSeparated[3] + " State\n");
			}
	
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(br != null)
				br.close();
		}
	}
}

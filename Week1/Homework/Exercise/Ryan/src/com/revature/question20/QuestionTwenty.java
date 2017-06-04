package com.revature.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuestionTwenty {
	

		static BufferedReader br;
		final static String FILENAME = "Data.txt";

		public static void main(String[] args) {
			try {
				//reader of the file
				br = new BufferedReader(new FileReader(FILENAME));

				//will store the current string in the file
				String s;

				//Reads each line of the file as long as the lines are not null
				while ((s = br.readLine()) != null) {
					
					//splits the string into an array wherever it sees :
					String vals[] = s.split(":");
					//prints output
					//takes val[0] and val[1] because that will be first and last name
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
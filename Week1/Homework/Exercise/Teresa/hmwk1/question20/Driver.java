package com.revature.hmwk1.question20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	// Q20. Write a program that would read from the file 
	// and print it out to the screen in the following format
	
	final static String FILE_NAME = "Data.txt";
	public static ArrayList<Person> people;

	public static void main(String[] args) throws IOException {
		// propagating exception because specific file is required for question
		BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
		String str = br.readLine();
		people = new ArrayList<Person>();
		while (str != null) {
			String[] fields = str.split(":");
			people.add(new Person(fields[0], fields[1], fields[2], fields[3]));
			str = br.readLine();
		}
		for (Person p : people) {
			System.out.println(p);
		}
	}

}

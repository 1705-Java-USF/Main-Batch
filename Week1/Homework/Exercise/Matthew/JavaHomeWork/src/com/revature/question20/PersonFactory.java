package com.revature.question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonFactory {
	/*
	 * This class provides functions to create Person Objects from a String or
	 * from a File
	 */
	ArrayList<Person> people;
	BufferedReader br;

	public PersonFactory() {
		people = new ArrayList<Person>(); // Initialize Buffered Reader
	}

	/*
	 * creates and returns a Person object from a String
	 */
	public Person getPerson(String personString) {
		String[] splitString = personString.split(":");
		if (splitString.length >= 4) {
			String name = splitString[0] + " " + splitString[1]; // Combine
																	// first and
																	// last name
			int age = Integer.parseInt(splitString[2]); // Parse age from the
														// string
			String state = splitString[3];
			return new Person(name, age, state); // Return the new person
		}
		return null; // If the splitString is too small return null
	}

	public ArrayList<Person> getPersonFromFile(String filename) throws IOException {
		try {
			br = new BufferedReader(new FileReader(filename)); // Open a
																// BufferedReader
																// to read in
																// input
			String inStr; // String to store input
			while ((inStr = br.readLine()) != null) {
				Person p = getPerson(inStr); // get a person from a line of
												// input
				if (p != null) {
					people.add(p); // If the person is not null add the person
									// to the array list
				}
			}
			return people; // Return the array list
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				br.close(); // Finally close the Buffered Reader
			}
		}

		return null;
	}
}

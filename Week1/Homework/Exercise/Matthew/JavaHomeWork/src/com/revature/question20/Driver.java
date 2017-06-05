package com.revature.question20;

import java.io.IOException;
import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonFactory pf = new PersonFactory();
		ArrayList<Person> people;
		try {
			people = pf.getPersonFromFile("Data.txt");
			System.out.println("==================");
			for (Person p : people) {
				p.printPerson();
				System.out.println("==================");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

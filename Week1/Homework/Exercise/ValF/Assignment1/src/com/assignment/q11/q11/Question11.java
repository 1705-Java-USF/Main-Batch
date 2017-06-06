package com.assignment.q11.q11;

//Import float classs 
import com.assignment.q11.floats.Floats;

public class Question11 {

	public static void main(String[] args) 
	{
		//Create and instance of the float class
		Floats f = new Floats();

		//Display floats using getter functions
		System.out.println("These are the two floats located in Float"
				+ " class that live in another package: " + f.getF1()  + " and " + f.getF2());
	}

}

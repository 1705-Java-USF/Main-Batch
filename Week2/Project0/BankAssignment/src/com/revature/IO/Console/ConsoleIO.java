package com.revature.IO.Console;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class ConsoleIO {
	PrintStream out;
	Scanner in;
	private static Logger logger = Logger.getLogger(ConsoleIO.class);
	public ConsoleIO() {
		out = System.out;
		in = new Scanner(System.in);
	}

	public void write(String message) {
		out.println(message);
	}

	public String read() {
		return in.nextLine();
	}

	/*
	 * This overloaded message prints the message adding a space and then the
	 * variable
	 */
	public void write(String message, int i) {
		out.println(message + " " + i);
	}

	/*
	 * Prints message before adding space and printing object.toString()
	 * 
	 */
	public void write(String message, Object o) {
		out.println(message + " " + o.toString());
	}

	public void write(ArrayList<String> messages) {
		for (String s : messages) {
			out.println(s);
		}
	}
}

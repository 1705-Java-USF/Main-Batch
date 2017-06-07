/* Demetrus Atkinson
 * 
 */

package com.revature.problem20;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

	private Scanner scanner; // read in text file

	// string for rows of attributes
	String roger;
	String hulk;
	String mickey;
	String wonder;

	// Output file to be written to
	String FILENAME = "DataOut.txt";
	BufferedWriter bw = null;
	FileWriter fw = null;

	// open file, an exception is thrown if the file does not exist
	public void openFile() {
		try {
			scanner = new Scanner(new File("Data.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// reads and scans the file and propagates the IOException
	public void scanAndWrite() throws IOException {

		while (scanner.hasNext()) { // while there is still input to be read

			// these represent each new line delimited string in the file
			mickey = scanner.next();
			hulk = scanner.next();
			roger = scanner.next();
			wonder = scanner.next();
		}

		/*
		 * the string of combined attributes is further split by their delimiter
		 * ":"so each attribute is an index of a String array
		 */
		String[] r = roger.split(":");
		String[] m = mickey.split(":");
		String[] h = hulk.split(":");
		String[] w = wonder.split(":");

		try { // start writing to file. I/O must be in a try/catch block

			// writing with BufferedWriter
			bw = new BufferedWriter(new FileWriter(FILENAME));

			/*
			 * the following is the format that the output should be displayed
			 * in the format:
			 * 
			 * Name: 
			 * Age: 
			 * State:
			 */

			/*
			 * Mickey Mouse attributes: name, age, and state are displayed on
			 * separate lines
			 */
			bw.write("Name: " + m[0] + " " + m[1]);
			bw.newLine();
			bw.write("Age: " + m[2] + " years");
			bw.newLine();
			bw.write("State: " + m[3] + " State");

			bw.newLine();
			bw.newLine();

			/*
			 * Hulk Hogan attributes: name, age, and state are displayed on
			 * separate lines
			 */

			bw.write("Name: " + h[0] + " " + h[1]);
			bw.newLine();
			bw.write("Age: " + h[2] + " years");
			bw.newLine();
			bw.write("State: " + h[3] + " State");

			bw.newLine();
			bw.newLine();

			/*
			 * Roger Rabbit attributes: name, age, and state are displayed on
			 * separate lines
			 */

			bw.write("Name: " + r[0] + " " + r[1]);
			bw.newLine();
			bw.write("Age: " + r[2] + " years");
			bw.newLine();
			bw.write("State: " + r[3] + " State");

			bw.newLine();
			bw.newLine();

			/*
			 * Wonder Woman attributes: name, age, and state are displayed on
			 * separate lines
			 */
			bw.write("Name: " + w[0] + " " + w[1]);
			bw.newLine();
			bw.write("Age: " + w[2] + " years");
			bw.newLine();
			bw.write("State: " + w[3] + " State");
			bw.newLine();

		} catch (FileNotFoundException e) { // catch for FileNotFound
			e.printStackTrace();
		} catch (IOException e) { // catch for any other IOException
			e.printStackTrace();
		} finally { // always runs, always closes the writer after use
			if (bw != null) {
				bw.close();
			}
		}
		scanner.close(); // close scanner
	}
}

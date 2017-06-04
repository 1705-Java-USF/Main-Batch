package q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOEx {
	// Buffered Reader used to read from the input file
	static BufferedReader br;

	public static void main(String[] args) throws IOException {

		try {
			// Opens the input file to prepare for reading
			br = new BufferedReader(new FileReader("Data.txt"));
			String s = "";
			String[] strs;
			// read line by line
			while ((s = br.readLine()) != null) {
				strs = s.split(":"); // split up using ":" as a delimiter
				// outputs in the specified format
				System.out.println("Name: " + strs[0] + " " + strs[1]);
				System.out.println("Age: " + strs[2] + " years");
				System.out.println("State: " + strs[3] + " State");
				System.out.println();
			}
		} catch(FileNotFoundException e){ // Filename error
			e.printStackTrace();
		} catch (IOException e) { // General IO error
			e.printStackTrace();
		} finally {
			// Closes when finished or if error occurred
			if (br != null)
				br.close();
		}

	}

}

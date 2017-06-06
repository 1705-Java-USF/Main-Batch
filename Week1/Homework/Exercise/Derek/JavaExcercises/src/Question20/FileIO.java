package Question20;

//Import File and Scanner
import java.io.File;
import java.util.Scanner;

public class FileIO {

	public static void main(String[] args) throws Exception{
	    
		//Finds user directory and assigns to a string for convenience.
		//Then a new string to be able to add/place the text file into the directory.
		String s1 = System.getProperty("user.dir");
	    String s2 = s1 + "\\Data.txt";
		
	    //Create a scanner and delimit the input with \Z, making it have one token (entire file)
	    //It will read and assign to s3 as a string to the end of the string anchor.
	    //Then put it into a string array while splitting when there's a colon.
	    Scanner input = new Scanner(new File(s2));
	    String s3 = input.useDelimiter("\\Z").next();
		String[] s4 = s3.split("\\n|:");
		
		//Loops through the string array printing out the names, ages, and states one by one.
		//Based on the length between each split it prints accordingly to achieve the right format.
		for(int x = 0; x < s4.length; x++) {
			
			if(x%4 == 0) {
				System.out.print("Name: " + s4[x]);
			}
			else if(x%4 == 1) {
				System.out.print(" " + s4[x] + "\n");
			}
			else if(x%4 == 2) {
				System.out.println("Age: " + s4[x]);
			}
			else if(x%4 == 3) {
				System.out.println("State: " + s4[x]);
			}
		}
		//Close the scanner.
		input.close();
	}
}

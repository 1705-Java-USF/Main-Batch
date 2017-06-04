package CoreJavaHomework.src.q20;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Q20
{
	/*Create a notepad file called Data.txt and enter the following:
	 *  Mickey:Mouse:35:Arizona
	 *  Hulk:Hogan:50:Virginia
	 *  Roger:Rabbit:22:California
	 *  Wonder:Woman:18:Montana
	 *  
	 *  Write a program that would read from the file and print it out to the screen in the following format:
	 *  Name: Mickey Mouse
	 *  Age: 35 years  
	 *  State: Arizona State
	 */
	
	public static void main(String[] args)
	{
		//In this code block, I create the requisite text file. While the program requirements
		// do not necessitate the need for the program itself to make the file,
		// I don't see any harm in doing it this way.
		{
			final String[] TEXT_DOC_CONTENT = {"Mickey:Mouse:35:Arizona", "Hulk:Hogan:50:Virginia",
					"Roger:Rabbit:22:California", "Wonder:Woman:18:Montana"}; 
			
			PrintStream ps = null;
			
			try {
				ps = new PrintStream(new File("Data.txt"));
			} catch (FileNotFoundException e)
			{
				System.out.println("Could not create text file 'Data.txt'");
				e.printStackTrace();
				return;
			}
			
			for(String line : TEXT_DOC_CONTENT)
			{
				ps.println(line);
			}
		}
		
		//Here, I define the scanner that reads from the file.
		Scanner sc;
		try {
			Scanner temp = new Scanner(new File("Data.txt"));
			sc = temp.useDelimiter(":|\n| ");	//I tell the scanner to recognize colons as breaks
			temp.close();	//And close the scanner that still had the original delimiter
		} catch (FileNotFoundException e) {
			System.out.println("Could not open the created 'Data.txt'");
			e.printStackTrace();
			return;
		}
		
		//As long as there's more in the file, there's more people to read about.
		while(sc.hasNext())
		{
			String firstName, lastName, state;
			int age;
			//Here I read in the information found on one line.
			firstName = sc.next().trim();
			lastName = sc.next().trim();
			age = sc.nextInt();
			state = sc.next().trim();
			
			System.out.println("Name: " + firstName + " " + lastName);
			System.out.println("Age: " + age + " years");
			System.out.println("State: " + state + " State");
			System.out.println();
		}
		sc.close();
	}
}

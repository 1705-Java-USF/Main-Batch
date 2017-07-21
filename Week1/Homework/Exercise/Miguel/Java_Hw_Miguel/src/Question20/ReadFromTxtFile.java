package Question20;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromTxtFile {

	public static void main(String[] args) {
		
		String line = null;
		
		try
		{
			FileInputStream fstream = new FileInputStream("Data.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while((line=br.readLine())!=null) //repeat until end of file
			{
				String[] words = line.split(":"); //split line to words
				System.out.println("\nName: "+words[0]+" "+words[1]); //printing first and last name
				System.out.println("Age: "+words[2]+" years"); //printing age
				System.out.println("State: "+words[3]+" State");
					
			}
			br.close(); //finally close the buffer
		}
		catch(IOException ie)
		{System.out.println(ie);}
	}

}



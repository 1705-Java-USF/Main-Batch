package com.assignment.q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Question20 
{
	BufferedReader fr;
	
	public static void main(String[] args) 
	{
		Question20 q = new Question20();
		try 
		{
			//Call read file method
			q.readFile();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void readFile() throws IOException
	{
		try 
		{	//Initialize buffered reader, and empty buffer string
			fr = new BufferedReader(new FileReader("file1.txt"));
			String buff = "";
			
			//Read one complete line at a time
			while((buff= fr.readLine()) != null)
			{
				//Call create person and pass the whole scanned line
				createPerson(buff);
			}
			
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		//Close file reader
		fr.close();
	}
	
	//Str variable hold complete line scanned from file
	public void createPerson(String str)
	{
		//Variables: person to store and print person, three integer values to 
		//store the index values of ':'
		Person p = new Person();
		int col1 = 0, col2 = 0, col3 = 0;
		
		//Find first ':'
		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == ':')
			{
				col1 = i;
				break;
			}
		}
		//Find second ':'
		for(int i = (col1 + 1); i < str.length(); i++)
		{
			if(str.charAt(i) == ':')
			{
				col2 = i;
				break;
			}
		}
		//Find thirs ':'
		for(int i = (col2 + 1); i < str.length(); i++)
		{
			if(str.charAt(i) == ':')
			{
				col3 = i;
				break;
			}
		}
		
		//Set person attributes by using splitting str variable
		p.setFirstName(str.substring(0, col1));
		p.setLastName(str.substring((col1 + 1), col2));
		p.setAge(str.substring((col2 + 1),col3));
		p.setState(str.substring((col3 + 1)));
		
		//Print person info
		p.printPerson();
	}
}

package com.javahw.qtwenty;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QTwenty {
	
	FileReader fr;
	static final String FILENAME = "Data.txt";
	
	public static void main(String[] args) {
		QTwenty test = new QTwenty();
		
		//Create a string array made up of the words in the file
		String[] words = test.fileToString(FILENAME).split("\r\n|:");
	
		
		for(int i = 0; i < words.length; i += 4){
			System.out.println("Name: "+ words[i] + " " + words[i+1]);
			System.out.println("Age: " + words[i+2] +" years");
			System.out.println("State: " + words[i+3]+" State");
			System.out.println();
		}
		
		
	}	
	
	public String fileToString(String filename){
		String file = "";
		try {
			//Create FileReader object taking in a file
			fr = new FileReader(filename);
			
			int in;
			
			//Traverse document
			while( (in = fr.read()) != -1 ){
				file += (char)in;
			}
			
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file;
		
	}

}

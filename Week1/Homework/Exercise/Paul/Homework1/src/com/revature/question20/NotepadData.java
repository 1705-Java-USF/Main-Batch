package com.revature.question20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

	
	public class NotepadData {
		private static BufferedReader br;

		public static void main(String[] args) throws IOException {
			  //Create new file Data.txt  
			  String fileName = "Data.txt";
			  
			 
			  StringTokenizer st = null; 
			  
			  File fc = new File(fileName);//Created object of java File class.
			  fc.createNewFile();//Create file.
			  
			  //Writing to file.
			  //Create Object of java FileWriter and BufferedWriter class.
			  FileWriter fw = new FileWriter(fileName);
			  BufferedWriter bw = new BufferedWriter(fw);
			  bw.write("Mickey:Mouse:35:Arizona"); //Write to file
			  bw.newLine();//To write next string on new line.
			  bw.write("Hulk:Hogan:50:Virginia"); 
			  bw.newLine();
			  bw.write("Roger:Rabbit:22:California"); 
			  bw.newLine();
			  bw.write("Wonder:Woman:18:Montana"); 
			  bw.close();
			  
			  //Reading from file.
			  //Create Object of java FileReader and BufferedReader class.
			  FileReader fr = new FileReader(fileName);
			  br = new BufferedReader(fr);
			  String file = "";
			  
			  try{
			  //Loop to read all lines one by one from file and print It.
			  while((file = br.readLine())!= null){
			   st = new StringTokenizer(file, ":");
			   String [] data = {"Name", "Age", "State"};
			   
			   int i = 0;
			   
			   //Parse through the name 
			   System.out.println(data[i] + ":" + st.nextToken() + " " + st.nextToken());
			   
			   //Parse through the age and state
			   while(st.hasMoreTokens()){
				   i++;
				   System.out.println(data[i] + ":" + st.nextToken());
			   }
			   System.out.println();
			  }
			 }catch(FileNotFoundException e){
				 e.printStackTrace();
			 }catch(IOException e){
				 e.printStackTrace();
			 }
		}
		
	}
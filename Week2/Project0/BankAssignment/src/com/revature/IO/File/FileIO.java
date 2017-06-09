package com.revature.IO.File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;



public class FileIO {
	private String filename;
	BufferedReader filein;
	BufferedWriter fileout;
	private Logger logger = Logger.getLogger(FileIO.class);
	public FileIO(String filename)
	{
		
		this.filename = filename;
		logger.trace("FileIO created with: " + filename);
	}
	
	public void write(ArrayList<Object> objects) throws IOException
	{
		try{
			fileout = new BufferedWriter(new FileWriter(filename));
			for(Object o: objects)
			{
				
				fileout.write(o.toString());
				fileout.newLine();
				logger.trace("FileIO.write wrote to file");
			}
		}catch(IOException e)
		{
			logger.error("An IOException has been thrown");
			logger.error(e.getMessage());
			e.printStackTrace();
		}finally{
			if(fileout != null)
			{
				logger.debug("fileout closed");
				fileout.close();
			}
		}
	}
	
	public ArrayList<String> read() throws IOException
	{
		try{
			ArrayList<String> input = new ArrayList<String>();
			filein = new BufferedReader(new FileReader(filename));
			String temp;
			while( (temp = filein.readLine()) != null)
			{
				input.add(temp);
				logger.trace("read from file");
			}
			
			return input;
		}catch(FileNotFoundException e)
		{
			logger.error(filename + " was not found");
			e.printStackTrace();
		}catch(IOException e)
		{
			logger.error("IOException has been caught");
			logger.error(e.getMessage());
			e.printStackTrace();
		}finally
		{
			if(filein != null)
			{
				filein.close();
				logger.debug("filein closed");
			}
		}
		return null;
	}
	public String getFilename()
	{
		return filename;
	}
	public void setFileName(String filename)
	{
		this.filename = filename;
		logger.trace("filename set to: " + filename);
	}

}

package com.revature.day4;

import org.apache.log4j.Logger;

/*
 * To import external JARs.
 * Simply Right click on the ROOT project folder.
 * -go to: Build Path> Add External Archives > select the JAR you wish to use.
 * 
 * 
 */

public class LoggingExample {

	//final static Logger logger = Logger.getRootLogger();
	final static Logger logger = Logger.getLogger(LoggingExample.class);

	public static void main(String[] args) {

		LoggingExample le = new LoggingExample();
		le.logStuff();
	}

	public void logStuff(){
		
		try{
		for(int i = 0; i < 10; i++){
			int j = i/i;
		}
		}catch( ArithmeticException e){
			logger.error("Arithmetic Exception thrown!");
		}
		logger.debug("Program execution finishes properly");
		
		logger.trace("TRACE");
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.warn("WARN");
		logger.error("ERROR");
		logger.fatal("FATAL");
	}

}

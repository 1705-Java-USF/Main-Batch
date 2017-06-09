/* Demetrus Atkinson */
package com.revature.project000;
import org.apache.log4j.Logger;

/* Primary logger for the main BankAccountID class has some created methods for certain events */
public class Logging {
	
	// logger needed 
	final static Logger logger = Logger.getLogger(Logging.class);

	//logging exceptions
	 public static void logException() {
		 logger.error("ERROR -- EXCEPTION");
	 }
	public void logIOException() {
		logger.error("ERROR -- IO EXCEPTION");
	}
	
	public void logFileNotFound() {
		logger.error("ERROR -- FILENOTFOUND EXCEPTION");
	}
	
	// log for a successful program run
	public void logDebug() {
		logger.debug("Program execution finishes properly");
	}
	
	// log for when nothing is added for writing
	public void logInfo() {
		logger.info("There is nothing new to write");
	}
	
	//log for no file 
	public void logNoFile(){
		logger.warn("WARN -- No File Provided");
	}
	// whenever an object is created, it is logged
	public void objectCreated(){
		
		logger.info("A new object was created");
	}
	
	// log for when objects are ready to print
	public void readyToPrint(){
		logger.info("Objects ready to print");
	}
}

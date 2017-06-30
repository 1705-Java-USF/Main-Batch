package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {    // this class will create the connection with the SQL DB

	private static Properties prop;
	// file that has my login credentials:
	private final static String FILE_NAME = "connection.prop";  

	public static Connection getConnection() throws SQLException {
		try {

			prop = new Properties();
			// Property object will translate the key value pairs of our file.
			 prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME)); // opeing file

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		 FOR AWS
//		 jdbc:oracle:thin:@sandbox.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orcl
//		 
//		 Getting url, username and password from file
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // this is the driver to connect to oracle database
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		return DriverManager.getConnection(url, username, password); //returning those parameters
	}
}

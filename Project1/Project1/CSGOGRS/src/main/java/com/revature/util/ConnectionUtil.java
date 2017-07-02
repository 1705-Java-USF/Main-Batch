package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Properties prop;
	private static final String FILE_NAME = "connection.prop";
	
	//Factory embedded already into JDBC
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		try {
			prop = new Properties();
			//Property object will translate the key value pairs of our file
			
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Manages drivers to connect to the database
		return DriverManager.getConnection(url, username, password);
	}
}

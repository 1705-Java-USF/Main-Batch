package com.corvusanalyzes.util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnectionUtil {
	private static Properties prop = new Properties();
	private final static String FILE_NAME = "DBconnection.prop";
	
	public static Connection getConnection() throws SQLException {
		try {
			// Property object will translate the key value pairs of our file.
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
		}
		
		return DriverManager.getConnection(url, username, password);
	}
}

package com.revature.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Properties prop;
	private final static String FILE_NAME = "connection.prop";
	
	public static Connection getConnection() throws SQLException{

		try {
			
			prop = new Properties();
			//prop.load(new FileInputStream(FILE_NAME));
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String url = prop.getProperty("url");
		//FOR AWS
		//jdbc:oracle:thin:@sandbox.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orc1
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return DriverManager.getConnection(url, username, password);
	}
}

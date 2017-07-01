package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {

	final static Logger logger = Logger.getLogger(ConnectionUtil.class);

	private static Properties prop;
	private final static String FILE_NAME = "connection.prop";

	public static Connection getConnection() throws SQLException {
		
		try {
			prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME));
		} catch (FileNotFoundException e) {
			logger.warn("File Not Found Exception was caught");
			e.printStackTrace();
		} catch (IOException e) {
			logger.warn("IO Exception was caught");
			e.printStackTrace();
		}

		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("pass");
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			logger.warn("Class Not Found Exception was caught");
			e.printStackTrace();
		}
		
		return DriverManager.getConnection(url, username, password);
	}
}

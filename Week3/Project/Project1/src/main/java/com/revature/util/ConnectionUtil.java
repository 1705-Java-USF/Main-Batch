package com.revature.util;

import static com.revature.util.CloseStreams.close;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Properties prop;
	private static ConnectionUtil inst;
	private Connection conn;
	private String url;
	private String username;
	private String password;
	
	public static ConnectionUtil getConnectionUtil() {
		if(inst == null) {
			inst = new ConnectionUtil();
		}
		return inst;
	}
	
	private ConnectionUtil() {
		try {
			prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("connection.prop"));
			url = prop.getProperty("url");
			username = prop.getProperty("user");
			password = prop.getProperty("pass");
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		
		if(conn == null || conn.isClosed()) {
			conn = DriverManager.getConnection(url, username, password);
		}
		return conn;
	}
	
	public void finalize() {
		close(conn);
	}

}

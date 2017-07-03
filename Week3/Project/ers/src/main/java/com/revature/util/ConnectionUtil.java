package com.revature.util;

import static com.revature.util.StreamCloser.closeStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionUtil {
	
	private static Properties prop;
	private final static String FILE_NAME = "connection.properties";
	private Logger logger = Logger.getLogger(ConnectionUtil.class);
	private String url;
	private String username;
	private String password;
	private Connection connection;
	private static ConnectionUtil instance;
	public static ConnectionUtil getConnectionUtil(){
		if(instance == null)
		{
			instance = new ConnectionUtil();
			
		}
		return instance;
	}
	private ConnectionUtil(){
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e)
		{
			logger.error(e.getMessage(), e);
		}
		try{
			prop= new Properties();
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE_NAME));
			logger.debug("Properties loaded");
			
			
		}catch(FileNotFoundException e)
		{
			logger.debug(System.getProperty("user.dir"));
			logger.error(e.getMessage(), e);
		}catch(IOException e)
		{
			logger.error(e.getMessage(), e);
		}
		url = prop.getProperty("url");
		username = prop.getProperty("user");
		password = prop.getProperty("pass");
	}
	
	public Connection getConnection() throws SQLException
	{
		if(connection == null || connection.isClosed())
		{
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	
	public void finalize()
	{
		closeStream(connection);
	}
	
}

package main.java.com.revature.util;


	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

	public class ConnectionUtil{
		private static Properties prop;
		private final static String FILE_NAME = "connection.prop";
		
		public static Connection getConnection() throws SQLException{
			try {
				
				prop = new Properties();
				//Property object will translate the key value pairs of our file.
				prop.load(new FileInputStream(FILE_NAME));
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String url = prop.getProperty("url");
			//FOR AWS
			//jdbc:oracle:thin:@sandbox.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orcl
			String username = prop.getProperty("user");
			String password = prop.getProperty("pass");
			
			return DriverManager.getConnection(url, username, password);
		}
	}


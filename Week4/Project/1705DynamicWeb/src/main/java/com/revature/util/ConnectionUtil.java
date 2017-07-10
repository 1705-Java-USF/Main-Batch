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
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		
		
		
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Project1", "minimize");
		
	}
}

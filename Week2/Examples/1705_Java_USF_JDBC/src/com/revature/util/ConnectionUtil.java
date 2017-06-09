package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil{
	
	public static Connection getConnection() throws SQLException{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//FOR AWS
		//jdbc:oracle:thin:@sandbox.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orcl
		String username = "admin";
		String password = "admin";
		
		return DriverManager.getConnection(url, username, password);
	}
}

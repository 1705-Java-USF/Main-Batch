package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class CloseStreams {
	
	final static Logger logger = Logger.getLogger(CloseStreams.class);

	public static void close(Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.warn("SQL Exception was caught: " + e.getMessage());
			}
		}
	}
	public static void close(PreparedStatement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.warn("SQL Exception was caught: " + e.getMessage());
			}
		}
	}
	public static void close(CallableStatement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				logger.warn("SQL Exception was caught: " + e.getMessage());
			}
		}
	}
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				logger.warn("SQL Exception was caught: " + e.getMessage());
			}
		}
	}
	public static void close(FileInputStream fis){
		if(fis != null){
			try {
				fis.close();
			} catch (IOException e) {
				logger.warn("IO Exception was caught: " + e.getMessage());
			}
		}
	}

}

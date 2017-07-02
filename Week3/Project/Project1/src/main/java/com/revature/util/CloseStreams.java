package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseStreams {
	
	public static void close(AutoCloseable stream) {
		if(stream != null) {
			try {
				stream.close();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

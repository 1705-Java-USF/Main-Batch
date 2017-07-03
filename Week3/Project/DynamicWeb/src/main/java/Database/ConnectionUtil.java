package Database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static Properties prop;
	
	public static Connection getConnection() throws SQLException {
		try {
			// Property object will translate key value pairs of our file
			/*prop = new Properties();
			prop.load(new FileInputStream("Connection.prop"));*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("password");*/
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Temporary until connection.prop file works
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "Project1";
		String password = "pjVzzQ_[S20u|aZk";
		
		return DriverManager.getConnection(url, username, password);
	}

}
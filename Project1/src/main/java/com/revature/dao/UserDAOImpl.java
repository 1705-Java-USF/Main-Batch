package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.pojo.EmployeeObject;
import com.revature.util.ConnectionUtil;
import static com.revature.util.CloseStreams.close;

public class UserDAOImpl implements UserDAO{

	@Override
	public void createEmployee(EmployeeObject employee) { // an employee object is passed in
		
		// creating PS which will run queries
		PreparedStatement ps = null;
		
		// looks in util/ConnectionUtil.java and saves the url, username and password to "conn"
		try(Connection conn = ConnectionUtil.getConnection();){ 
			
			// using methods from EmployeeObject POJO
			//int id = employee.getUser_id(); // USER_ID IS AUTO INCREMENTING
			int role_id = employee.getUser_role_id();
			String username = employee.getUser_username();
			String password = employee.getUser_password();
			String first_name = employee.getUser_first_name();
			String last_name = employee.getUser_last_name();
			String email = employee.getUser_email();
			int status = employee.getUser_status();
			
			// you can put this string 'sql' into multiple lines by adding +, and having everything within ""
			// this sql line will be ran on SQL
			String sql = "INSERT INTO ERS_USERS(user_id, user_role_id, user_username,"
					+ "user_password, user_first_name, user_last_name, user_email, user_status) " 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			
			// creating prepared statement
			ps = conn.prepareStatement(sql);  // uses connection to send string as a prepared statement
			ps.setString(1, null);   // USER_ID IS AUTO INCREMENTING
			ps.setInt(2, role_id);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, first_name);
			ps.setString(6, last_name);
			ps.setString(7, email);
			ps.setInt(8, status);
			
			// rows affected
			int affected = ps.executeUpdate();
			System.out.println("Rows inserted: " + affected);
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		
		System.out.println("Created new employee");
		
		
	}

	@Override
	public EmployeeObject selectEmployeeByUsername(String user) {
		
		System.out.println("UDI 1 - Selecting employee by username");
		
		EmployeeObject emp = null;
		PreparedStatement ps = null;  // creating another preparedStatement
		ResultSet rs = null;  // creating a resultSet which will save any queries
		
		try(Connection conn = ConnectionUtil.getConnection();){ // checking connection again
			
			System.out.println("UDI 2 - Going in connection");
			
			String sql = "SELECT * FROM ERS_USERS WHERE USER_USERNAME = ?";
			
			ps = conn.prepareStatement(sql); // running the sql and puts that's in a ps variable
			ps.setString(1, user);  // replace the ?s for user and pass
						
			rs = ps.executeQuery();  // saves the query result in a rs variable
			
			while (rs.next())  // goes through all query results (in this case, we should only have 1)
			{
				emp = new EmployeeObject();
				// get first column of rs, then set it ==
				emp.setUser_id(rs.getInt(1));  
				emp.setUser_role_id(rs.getInt(2));
				emp.setUser_username(rs.getString(3));
				emp.setUser_password(rs.getString(4));
				emp.setUser_first_name(rs.getString(5));
				emp.setUser_last_name(rs.getString(6));
				emp.setUser_email(rs.getString(7));
				emp.setUser_status(rs.getInt(8));	
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
			close(rs);
		}
		//System.out.println("UDI 3 - Returning emp: " + emp.getUser_username());
		return emp;
	}
	

	@Override
	public ArrayList<EmployeeObject> selectEmployee() {
		
		System.out.println("-----");
		System.out.println("This will print out all employees in an ArrayList");
		
		ArrayList<EmployeeObject> ar = new ArrayList<>();
		EmployeeObject emp = null;
		PreparedStatement ps = null;  // creating another preparedStatement
		ResultSet rs = null;  // creating a resultSet which will save any queries
		
		try(Connection conn = ConnectionUtil.getConnection();){ // checking connection again
			
			System.out.println("Going in connection");
			
			// if role_id is 2, then its an employee 
			String sql = "SELECT * FROM ERS_USERS WHERE USER_ROLE_ID = 2 ORDER BY USER_ID"; // display them by USER_ID order
			
			ps = conn.prepareStatement(sql); // running the sql and puts that's in a ps variable
						
			rs = ps.executeQuery();  // saves the query result in a rs variable
			
			while (rs.next())  // goes through all query results (in this case, we should only have 1)
			{
				// get first column of rs, then set it ==
				emp = new EmployeeObject();
				emp.setUser_id(rs.getInt(1));  
				emp.setUser_role_id(rs.getInt(2));
				emp.setUser_username(rs.getString(3));
				emp.setUser_password(rs.getString(4));
				emp.setUser_first_name(rs.getString(5));
				emp.setUser_last_name(rs.getString(6));
				emp.setUser_email(rs.getString(7));
				emp.setUser_status(rs.getInt(8));
				ar.add(emp);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
			close(rs);
		}
		System.out.println("Returning array: " + ar);
		
		return ar;
	}

	@Override
	public EmployeeObject updateEmployee(EmployeeObject employee) {
		
		System.out.println("UDI - updatting employee");
		
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try (Connection conn = ConnectionUtil.getConnection();) // checking that connection is proper
		{
			String sql = "UPDATE ERS_USERS SET "  // query to update that user
					+ "user_role_id = ?, "
					+ "user_username = ?, " 
					+ "user_password = ?, "
					+ "user_first_name = ?, "
					+ "user_last_name = ?, "
					+ "user_email = ?, "
					+ "user_status = ? "
					+ "WHERE user_id = ? ";		// where his id is what was given
			
			ps = conn.prepareStatement(sql); // running the sql and puts that's in a ps variable
						
			ps.setInt(1, employee.getUser_role_id());    
			ps.setString(2, employee.getUser_username());
			ps.setString(3, employee.getUser_password());
			ps.setString(4, employee.getUser_first_name());
			ps.setString(5, employee.getUser_last_name());
			ps.setString(6, employee.getUser_email());
			ps.setInt(7, employee.getUser_status());
			ps.setInt(8, employee.getUser_id());
			
			rs = ps.executeQuery();  // saves the query result in a rs variable and execute it
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
			close(rs);
		}
		
		return employee;
	}

	@Override
	public void deleteEmployeeById(int id) {
		
		System.out.println("UID - deleting employee");
		
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try (Connection conn = ConnectionUtil.getConnection();) // checking that connection is proper
		{
			String sql = "UPDATE ERS_USERS SET "  // query to update that user
					+ "user_status = ? "
					+ "WHERE user_id = ? ";		// where his id is what was given
			
			ps = conn.prepareStatement(sql); // running the sql and puts that's in a ps variable
						
			ps.setInt(1, 2);    // making user_status = 2, since that is inactive
			ps.setInt(2, id);
			
			rs = ps.executeQuery();  // saves the query result in a rs variable and execute it
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
			close(rs);
		}
		
		
	}
	
	

}

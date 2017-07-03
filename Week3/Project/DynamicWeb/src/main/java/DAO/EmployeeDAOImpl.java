package DAO;

import static Database.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Database.ConnectionUtil;
import Database.EmployeePOJO;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	/*
	 * This method will add a new employee to the database
	 */
	@Override
	public void AddEmployee(EmployeePOJO emp) {
		Statement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			int id = emp.getId();
			String fn = emp.getFn();
			String ln = emp.getLn();
			String addr = emp.getAddr();
			String city = emp.getCity();
			String st = emp.getSt();
			String zip = emp.getZip();
			String phone = emp.getPhone();
			String email = emp.getEmail();
			int role = emp.getRole();
			String userid = emp.getUserid();
			String pwd = emp.getPwd();
			
			// Creating the SQL statement that will insert the new row into the database
			String sql = "INSERT INTO Users VALUES (" + id + ", '"
													  + fn + "', '"
													  + ln + "', '"
													  + addr + "', '"
													  + city + "', '"
													  + st + "', '"
													  + zip + "', '"
													  + phone + "', '"
													  + email + "', "
													  + role + ", '"
													  + userid + "', '"
													  + pwd + "')";
			
			stmt = conn.createStatement();
			int affected = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	};
	
	
	/*
	 * This method will be used to delete employees
	 */
	@Override
	public void DeleteEmployee(int id) {
		
	};
	
	/*
	 * This method will return a list of employees
	 */
	@Override
	public List<EmployeePOJO> getAllEmps() {
		ResultSet rs = null;
		
		LinkedList<EmployeePOJO> empList = new LinkedList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			Statement stmt = null;
			String sql = "SELECT * FROM Users WHERE Role=1 ORDER BY LastName";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				empList.add(new EmployeePOJO(rs.getInt(1),
											 rs.getString(2),
											 rs.getString(3),
											 rs.getString(4),
											 rs.getString(5),
											 rs.getString(6),
											 rs.getString(7),
											 rs.getString(8),
											 rs.getString(9),
											 rs.getInt(10),
											 rs.getString(11),
											 rs.getString(12)
										));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
		}
		
		return empList;
	};
	
	/*
	 * This method will select a single employee from a query
	 */
	@Override
	public EmployeePOJO selectEmpByID(int id) {
		Statement stmt = null;
		EmployeePOJO pojo = new EmployeePOJO();
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql = "SELECT * FROM Users WHERE UserID='" +
						id + "'";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				pojo.setId(rs.getInt("UserID"));
				pojo.setFn(rs.getString("FirstName"));
				pojo.setLn(rs.getString("LastName"));
				pojo.setAddr(rs.getString("Address"));
				pojo.setCity(rs.getString("City"));
				pojo.setSt(rs.getString("State"));
				pojo.setZip(rs.getString("Zip"));
				pojo.setPhone(rs.getString("Phone"));
				pojo.setEmail(rs.getString("Email"));
				pojo.setRole(rs.getInt("Role"));
				pojo.setUserid(rs.getString("Username"));
				pojo.setPwd(rs.getString(""));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pojo;
	};
	
	/*
	 * This method will select a single employee based on the
	 * username and return the password
	 */
	public String selectPassByLogin(String name) {
		Statement stmt = null;
		String pwd = "password"; /*
								* If no user is found in the system, this
								* will return "password" and the FrontController
								* will know that this value means that no user
								* was found.
								*/
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			String sql = "SELECT Password FROM Users WHERE UserName='"
					+ name + "'";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				pwd = rs.getString("Password");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return pwd;
	};
	
	/*
	 * This method will select a single employee based on the
	 * username and return the employee object
	 */
	public EmployeePOJO selectEmpByUser(String name) {
		Statement stmt = null;
		EmployeePOJO pojo = new EmployeePOJO();
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			String sql = "SELECT * FROM Users WHERE Username='" +
						name + "'";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				pojo.setId(rs.getInt("UserID"));
				pojo.setFn(rs.getString("FirstName"));
				pojo.setLn(rs.getString("LastName"));
				pojo.setAddr(rs.getString("Address"));
				pojo.setCity(rs.getString("City"));
				pojo.setSt(rs.getString("State"));
				pojo.setZip(rs.getString("Zip"));
				pojo.setPhone(rs.getString("Phone"));
				pojo.setEmail(rs.getString("Email"));
				pojo.setRole(rs.getInt("Role"));
				pojo.setUserid(rs.getString("Username"));
				pojo.setPwd(rs.getString(""));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pojo;
	};
	
	
	/*
	 * This method will allow an employee or manager to update
	 * an employee's info
	 */
	@Override
	public void UpdateEmployee(EmployeePOJO emp) {
		
	};
	
	/*
	 * This method changes the user's password
	 */
	@Override
	public void ChangePassword(String username, String password) {
		Statement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			String sql = "UPDATE Users SET Password='" + password +
					"' WHERE UserName='" + username + "'";
			
			stmt = conn.createStatement();
			int affected = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
	};
	
	/*
	 * This will update the employee's personal information
	 */
	public void UpdateEmpInfo(String username,
			  String address,
			  String city,
			  String state,
			  String zip,
			  String phone,
			  String email) {
		Statement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			String sql = "UPDATE Users SET Address='" + address + "', " +
					"City='" + city + "', " +
					"State='" + state + "', " +
					"Zip='" + zip + "', " +
					"Phone='" + phone + "', " +
					"eMail='" + email + "' WHERE UserName='" + username + "'";
			
			stmt = conn.createStatement();
			int affected = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	};
	
	/*
	 * Get the highest employee ID number, then return it.  This is used
	 * when adding a new employee so that a new ID number can be created.
	 */
	@Override
	public int GetMaxId() {
		Statement stmt = null;
		int maxId = 0;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			String sql = "SELECT MAX(UserID) FROM Users";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				maxId = rs.getInt("Max(UserID)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return maxId;
	};

}

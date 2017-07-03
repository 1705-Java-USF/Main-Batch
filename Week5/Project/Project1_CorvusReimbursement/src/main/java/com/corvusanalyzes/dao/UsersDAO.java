package com.corvusanalyzes.dao;

import static com.corvusanalyzes.util.CloseStreams.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.corvusanalyzes.pojos.Reimbursement;
import com.corvusanalyzes.pojos.User;
import com.corvusanalyzes.util.DBConnectionUtil;


public class UsersDAO implements UsersDAOInterface {

	@Override
	public void createUser(User user) {
		CallableStatement cs = null;
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String PLQuery = "{call insert_user_proc(?, ?, ?, ?, ?, ?)}";
			cs = conn.prepareCall(PLQuery);
			cs.setString(1, user.getUsername());
			cs.setString(2, user.getPassword());
			cs.setString(3, user.getFirstname());
			cs.setString(4, user.getLastname());
			cs.setString(5, user.getEmail());
			if(user.getRole().equals("Contributor")) cs.setInt(6, 1);	// 1 is contributor.
			else if(user.getRole().equals("Manager")) cs.setInt(6, 2);	// 2 is manager.
			cs.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(cs);
		}
	}

	@Override
	public String selectPasswordByUsername(String username) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "SELECT u_password FROM Users WHERE u_username = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("u_password");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public List<User> selectAllUsers() {
		PreparedStatement ps = null;
		List<User> users = new ArrayList<>();
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {
			String query = "SELECT * FROM users";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt("u_id"));
				user.setUsername(rs.getString("u_username"));
				user.setFirstname(rs.getString("u_firstname"));
				user.setLastname(rs.getString("u_lastname"));
				user.setEmail(rs.getString("u_email"));
				if(rs.getInt("urole_id") == 1) user.setRole("Contributor");		// 1 is contributor.
				else if(rs.getInt("urole_id") == 2) user.setRole("Manager");	// 2 is manager.
				
				users.add(user);
			}
			
			return users;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public User selectUserByUsername(String username) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = new User();
		
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "SELECT u_username, u_firstname, u_lastname, u_email, urole_role FROM Users NATURAL JOIN User_roles WHERE u_username = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUsername(rs.getString("u_username"));
				user.setFirstname(rs.getString("u_firstname"));
				user.setLastname(rs.getString("u_lastname"));
				user.setEmail(rs.getString("u_email"));
				user.setRole(rs.getString("urole_role"));
			}
			return user;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public List<String> selectAllUsernames() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> usernames = new ArrayList<>();
		
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "SELECT u_username FROM users";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				usernames.add(rs.getString("u_username"));
			}
			return usernames;
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public void updateUser(String username, String password, String firstname, String lastname, String email, String oldusername) {
		CallableStatement cs = null;
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String PLQuery = "{call update_user_proc(?, ?, ?, ?, ?, ?)}";
			cs = conn.prepareCall(PLQuery);
			cs.setString(1, username);
			cs.setString(2, password);
			cs.setString(3, firstname);
			cs.setString(4, lastname);
			cs.setString(5, email);
			cs.setString(6, oldusername);
			cs.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(cs);
		}
	}

	@Override
	public String selectUsernameById(int author_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "SELECT u_username FROM Users WHERE u_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			rs.next();
			return rs.getString("u_username");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public int selectIdByUsername(String username) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "SELECT u_id FROM Users WHERE u_username = ?";
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			rs.next();
			return rs.getInt("u_id");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return 0;
	}

	@Override
	public void updateUserRole(String username, int newRole) {
		CallableStatement cs = null;
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String PLQuery = "{call update_user_role_proc(?, ?)}";
			cs = conn.prepareCall(PLQuery);
			cs.setString(1, username);
			cs.setInt(2, newRole);
			cs.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(cs);
		}
	}
}

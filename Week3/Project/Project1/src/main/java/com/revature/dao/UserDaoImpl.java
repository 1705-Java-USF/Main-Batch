package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.User;
import com.revature.services.MyLogger;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void createUser(User user) {
		MyLogger.logger.trace("Creating a user");
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO ERS_USERS " + 
					"(u_username, u_password, u_firstname, u_lastname, u_email, ur_id) "
					+ "VALUES (?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRoleId());
			int affected = ps.executeUpdate();
			
			MyLogger.logger.info("Rows inserted: " + affected);
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in createUser");
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	@Override
	public User selectUserById(int id) {
		MyLogger.logger.trace("Selecting user by id");
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_USERS WHERE u_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			user = new User();
			while(rs.next()) {
				user.setId(rs.getInt("u_id"));
				user.setUsername(rs.getString("u_username"));
				user.setPassword(rs.getString("u_password"));
				user.setFirstName(rs.getString("u_firstname"));
				user.setLastName(rs.getString("u_lastname"));
				user.setEmail(rs.getString("u_email"));
				user.setRoleId(rs.getInt("ur_id"));
			}
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectUserById");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return user;
	}

	@Override
	public User selectUserByUsername(String username) {
		MyLogger.logger.trace("Selecting user by username");
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_USERS WHERE u_username = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			user = new User();
			while(rs.next()) {
				user.setId(rs.getInt("u_id"));
				user.setUsername(rs.getString("u_username"));
				user.setPassword(rs.getString("u_password"));
				user.setFirstName(rs.getString("u_firstname"));
				user.setLastName(rs.getString("u_lastname"));
				user.setEmail(rs.getString("u_email"));
				user.setRoleId(rs.getInt("ur_id"));
			}
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectUserByUsername");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return user;
	}

	@Override
	public User selectUserByEmail(String email) {
		MyLogger.logger.trace("Selecting user from email");
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_USERS WHERE u_email = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			user = new User();
			while(rs.next()) {
				user.setId(rs.getInt("u_id"));
				user.setUsername(rs.getString("u_username"));
				user.setPassword(rs.getString("u_password"));
				user.setFirstName(rs.getString("u_firstname"));
				user.setLastName(rs.getString("u_lastname"));
				user.setEmail(rs.getString("u_email"));
				user.setRoleId(rs.getInt("ur_id"));
			}
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectUserByEmail");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return user;
	}
	
	@Override
	public List<User> selectUsersByName(String firstname, String lastname) {
		MyLogger.logger.trace("Selecting users by first and last name");
		List<User> users = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_USERS WHERE u_firstname = ? AND u_lastname = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new User(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"),
						rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"),
						rs.getInt("ur_id")));
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectUsersByName");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return users;
	}

	@Override
	public List<User> selectEmployees() {
		MyLogger.logger.trace("Selecting employees (Not managers)");
		List<User> users = new ArrayList<User>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_USERS WHERE ur_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, getRoleId("Employee"));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				users.add(new User(rs.getInt("u_id"), rs.getString("u_username"), rs.getString("u_password"),
						rs.getString("u_firstname"), rs.getString("u_lastname"), rs.getString("u_email"),
						rs.getInt("ur_id")));
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectEmployees");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return users;
	}

	@Override
	public void fireUser(int id) {
		MyLogger.logger.trace("Firing user. (Setting user's role to Fired)");
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE ERS_USERS SET " + 
					"ur_id = ? "
					+ "WHERE u_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, getRoleId("Fired"));
			ps.setInt(2, id);
			int affected = ps.executeUpdate();
			
			MyLogger.logger.info("Rows updated: " + affected);
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in fireUser");
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	@Override
	public boolean updateUser(User user) {
		MyLogger.logger.trace("Updating user");
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE ERS_USERS SET " + 
					"u_username = ?, u_password = ?, u_firstname = ?, "
					+ "u_lastname = ?, u_email = ?, ur_id = ? "
					+ "WHERE u_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRoleId());
			ps.setInt(7, user.getId());
			int affected = ps.executeUpdate();
			
			MyLogger.logger.info("Rows updated: " + affected);
			return true;
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in updateUser");
			e.printStackTrace();
			return false;
		} finally {
			close(ps);
		}
		
	}

	@Override
	public String getRoleById(int roleId) {
		MyLogger.logger.trace("Getting role string by id");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String role = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE ur_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				role = rs.getString("ur_role");
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in getRoleById");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return role;
	}

	@Override
	public int getRoleId(String role) {
		MyLogger.logger.trace("Getting role id by string");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE ur_role = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, role);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("ur_id");
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in getRoleId");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return id;
	}

	@Override
	public void deleteUserById(int id) {
		MyLogger.logger.trace("Deleting user by id");
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "DELETE FROM ERS_USERS WHERE u_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in deleteUserById");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
	}
	
}

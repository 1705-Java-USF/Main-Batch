package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojos.User;
import com.revature.util.ConnectionUtil;

public class UserDAOImp implements UserDAO{

	final static Logger logger = Logger.getLogger(UserDAOImp.class);
	
	@Override
	public void createUser(User u) {
		PreparedStatement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_users (u_username, u_password, u_firstname, u_lastname, u_email, ur_id) values (?, ?, ?, ?, ?, ?)";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getFirstname());
			stmt.setString(4, u.getLastname());
			stmt.setString(5, u.getEmail());
			stmt.setInt(6, u.getUr_id());
			int affected = stmt.executeUpdate();
			
			logger.trace("Rows inserted: " + affected);
		}catch(Exception e){
			logger.warn("Exception was caught: " + e.toString());
			e.printStackTrace();
		}finally{
			close(stmt);
		}
	}

	@Override
	public User selectUserById(int id) {
		User user = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_users where u_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			}
			logger.trace("Selected User: " + id);
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return user;
	}

	@Override
	public List<User> selectUsers() {
		
		List<User> users = new ArrayList<User>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_users order by u_id";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int count = 0;
			while(rs.next()){
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
				count++;
			}
			logger.trace("Select All Users: " + count + " records");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return users;
	}

	@Override
	public void deleteUserById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "delete from ers_users where u_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int affected = stmt.executeUpdate();
			
			logger.trace("Deleted "+ affected +" Users");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
	}

	@Override
	public User selectFromLogin(String user, String pass) {
		User u = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_users where u_username=? and u_password=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
				logger.trace("User can log in");
			}
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return u;
	}

	@Override
	public void updateUser(User u) {
		PreparedStatement stmt = null;
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "update ers_users set u_username=?, u_password=?, u_firstname=?, u_lastname=?, u_email=?, ur_id=? where u_id=?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getFirstname());
			stmt.setString(4, u.getLastname());
			stmt.setString(5, u.getEmail());
			stmt.setInt(6, u.getUr_id());
			stmt.setInt(7, u.getId());
			int affected = stmt.executeUpdate();
			
			logger.trace("Rows Updated: " + affected);
		}catch(Exception e){
			logger.warn("Exception was caught: " + e.toString());
			e.printStackTrace();
		}finally{
			close(stmt);
		}
	}

	@Override
	public List<User> selectUsersExcludingId(int id) {
		List<User> users = new ArrayList<User>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_users where u_id <> ? order by u_id";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			int count = 0;
			while(rs.next()){
				users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
				count++;
			}
			logger.trace("Select All Users: " + count + " records");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return users;
	}

}

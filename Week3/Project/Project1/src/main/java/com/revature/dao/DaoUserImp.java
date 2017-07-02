package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.Users;
import com.revature.util.ConnectionUtil;

public class DaoUserImp implements DaoUser {

	@Override
	public void createUser(Users r) {
		PreparedStatement ps = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			int a = r.getId();
			String b = r.getUsername();
			String c = r.getPassword();
			String d = r.getFname();
			String e = r.getLname();
			String f = r.getEmail();
			int g = r.getUr_id();
			
			String sql = "INSERT INTO USERS VALUES (?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			ps.setString(5, e);
			ps.setString(6, f);
			ps.setInt(7, g);
			
			int affected = ps.executeUpdate();
			
			System.out.println("Rows inserted: " + affected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
		}
	}
	
	@Override
	public Users selectUserByUsername(String username) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users usern = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM USERS WHERE U_USERNAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			usern = new Users(0, sql, sql, sql, sql, sql, 0);
			
			while(rs.next()) {
				usern.setId(rs.getInt(1));
				usern.setUsername(rs.getString("U_USERNAME"));				
				usern.setPassword(rs.getString("U_PASSWORD"));
				usern.setFname(rs.getString("U_FNAME"));
				usern.setLname(rs.getString("U_LNAME"));
				usern.setEmail(rs.getString("U_EMAIL"));
				usern.setUr_id(rs.getInt(7));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return usern;
	}
	
	@Override
	public void deleteUserByUsername(String username) {
		
		PreparedStatement ps = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "DELETE FROM USERS WHERE U_USERNAME = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			int altered = ps.executeUpdate();
			
			System.out.println("Rows Deleted: " + altered);
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
		}
		
		return;
		
	}
	
	@Override
	public String getRole(int id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String role = null;
		
		
		try {
			
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM USER_ROLES WHERE UR_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				role = rs.getString("UR_ROLE");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return role;
	}
	
	@Override
	public boolean updateUser(Users u) {
		PreparedStatement ps = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			int id = u.getId();
			int roleid = u.getUr_id();
			String usern = u.getUsername();
			String pass = u.getPassword();
			String fname = u.getFname();
			String lname = u.getLname();
			String email = u.getEmail();
		
			String sql = "UPDATE USERS SET "+
					"U_USERNAME = ?, "+
					"U_PASSWORD = ?, "+
					"U_FNAME = ?, "+
					"U_LNAME = ?, "+
					"U_EMAIL = ?, "+
					"UR_ID = ?" + " WHERE U_ID = ?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, usern);
			ps.setString(2, pass);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);
			ps.setInt(6, roleid);
			ps.setInt(7, id);
			int affected = ps.executeUpdate();
			
			System.out.println("Rows changed: " + affected);
			return true;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		finally {
			close(ps);
		}
	}
	
	@Override
	public List<Users> getUsersExcludingId(int id) {
		PreparedStatement ps = null;
		List<Users> users = new ArrayList<Users>();
		ResultSet rs = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM USERS WHERE U_ID <> ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				users.add(new Users(rs.getInt("U_ID"), rs.getString("U_USERNAME"), 
						rs.getString("U_PASSWORD"), rs.getString("U_FNAME"), 
						rs.getString("U_LNAME"), rs.getString("U_EMAIL"), rs.getInt("UR_ID")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return users;
	}

	@Override
	public Users getUserById(int id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users u = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM USERS WHERE U_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				u = new Users(rs.getInt("U_ID"), rs.getString("U_USERNAME"), 
						rs.getString("U_PASSWORD"), rs.getString("U_FNAME"), 
						rs.getString("U_LNAME"), rs.getString("U_EMAIL"), rs.getInt("UR_ID"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return u;
	}
}

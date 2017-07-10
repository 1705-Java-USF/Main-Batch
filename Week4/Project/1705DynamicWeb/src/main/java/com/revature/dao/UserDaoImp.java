package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Users;
import com.revature.util.ConnectionUtil;

public class UserDaoImp implements UserDao{

	@Override
	public boolean createUser(Users us){
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String u = us.getU_USERNAME();
			String p = us.getU_PASSWORD();
			String e = us.getU_EMAIL();
			String fn = us.getU_FIRSTNAME();
			String ln = us.getU_LASTNAME();
			
			String sql = "INSERT INTO Users Values( NULL,'" + u + "','" + p + "','" + fn + "','" + ln + "','" + e + "', 2)";
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);

			System.out.println("Rows inserted: " + affected);
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
			return false;
		} finally {
			close(stmt);
		}
		
	
}

	@Override
	public Users selectUsersByUsername(String Username) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Users fc = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Users WHERE U_Username = ?";

			ps = conn.prepareStatement(sql);
			ps.setString(1, Username);
			rs = ps.executeQuery();

			while(rs.next()){
				System.out.println("hi");
				fc = new Users(0, sql, sql, sql, sql, sql, 0);
				fc.setU_ID(rs.getInt(1));
				fc.setU_USERNAME(rs.getString("U_USERNAME"));
				fc.setU_PASSWORD(rs.getString("U_PASSWORD"));
				fc.setU_FIRSTNAME(rs.getString("U_FIRSTNAME"));
				fc.setU_LASTNAME(rs.getString("U_LASTNAME"));
				fc.setU_EMAIL(rs.getString("U_EMAIL"));
				fc.setUR_ID(rs.getInt(7));
			}
		} catch (Exception e) {
			System.out.println("Didn't Connect");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}

		return fc;
	}
	
	@Override
    public boolean deleteUserByUsername(String Username) {
        
        PreparedStatement ps = null;
        
        try(Connection conn = ConnectionUtil.getConnection()) {
            
            String sql = "DELETE FROM Users WHERE U_Username = ?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, Username);
            int altered = ps.executeUpdate();
            
            System.out.println("Rows Updated: " + altered);
            
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        finally {
            close(ps);
        }
        
    }

	//Still need to work on update
	@Override
	public boolean updateUserUsername(String oldU, String newU) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "Update Users SET " 
					   + "U_USERNAME= '"+ newU +"'"
					   + "WHERE U_USERNAME= '" +oldU+ "'";
			
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);

			System.out.println("Rows Updated: " + affected);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}
		
	}

	@Override
	public void updateUserPass(String us, String password) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "Update Users SET " 
					   + "U_PASSWORD= '"+ password +"'"
					   + "WHERE U_USERNAME= '" +us+ "'";
			
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);

			System.out.println("Rows Updated: " + affected);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
	}

	@Override
	public void updateUserFname(String us, String fname) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "Update Users SET " 
					   + "U_FIRSTNAME= '"+ fname +"'"
					   + "WHERE U_USERNAME= '" +us+ "'";
			
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);

			System.out.println("Rows Updated: " + affected);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
	}

	@Override
	public void updateUserLname(String us, String lname) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "Update Users SET " 
					   + "U_LASTNAME= '"+ lname +"'"
					   + "WHERE U_USERNAME= '" +us+ "'";
			
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);

			System.out.println("Rows Updated: " + affected);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
	}

	@Override
	public void updateUserEmail(String us, String email) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			
			
			String sql = "Update Users SET " 
					   + "U_EMAIL= '"+ email +"'"
					   + "WHERE U_USERNAME= '" +us+ "'";
			
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);

			System.out.println("Rows Updated: " + affected);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
	}

	@Override
	public List<Users> selectUsers() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users us = null;
		
		List<Users> usl = new ArrayList<Users>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Users Where UR_ID = 2";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()){
				us = new Users();
				us.setU_ID(rs.getInt(1));
				us.setU_USERNAME(rs.getString(2));
			    us.setU_FIRSTNAME(rs.getString(4));
			    us.setU_LASTNAME(rs.getString(5));
			    us.setU_EMAIL(rs.getString(6));
				usl.add(us);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		
		return usl;

	}

	@Override
	public Users selectUserById(int uid) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users fc = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Users WHERE U_ID = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();

			while(rs.next()){
				fc = new Users(0, sql, sql, sql, sql, sql, 0);
				fc.setU_ID(rs.getInt(1));
				fc.setU_USERNAME(rs.getString("U_USERNAME"));
				fc.setU_PASSWORD(rs.getString("U_PASSWORD"));
				fc.setU_FIRSTNAME(rs.getString("U_FIRSTNAME"));
				fc.setU_LASTNAME(rs.getString("U_LASTNAME"));
				fc.setU_EMAIL(rs.getString("U_EMAIL"));
				fc.setUR_ID(rs.getInt(7));
			}
		} catch (Exception e) {
			System.out.println("Didn't Connect");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}

		return fc;
	}
	
}

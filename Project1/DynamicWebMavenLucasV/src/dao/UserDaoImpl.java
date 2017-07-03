package dao;

import static util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import pojo.ErsUser;
import util.CloseStreams;
import util.ConnectionUtil;

public class UserDaoImpl implements UserDao{

	@Override
	public void createUserFull(ErsUser eu) {
		Statement st = null;

		try(Connection conn = ConnectionUtil.getConnection()){
			int U_ID = eu.getU_ID();
			String U_USERNAME = eu.getU_USERNAME();
			String U_PASSWORD = eu.getU_PASSWORD();
			String U_FIRSTNAME = eu.getU_FIRSTNAME();
			String U_LASTNAME = eu.getU_LASTNAME();
			String U_EMAIL = eu.getU_EMAIL();
			int UR_ID = eu.getUR_ID();
			
			String sql = "INSERT INTO ERS_USERS(U_ID, U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)"
			+ " VALUES ('"+U_ID+"','"+U_USERNAME+"','"+U_PASSWORD+"','"+U_FIRSTNAME+"','"+U_LASTNAME+"','"+U_EMAIL+"','"+UR_ID+"')";

			st = conn.createStatement();
			int affected = st.executeUpdate(sql);
			
			System.out.println("Rows inserted: " + affected);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			CloseStreams.close(st);
		}
	}

	@Override
	public ErsUser selectUserByID(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ErsUser eu = null;

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ERS_USERS where U_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			eu = new ErsUser();
			while(rs.next()){
				eu.setU_ID(rs.getInt(1));
				eu.setU_USERNAME(rs.getString(2)); 
				eu.setU_PASSWORD(rs.getString(3));
				eu.setU_FIRSTNAME(rs.getString(4));				
				eu.setU_LASTNAME(rs.getString(5));
				eu.setU_EMAIL(rs.getString(6));
				eu.setUR_ID(rs.getInt(7));
			}

			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
			close(rs);
		}
		return eu;
	}

	@Override
	public List<ErsUser> selectErsUsers() {
		 PreparedStatement ps = null;
	        ResultSet rs = null;
	        LinkedList<ErsUser> list = new LinkedList<>();

	        try(Connection con = ConnectionUtil.getConnection())

	        {
	            String sql = "SELECT * FROM ERS_USERS";
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	    
	            while(rs.next())
	            {
	                list.add(new ErsUser(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
	            }

	        }catch (SQLException e){
	        	e.printStackTrace();
	        }finally{
	            close(ps);
	            close(rs);
	        }
	        return list;
	}

	@Override
	public void deleteUsersById(int id) {
		PreparedStatement ps = null;

        try(Connection con = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM ERS_USERS WHERE U_ID = ?";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int altered  = ps.executeUpdate();
            System.out.println("The Number of Rows Affected: " + altered);
            
            System.out.println("U_ID of Row Deleted: " + id);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            close(ps);
        }
	}

	@Override
	public void createUserMinReq(ErsUser eu) {
		
	}

//	@Override
	public String returnUserNameById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String username = null;

        try(Connection con = ConnectionUtil.getConnection()){
            String sql = "SELECT U_USERNAME FROM ERS_USERS WHERE U_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
            
			while(rs.next()){
			username = rs.getString(1);
			}
            int altered  = ps.executeUpdate();
            System.out.println("The Number of Rows Affected: " + altered);
            
            System.out.println("U_ID of Username Obtained: " + id);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }		
		
		return username;
	}

	@Override
	public ErsUser selectUserByUserName(String username) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		ErsUser eu = null;

		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM ERS_USERS where U_USERNAME = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			
			eu = new ErsUser();
			while(rs.next()){
				eu.setU_ID(rs.getInt(1));
				eu.setU_USERNAME(rs.getString(2)); 
				eu.setU_PASSWORD(rs.getString(3));
				eu.setU_FIRSTNAME(rs.getString(4));				
				eu.setU_LASTNAME(rs.getString(5));
				eu.setU_EMAIL(rs.getString(6));
				eu.setUR_ID(rs.getInt(7));
			}

			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
			close(rs);
		}
		return eu;
	}

	@Override
	public String returnRoleByRoleId(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		String role = null;

        try(Connection con = ConnectionUtil.getConnection()){
            String sql = "SELECT UR_ROLE FROM ERS_USER_ROLES WHERE UR_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
            
			while(rs.next()){
			role = rs.getString(1);
			}
            int altered  = ps.executeUpdate();
            System.out.println("The Number of Rows Affected: " + altered);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }		
		
		return role;
	}

	@Override
	public int returnIdByUsername(String username) {
		PreparedStatement ps = null;
		ResultSet rs = null;
    	int u = 1;		

        try(Connection con = ConnectionUtil.getConnection()){
            String sql = "SELECT U_ID FROM ERS_USERS WHERE U_USERNAME = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
            
			while(rs.next()){
			u = rs.getInt(1);
			}
            int altered  = ps.executeUpdate();
            System.out.println("The Number of Rows Affected: " + altered);
            
            System.out.println("Username of ID Obtained: " + username);
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }		
		
		return u;
	}

}
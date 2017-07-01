package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojos.User;
import com.revature.pojos.UserRole;
import com.revature.util.ConnectionUtil;

public class UserRoleDAOImp implements UserRoleDAO {

	final static Logger logger = Logger.getLogger(UserRoleDAOImp.class);

	@Override
	public void createUserRole(UserRole u) {
		PreparedStatement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_user_roles (ur_role) values ('"+u.getRole()+"')";
			
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);
			
			logger.trace("Rows inserted: " + affected);
		}catch(Exception e){
			logger.warn("Exception was caught: " + e.toString());
			e.printStackTrace();
		}finally{
			close(stmt);
		}
	}

	@Override
	public UserRole selectUserRoleById(int id) {
		UserRole ur = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_user_roles where ur_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				ur = new UserRole(rs.getInt(1), rs.getString(2));
			}
			logger.trace("Selected User: " + id);
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return ur;
	}

	@Override
	public List<UserRole> selectUserRoles() {
		
		List<UserRole> roles = new ArrayList<UserRole>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_user_roles order by ur_id";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int count = 0;
			while(rs.next()){
				roles.add(new UserRole(rs.getInt(1), rs.getString(2)));
				count++;
			}
			logger.trace("Select All User Roles: " + count + " records");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return roles;
	}

	@Override
	public void deleteUserRoleById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserRoleSP(UserRole u) {
		// TODO Auto-generated method stub
		
	}

}

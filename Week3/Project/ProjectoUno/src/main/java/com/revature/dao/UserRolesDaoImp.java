package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.pojo.ErsUser;
import com.revature.pojo.UserRoles;
import com.revature.util.ConnectionUtil;

public class UserRolesDaoImp implements UserRolesDao
{

	@Override
	public void createUserRole(ErsUser eu) 
	{
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			Integer urId = eu.getuId();
			String role = "Manager";
			
			String sql = "INSERT INTO ers_user_roles VALUES (?, ?)";
		
			ps = con.prepareStatement(sql);	
			
			ps.setInt(1, urId);
			ps.setString(2, role);
			
			int altered = ps.executeUpdate();
			
			System.out.println("Records updated: " + altered);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(ps);
		}
	}

	@Override
	public UserRoles selectUserRoleById(int id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserRoles ur = null;
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_user_roles WHERE ur_id = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				ur = new UserRoles();
				ur.setUr_id(rs.getInt("ur_id"));
				ur.setUr_role(rs.getString("ur_role"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(ps);
			close(rs);
		}
		
		return ur;
	}

}

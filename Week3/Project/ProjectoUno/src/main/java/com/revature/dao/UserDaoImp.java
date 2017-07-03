package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.revature.pojo.ErsUser;
import com.revature.util.ConnectionUtil;

public class UserDaoImp implements UserDao
{

	//Creates User in ers_users will all parameters
	@Override
	public void createUser(ErsUser eu) 
	{
		PreparedStatement ps = null;
		
		try(Connection con = ConnectionUtil.getConnection())
		{	 
			Integer uId = eu.getuId();
			String usrName = eu.getUserName();
			String passWrd = eu.getPassWord();
			String fName = null;
			String lName = null;
			String email = null;
			Integer urId = eu.getUrId();
					
			String sql = "INSERT INTO ers_users VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			ps = con.prepareStatement(sql);		
		
			ps.setInt(1, uId);
			ps.setString(2, usrName);
			ps.setString(3, passWrd);
			ps.setString(4, fName);
			ps.setString(5, lName);
			ps.setString(6, email);
			ps.setInt(7, urId);
			
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

	//Creates User in ers_users by calling procedure
	@Override
	public void createUserSP(ErsUser eu) 
	{
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnection())
		{	
			String usrName = eu.getUserName();
			String passWrd = eu.getPassWord();
			Integer urId = eu.getUrId();
			
			String sql = "{call insert_ers_users_procedure(?,?,?)}";
			
			cs = con.prepareCall(sql);
			
			cs.setString(1, usrName);
			cs.setString(2, passWrd);
			cs.setInt(3, urId);
			
			cs.executeQuery();
			System.out.println("Sucess!");
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			close(cs);	
		}
		return;
	}

	@Override
	public ErsUser selectUserById(int id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		ErsUser eu = null;
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_users WHERE u_id = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			eu = new ErsUser();
			
			while(rs.next())
			{
				eu.setuId(rs.getInt("u_id"));
				eu.setUserName(rs.getString("u_username"));
				eu.setPassWord(rs.getString("u_password"));
				eu.setFirstName(rs.getString("u_firstname"));
				eu.setLastName(rs.getString("u_lastname"));
				eu.setEmail(rs.getString("u_email"));
				eu.setUrId(rs.getInt("uR_id"));
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
		return eu;
	}

	@Override
	public void updateUser(ErsUser eu) 
	{
		PreparedStatement ps = null;
		Statement st = null;
		try(Connection con = ConnectionUtil.getConnection())
		{
			String userName = eu.getUserName();
			String passWrd = eu.getPassWord();
			String fName = eu.getFirstName();
			String lName = eu.getLastName();
			String email = eu.getEmail();
			
			String sql = "UPDATE ers_users "
					   + "SET u_password = ?, u_firstname = ?, u_lastname = ?, u_email = ? "
					   + "WHERE u_username = ?";
			
			ps = con.prepareStatement(sql);	
			
			ps.setString(1, passWrd);
			ps.setString(2, fName);
			ps.setString(3, lName);
			ps.setString(4, email);
			ps.setString(5, userName);
			
			int altered = ps.executeUpdate();
			
			System.out.println("Records updated: " + altered);
			
			st = con.createStatement();
			st.executeQuery("COMMIT");

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			close(ps);
			close(st);
		}
	}

	@Override
	public ErsUser selectUserByUserName(String userName) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		ErsUser eu = null;
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_users WHERE u_username = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userName);
			
			rs = ps.executeQuery();
			
			eu = new ErsUser();
			
			while(rs.next())
			{
				eu.setuId(rs.getInt("u_id"));
				eu.setUserName(rs.getString("u_username"));
				eu.setPassWord(rs.getString("u_password"));
				eu.setFirstName(rs.getString("u_firstname"));
				eu.setLastName(rs.getString("u_lastname"));
				eu.setEmail(rs.getString("u_email"));
				eu.setUrId(rs.getInt("uR_id"));
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
		return eu;
	}

	@Override
	public List<ErsUser> selectAllUsers() 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<ErsUser> users = new LinkedList<>();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_users WHERE uR_id = 1 ORDER BY u_id ASC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				users.add(new ErsUser(rs.getInt("u_id"), rs.getString("u_username"),rs.getString("u_password"),rs.getString("u_firstname"),
						rs.getString("u_lastname"), rs.getString("u_email"), rs.getInt("uR_id")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			close(ps);
			close(rs);
		}
		
		return users;
	}

	public ErsUser selectUserByUserNameAndPass(String userName, String userPass) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		ErsUser eu = null;
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_users WHERE u_username = ? AND u_password = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userName);
			ps.setString(2, userPass);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				eu = new ErsUser();
				eu.setuId(rs.getInt("u_id"));
				eu.setUserName(rs.getString("u_username"));
				eu.setPassWord(rs.getString("u_password"));
				eu.setFirstName(rs.getString("u_firstname"));
				eu.setLastName(rs.getString("u_lastname"));
				eu.setEmail(rs.getString("u_email"));
				eu.setUrId(rs.getInt("uR_id"));
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
		return eu;
	}

	@Override
	public void promoteUser(Integer id) 
	{
		PreparedStatement ps = null;
		try(Connection con = ConnectionUtil.getConnection())
		{	
			String sql = "UPDATE ers_users "
					   + "SET uR_id = 2"
					   + "WHERE u_Id = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
}

package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.revature.pojo.ErsUser;
import com.revature.pojo.ReinBurst;
import com.revature.util.ConnectionUtil;

public class ReinBurstDaoImp implements ReinBurstDao
{
	@Override
	public void createReinBurstSP(ErsUser eu, Double ammount, String desc, String receipt,Integer type) 
	{
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			Integer u_Id = eu.getuId();
			Integer uR_Id = eu.getUrId();
			
			System.out.println("in dao : " + receipt);
			
			String sql = "{call insert_ers_reinburse_procedure(?,?,?, null,?,?,?,1)}";
			
			cs = con.prepareCall(sql);
					
			cs.setDouble(1, ammount);
			cs.setString(2, desc);
			cs.setString(3, receipt);
			cs.setInt(4, u_Id);
			cs.setInt(5, uR_Id);
			cs.setInt(6, type);
			
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
	public List<ReinBurst> selectAllReinBurst(int res) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<ReinBurst> list = new LinkedList<>();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_reinburse WHERE rs_status = ? ORDER BY r_id ASC";
			ps = con.prepareStatement(sql);
			ps.setInt(1, res);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(new ReinBurst(rs.getInt("r_id"), rs.getInt("r_ammount"), rs.getString("r_description"),  rs.getString("r_receipt"),
						rs.getString("r_submitted"), rs.getString("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), 
						rs.getInt("rt_type"), rs.getInt("rs_status")));
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
		
		return list;
	}

	@Override
	public List<ReinBurst> selectAllReinBurstByID(int id) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<ReinBurst> list = new LinkedList<>();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_reinburse WHERE u_id_author = ? ORDER BY r_id ASC";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(new ReinBurst(rs.getInt("r_id"), rs.getInt("r_ammount"), rs.getString("r_description"),  rs.getString("r_receipt"),
						rs.getString("r_submitted"), rs.getString("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), 
						rs.getInt("rt_type"), rs.getInt("rs_status")));
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
		
		return list;
	}
	@Override
	public List<ReinBurst> selectReinBurstByAuthorPending(ErsUser eu) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<ReinBurst> list = new LinkedList<>();
		
		Integer author = eu.getuId();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_reinburse WHERE u_id_author = ? AND rs_status = 1 ORDER BY r_id ASC";
			ps = con.prepareStatement(sql);
			ps.setInt(1, author);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(new ReinBurst(rs.getInt("r_id"), rs.getInt("r_ammount"), rs.getString("r_description"),  rs.getString("r_receipt"),
						rs.getString("r_submitted"), rs.getString("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), 
						rs.getInt("rt_type"), rs.getInt("rs_status")));
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
		
		return list;
	}

	@Override
	public List<ReinBurst> selectReinBurstByAuthorResolved(ErsUser eu) 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<ReinBurst> list = new LinkedList<>();
		
		Integer author = eu.getuId();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_reinburse WHERE u_id_author = ? AND rs_status = 2 ORDER BY r_id ASC";
			ps = con.prepareStatement(sql);
			ps.setInt(1, author);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(new ReinBurst(rs.getInt("r_id"), rs.getInt("r_ammount"), rs.getString("r_description"), rs.getString("r_receipt"),
						rs.getString("r_submitted"), rs.getString("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"), 
						rs.getInt("rt_type"), rs.getInt("rs_status")));
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
		
		return list;
	}

	public void updateReinBurst(Integer reinId, Integer resolver)
	{
		CallableStatement cs = null;
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "{call update_ers_reinburse_procedure(?, ?)}";
			
			cs = con.prepareCall(sql);
			
			cs.setInt(1, reinId);
			cs.setInt(2, resolver);
			
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
}

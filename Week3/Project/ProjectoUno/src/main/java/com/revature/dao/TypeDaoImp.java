package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.revature.pojo.RtType;
import com.revature.util.ConnectionUtil;

public class TypeDaoImp implements TypeDao
{
	@Override
	public List<RtType> selectAllType() 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
		LinkedList<RtType> list = new LinkedList<>();
		
		try(Connection con = ConnectionUtil.getConnection())
		{
			String sql = "SELECT * FROM ers_reinburse_type";
		
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				list.add(new RtType(rs.getInt("rt_id"),rs.getString("rt_type")));
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

}

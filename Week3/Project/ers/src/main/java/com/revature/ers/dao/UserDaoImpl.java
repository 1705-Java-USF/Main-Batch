package com.revature.ers.dao;

import static com.revature.util.StreamCloser.closeStream;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.User;
import com.revature.util.ColumnNameUtil;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements Dao<User> {
	private Logger logger = Logger.getLogger(UserDaoImpl.class);
	private ConnectionUtil connUtil;
	
	public UserDaoImpl()
	{
		connUtil = ConnectionUtil.getConnectionUtil();
	}

	@Override
	public int create(User t) {
		CallableStatement stmnt = null;
		try {
			Connection conn = connUtil.getConnection();
			String sql = "{call create_user(?,?,?,?,?,?)}"; // create_user(uname
															// IN VARCHAR2,
															// pword IN
															// VARCHAR2, fname
															// IN VARCHAR2,
															// lname IN
															// VARCHAR2, email
															// IN VARCHAR2, role
															// IN VARCHAR2)
			stmnt = conn.prepareCall(sql);
			stmnt.setString(1, t.getUsername());
			stmnt.setString(2, t.getPassword());
			stmnt.setString(3, t.getFirstname());
			stmnt.setString(4, t.getLastname());
			stmnt.setString(5, t.getEmail());
			stmnt.setString(6, t.getUserRole());
			logger.debug("call created");
			stmnt.executeQuery();
			logger.debug("call executed");
			return 1;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}  finally {
			if (stmnt != null) {
				closeStream(stmnt);
			}
		}
		return 0;

	}

	@Override
	public User selectById(int id) {
		PreparedStatement stmnt = null;
		try  {
			Connection conn = connUtil.getConnection();
			String sql = "SELECT * FROM ERS_USERS WHERE U_UID = ?";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, id);
			logger.debug("prepared statement created");
			ResultSet rs = stmnt.executeQuery();
			logger.debug("query executed");
			while (rs.next()) {
				User u = fillUser(rs, conn);
				return u;
			}

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}  finally {
			if (stmnt != null) {
				closeStream(stmnt);
			}
		}

		return null;
	}

	@Override
	public List<User> selectAll() {
		PreparedStatement stmnt = null;
		try  {
			Connection conn = connUtil.getConnection();
			String sql = "SELECT * FROM ERS_USERS";
			stmnt = conn.prepareStatement(sql);
			logger.debug("prepared statement created");
			ResultSet rs = stmnt.executeQuery();
			logger.debug("query executed");
			List<User> users = new LinkedList<User>();
			while (rs.next()) {
				User u = fillUser(rs, conn);
				users.add(u);

			}
			return users;

		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} 
		return null;
	}

	@Override
	public int deleteById(int id) {
		PreparedStatement stmnt = null;
		int rows = 0;
		try
		{
			Connection conn = connUtil.getConnection();
			String sql = "DELETE FROM ERS_USERS WHERE U_UID = ?";
			stmnt = conn.prepareStatement(sql);
			stmnt.setInt(1, id);
			rows = stmnt.executeUpdate();
			return rows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return 0;
	}

	private String getRole(int id, Connection conn) throws SQLException {
		PreparedStatement stmnt = null;
		String sql = "SELECT UR_ROLE FROM ERS_USER_ROLES WHERE UR_ID = ?";
		String result = null;
		stmnt = conn.prepareStatement(sql);
		stmnt.setInt(1, id);
		logger.debug("prepared statement created");
		ResultSet rs = stmnt.executeQuery();
		logger.debug("query executed");
		while (rs.next()) {
			logger.trace("Reading Row: " + rs.getRow());
			result = rs.getString(1);

		}
		closeStream(stmnt);
		return result;
	}

	@Override
	public List<User> selectBy(Map<String, String> columnValueMap) {
		Set<String> columnNames = columnValueMap.keySet();
		PreparedStatement stmnt = null;
		ResultSet set = null;
		PreparedStatement auxStmnt = null;
		try
		{
			Connection conn = connUtil.getConnection();
			String sql = "SELECT * FROM ERS_USERS WHERE";
			boolean first = true;
			for(String cName: columnNames)
			{
				if(first)
				{
					sql += " " + cName + " = ?";
					first = false;
					continue;
				}
				sql += " AND " + cName + " = ?";
			}
			logger.debug(sql);
			
			stmnt = conn.prepareStatement(sql);
			int p = 1;
			for(String cName: columnNames)
			{
				String auxSql;
				int id = 0;
				if(cName.equals(ColumnNameUtil.ROLE))
				{
					auxSql = "SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, columnValueMap.get(cName));
					set = auxStmnt.executeQuery();
					while(set.next())
					{
						id = set.getInt("UR_ID");
					}
					stmnt.setInt(p++, id);
					closeStream(set);
				}else
				{
					stmnt.setString(p++, columnValueMap.get(cName));
				}
				logger.debug(columnValueMap.get(cName));
				
			}
			set = stmnt.executeQuery();
			List<User> users = new LinkedList<User>();
			User u;
			while(set.next()){
				u = fillUser(set, conn);
				users.add(u);
			}
			return users;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
		}finally
		{
			closeStream(stmnt);
			closeStream(set);
			closeStream(auxStmnt);
		}
		return null;
	}
	private User fillUser(ResultSet rs, Connection conn) throws SQLException
	{
		User u = new User();
		int roleId = -1;
		logger.trace("Reading Row: " + rs.getRow());
		u.setUserId(rs.getInt("U_UID"));
		u.setUsername(rs.getString("U_USERNAME"));
		u.setPassword(rs.getString("U_PASSWORD"));
		u.setFirstname(rs.getString("U_FIRSTNAME"));
		u.setLastname(rs.getString("U_LASTNAME"));
		u.setEmail(rs.getString("U_EMAIL"));
		roleId = rs.getInt("UR_ID");
		u.setUserRole(getRole(roleId, conn));;
		return u;
	}

	@Override
	public int updateBy(Map<String, String> columnValueMap, Map<String, String> conditions) {
		Set<String> conditionNames = conditions.keySet();
		Set<String> columnNames = columnValueMap.keySet();
		PreparedStatement stmnt = null;
		ResultSet set = null;
		PreparedStatement auxStmnt = null;
		int rows = 0;
		try{
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "UPDATE ERS_USERS SET ";
			boolean first = true;
			for(String name: columnNames)
			{
				if(first)
				{
					sql += name + " = ? ";
					first = false;
					continue;
				}
				sql += ", " + name + " = ? ";
			}
			first = true;
			sql += " WHERE ";
			for(String name: conditionNames)
			{
				if(first)
				{
					sql += name + " = ? ";
					first = false;
					continue;
				}
				sql += " AND " + name + " = ? ";
			}
			stmnt = conn.prepareStatement(sql);
			int i = 1;
			for(String name: columnNames)
			{
				String auxSql;
				int id = 0;
				if(name.equals(ColumnNameUtil.ROLE))
				{
					auxSql = "SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, columnValueMap.get(name));
					set = auxStmnt.executeQuery();
					while(set.next())
					{
						id = set.getInt("UR_ID");
					}
					stmnt.setInt(i++, id);
					closeStream(set);
				}else
				{
					stmnt.setString(i++, columnValueMap.get(name));
				}
				logger.debug(columnValueMap.get(name));
			}
			for(String name : conditionNames)
			{
				String auxSql;
				int id = 0;
				if(name.equals(ColumnNameUtil.ROLE))
				{
					auxSql = "SELECT UR_ID FROM ERS_USER_ROLES WHERE UR_ROLE = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, conditions.get(name));
					set = auxStmnt.executeQuery();
					while(set.next())
					{
						id = set.getInt("UR_ID");
					}
					stmnt.setInt(i++, id);
					closeStream(set);
				}else
				{
					stmnt.setString(i++, conditions.get(name));
				}
				logger.debug(conditions.get(name));
			}
			rows = stmnt.executeUpdate();
			return rows;
		}catch(SQLException e)
		{
			logger.error(e.getMessage(), e);
		}finally
		{
			closeStream(stmnt);
			closeStream(set);
			closeStream(auxStmnt);
		}
		return 0;
		
	}

}

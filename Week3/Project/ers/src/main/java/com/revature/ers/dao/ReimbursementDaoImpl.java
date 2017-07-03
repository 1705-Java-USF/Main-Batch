package com.revature.ers.dao;

import static com.revature.util.StreamCloser.closeStream;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.revature.ers.DataObjects.Reimbursement;
import com.revature.util.ColumnNameUtil;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements Dao<Reimbursement> {
	private Logger logger = Logger.getLogger(ReimbursementDaoImpl.class);
	private ConnectionUtil connUtil;

	public ReimbursementDaoImpl() {
		connUtil = ConnectionUtil.getConnectionUtil();
	}

	@Override
	public int create(Reimbursement t) {
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			Connection conn = connUtil.getConnection();
			String sql = "call create_reimbursement(?,?,?,?,?,?,?)";// create_reimbursement(amount
																	// IN
																	// NUMBER,
																	// description
																	// IN
																	// VARCHAR2,
																	// receipt
																	// IN BLOB,
																	// submitted
																	// IN
																	// TIMESTAMP,
																	// resolved
																	// IN
																	// TIMESTAMP,
																	// author IN
																	// NUMBER,
																	// resolver
																	// IN
																	// NUMBER,
																	// type IN
																	// VARCHAR2,
																	// status IN
																	// VARCHAR2)
			cs = conn.prepareCall(sql);
			cs.setDouble(1, t.getAmount());
			cs.setString(2, t.getDescription());
			cs.setBlob(3, t.getReceipt());
			t.getSubmittedTime();
			Timestamp submittedTime = Timestamp.valueOf(t.getSubmittedTime());
			cs.setTimestamp(4, submittedTime);
			cs.setInt(5, t.getAuthor().getUserId());
			cs.setString(6, t.getReimbursementType());
			cs.setString(7, t.getReimbursementStatus());
			logger.debug("call created");
			rs = cs.executeQuery();
			logger.debug(rs.getMetaData().getColumnCount());
			logger.debug("call executed");
			return 1;
		} catch (SQLException e) {

			logger.error(e.getMessage(), e);
		} finally {
			if (cs != null) {
				closeStream(cs);
			}
		}
		return 0;

	}

	@Override
	public Reimbursement selectById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = connUtil.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE R_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			logger.debug("Prepared Statement Created");
			rs = ps.executeQuery();
			UserDaoImpl ud = new UserDaoImpl();
			while (rs.next()) {
				return fillReimbursement(rs, conn, ud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
		} finally {
			if (ps != null) {
				closeStream(ps);
			}
			if (rs != null) {
				closeStream(rs);
			}
		}
		return null;
	}

	@Override
	public List<Reimbursement> selectAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Connection conn = connUtil.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
			ps = conn.prepareStatement(sql);
			logger.debug("Prepared Statement created");
			rs = ps.executeQuery();
			logger.debug("Prepared Statement executed");
			List<Reimbursement> res = new ArrayList<Reimbursement>();
			UserDaoImpl ud = new UserDaoImpl();
			while (rs.next()) {
				res.add(fillReimbursement(rs, conn, ud));
			}
			return res;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (ps != null) {
				closeStream(ps);
			}
			if (rs != null) {
				closeStream(rs);
			}
		}

		return null;
	}

	@Override
	public int deleteById(int id) {
		PreparedStatement ps = null;
		int rows = 0;
		try {
			Connection conn = connUtil.getConnection();
			String sql = "DELETE FROM ERS_REIMBURSEMENTS WHERE R_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			logger.debug("Prepared Statement Created");
			rows = ps.executeUpdate();
			logger.debug("Prepared Statement Created");
			return rows;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (ps != null) {
				closeStream(ps);
			}
		}
		return 0;

	}

	private String getType(int id, Connection conn) throws SQLException {
		String sql = "SELECT RT_TYPE FROM ERS_REIMBURSEMENT_TYPE WHERE RT_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		logger.debug("Prepared Statement Created");
		ResultSet rs = ps.executeQuery();
		logger.debug("prepared Statement Executed");
		rs.next();
		String rString = rs.getString("RT_TYPE");
		closeStream(rs);
		closeStream(ps);
		logger.debug("Reimbursement Type Found");
		return rString;
	}

	private String getStatus(int id, Connection conn) throws SQLException {
		String sql = "SELECT RS_STATUS FROM ERS_REIMBURSEMENT_STATUS WHERE RS_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		logger.debug("Prepared Statement Created");
		ResultSet rs = ps.executeQuery();
		logger.debug("Prepared Statement Executed");
		rs.next();
		String rString = rs.getString("RS_STATUS");
		closeStream(rs);
		closeStream(ps);
		logger.debug("Reimbursement Status Found");

		return rString;
	}

	@Override
	public List<Reimbursement> selectBy(Map<String, String> columnValueMap) {
		Set<String> columnNames = columnValueMap.keySet();
		PreparedStatement stmnt = null;
		ResultSet set = null;
		PreparedStatement auxStmnt = null;
		try {
			Connection conn = connUtil.getConnection();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE";
			boolean first = true;
			for (String cName : columnNames) {
				if (first) {
					sql += " " + cName + " = ?";
					first = false;
					continue;
				}
				sql += " AND " + cName + " = ?";
			}
			logger.debug(sql);
			stmnt = conn.prepareStatement(sql);
			int p = 1;
			for (String cName : columnNames) {

				String auxSql;
				int id;
				if (cName.equals(ColumnNameUtil.STATUS)) {
					auxSql = "SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, columnValueMap.get(cName));
					set = auxStmnt.executeQuery();
					id = 0;
					while (set.next()) {
						id = set.getInt("RS_ID");
					}
					stmnt.setInt(p++, id);
					closeStream(set);
				} else if (cName.equals(ColumnNameUtil.TYPE)) {
					auxSql = "SELECT RT_ID FROM ERS_REIMBURSEMENT_TYPE WHERE RT_TYPE = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, columnValueMap.get(cName));
					set = auxStmnt.executeQuery();
					id = 0;
					while (set.next()) {
						id = set.getInt("RT_ID");
					}
					stmnt.setInt(p++, id);
					closeStream(set);
				} else {
					stmnt.setString(p++, columnValueMap.get(cName));
				}

			}
			set = stmnt.executeQuery();
			List<Reimbursement> reimbursements = new LinkedList<Reimbursement>();
			UserDaoImpl ud = new UserDaoImpl();
			while (set.next()) {
				reimbursements.add(fillReimbursement(set, conn, ud));
			}
			return reimbursements;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeStream(stmnt);
			closeStream(set);
			closeStream(auxStmnt);
		}
		return null;
	}

	private Reimbursement fillReimbursement(ResultSet rs, Connection conn, UserDaoImpl ud) throws SQLException {
		Reimbursement re = new Reimbursement();
		re.setId(rs.getInt("R_ID"));
		re.setAmount(rs.getDouble("R_AMOUNT"));
		re.setDescription(rs.getString("R_DESCRIPTION"));
		re.setReceipt(rs.getBlob("R_RECEIPT"));
		re.setSubmittedTime(rs.getTimestamp("R_SUBMITED").toLocalDateTime());
		if (rs.getTimestamp("R_RESOLVED") != null) {
			re.setResolvedTime(rs.getTimestamp("R_RESOLVED").toLocalDateTime());
		}

		re.setAuthor(ud.selectById(rs.getInt("U_ID_AUTHOR")));
		re.setResolver(ud.selectById(rs.getInt("U_ID_RESOLVER")));
		re.setReimbursementType(getType(rs.getInt("RT_TYPE"), conn));
		re.setReimbursementStatus(getStatus(rs.getInt("RS_STATUS"), conn));
		return re;
	}

	@Override
	public int updateBy(Map<String, String> columnValueMap, Map<String, String> conditions) {
		Set<String> conditionNames = conditions.keySet();
		Set<String> columnNames = columnValueMap.keySet();
		PreparedStatement stmnt = null;
		PreparedStatement auxStmnt = null;
		ResultSet set = null;
		int rows = 0;
		try {
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "UPDATE ERS_REIMBURSEMENTS SET ";
			boolean first = true;
			for (String name : columnNames) {
				if (first) {
					sql += name + " = ? ";
					first = false;
					continue;
				}
				sql += ", " + name + " = ? ";
			}
			first = true;
			sql += " WHERE ";
			for (String name : conditionNames) {
				if (first) {
					sql += name + " = ? ";
					first = false;
					continue;
				}
				sql += " AND " + name + " = ? ";
			}
			stmnt = conn.prepareStatement(sql);
			int i = 1;
			for (String name : columnNames) {
				String auxSql;
				int id;
				if(name.equals(ColumnNameUtil.STATUS))
				{
					auxSql = "SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, columnValueMap.get(name));
					set = auxStmnt.executeQuery();
					id = 0;
					logger.debug("option: " + name + " : " + columnValueMap.get(name));
					while (set.next()) {
						
						id = set.getInt("RS_ID");
					}
					logger.debug(id);
					stmnt.setInt(i++, id);
					closeStream(set);
				}else if(name.equals(ColumnNameUtil.TYPE))
				{
					auxSql = "SELECT RT_ID FROM ERS_REIMBURSEMENT_TYPE WHERE RT_TYPE = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, columnValueMap.get(name));
					set = auxStmnt.executeQuery();
					id = 0;
					logger.debug("option: " + name + " : " + columnValueMap.get(name));
					while (set.next()) {
						
						id = set.getInt("RT_ID");
					}
					logger.debug(id);
					stmnt.setInt(i++, id);
					closeStream(set);
				}else
				{
					logger.debug("option: " + name + " : " + columnValueMap.get(name));
					stmnt.setString(i++, columnValueMap.get(name));
				}
				
			}
			for (String name : conditionNames) {
				String auxSql;
				int id;
				if(name.equals(ColumnNameUtil.STATUS))
				{
					auxSql = "SELECT RS_ID FROM ERS_REIMBURSEMENT_STATUS WHERE RS_STATUS = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, conditions.get(name));
					set = auxStmnt.executeQuery();
					id = 0;
					while (set.next()) {
						logger.debug("condition: " + name + " : " + columnValueMap.get(name));
						id = set.getInt("RS_ID");
					}
					stmnt.setInt(i++, id);
					logger.debug(id);
					closeStream(set);
				}else if(name.equals(ColumnNameUtil.TYPE))
				{
					auxSql = "SELECT RT_ID FROM ERS_REIMBURSEMENT_TYPE WHERE RT_TYPE = ?";
					auxStmnt = conn.prepareStatement(auxSql);
					auxStmnt.setString(1, conditions.get(name));
					set = auxStmnt.executeQuery();
					id = 0;
					while (set.next()) {
						logger.debug("condition: " + name + " : " + columnValueMap.get(name));
						id = set.getInt("RT_ID");
					}
					stmnt.setInt(i++, id);
					logger.debug(id);
					closeStream(set);
				}else
				{
					logger.debug("condition: " + name + " : " + columnValueMap.get(name));
					logger.debug(conditions.get(name));
					stmnt.setString(i++, conditions.get(name));
				}
				
			}
			
			logger.debug(sql);
			
			rows = stmnt.executeUpdate();
			return rows;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			closeStream(stmnt);
			closeStream(auxStmnt);
			closeStream(set);
		}
		return 0;
	}

}

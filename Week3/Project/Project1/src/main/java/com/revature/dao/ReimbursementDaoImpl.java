package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.services.MyLogger;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{
	@Override
	public void createReimbursement(Reimbursement reimbursement) {
		MyLogger.logger.trace("Creating a reimbursement.");
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "INSERT INTO ERS_REIMBURSEMENTS " + 
					"(r_amount, r_description, r_receipt, r_submitted, " + 
					"u_id_author, rt_id, rs_id) "
					+ "VALUES (?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimbursement.getAmount());
			ps.setString(2, reimbursement.getDescription());
			ps.setBlob(3, reimbursement.getReceipt());
			ps.setTimestamp(4, reimbursement.getSubmitted());
			ps.setInt(5, reimbursement.getAuthorId());
			ps.setInt(6, reimbursement.getTypeId());
			ps.setInt(7, reimbursement.getStatusId());
			int affected = ps.executeUpdate();
			
			MyLogger.logger.info("Rows inserted: " + affected);
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in createReimbursement");
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	@Override
	public Reimbursement selectReimbursementById(int id) {
		MyLogger.logger.trace("Selecting a reimbursement by id");
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement reimbursement = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE r_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			reimbursement = new Reimbursement();
			while(rs.next()) {
				reimbursement.setId(rs.getInt("r_id"));
				reimbursement.setAmount(rs.getDouble("r_amount"));
				reimbursement.setDescription(rs.getString("r_description"));
				reimbursement.setReceipt(rs.getBlob("r_receipt"));
				reimbursement.setSubmitted(rs.getTimestamp("r_submitted"));
				reimbursement.setResolved(rs.getTimestamp("r_resolved"));
				reimbursement.setAuthorId(rs.getInt("u_id_author"));
				reimbursement.setResolverId(rs.getInt("u_id_resolver"));
				reimbursement.setTypeId(rs.getInt("rt_id"));
				reimbursement.setStatusId(rs.getInt("rs_id"));
			}
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectReimbursementById");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectReimbursements() {
		MyLogger.logger.trace("Selecting all reimbursements.");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_description"), rs.getBlob("r_receipt"), rs.getTimestamp("r_submitted"),
						rs.getTimestamp("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"),
						rs.getInt("rt_id"), rs.getInt("rs_id")));
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectReimbursements");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return reimbursements;
	}
	
	@Override
	public List<Reimbursement> selectReimbursementsByAuthorId(int id) {
		MyLogger.logger.trace("Selecting all reimbursements by author id");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE u_id_author = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_description"), rs.getBlob("r_receipt"), rs.getTimestamp("r_submitted"),
						rs.getTimestamp("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"),
						rs.getInt("rt_id"), rs.getInt("rs_id")));
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectReimbursementsByAuthorId");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return reimbursements;
	}
	
	@Override
	public List<Reimbursement> selectReimbursementsByStatus(String status) {
		MyLogger.logger.trace("Selecting all reimbursements by status");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE rs_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, getStatusId(status));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_description"), rs.getBlob("r_receipt"), rs.getTimestamp("r_submitted"),
						rs.getTimestamp("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"),
						rs.getInt("rt_id"), rs.getInt("rs_id")));
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectReimbursementsByStatus");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return reimbursements;
	}
	
	@Override
	public List<Reimbursement> selectReimbursementsByAuthorIdAndStatus(int id, String status) {
		MyLogger.logger.trace("Selecting all reimbursements by author id and status");
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE u_id_author = ? AND rs_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, getStatusId(status));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("r_id"), rs.getDouble("r_amount"),
						rs.getString("r_description"), rs.getBlob("r_receipt"), rs.getTimestamp("r_submitted"),
						rs.getTimestamp("r_resolved"), rs.getInt("u_id_author"), rs.getInt("u_id_resolver"),
						rs.getInt("rt_id"), rs.getInt("rs_id")));
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in selectReimbursementsByAuthorIdAndStatus");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return reimbursements;
	}

	@Override
	public void updateReimbursementReceipt(int id, Blob receipt) {
		MyLogger.logger.trace("Updating reimbursement receipt");
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE ERS_REIMBURSEMENTS" +
						"SET r_receipt = ? WHERE r_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setBlob(2, receipt);
			int affected = ps.executeUpdate();
			
			MyLogger.logger.info("Rows Updated: " + affected);
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in updateReimbursementReceipt");
			e.printStackTrace();
		} finally {
			close(ps);
		}
	}

	@Override
	public int getTypeId(String type) {
		MyLogger.logger.trace("Getting type id from string");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int typeId = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE rt_type = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, type);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				typeId = rs.getInt("rt_id");
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in getTypeId");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return typeId;
	}

	@Override
	public String getTypeById(int id) {
		MyLogger.logger.trace("Getting type string from id");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String type = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_TYPE WHERE rt_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				type = rs.getString("rt_type");
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in getTypeById");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return type;
	}

	@Override
	public int getStatusId(String status) {
		MyLogger.logger.trace("Getting status id from string");
		PreparedStatement ps = null;
		ResultSet rs = null;
		int statusId = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE rs_status = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, status);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				statusId = rs.getInt("rs_id");
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in getStatusId");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return statusId;
	}

	@Override
	public String getStatusById(int id) {
		MyLogger.logger.trace("Getting status string from id");
		PreparedStatement ps = null;
		ResultSet rs = null;
		String status = "Test";
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT * FROM ERS_REIMBURSEMENT_STATUS WHERE rs_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				status = rs.getString("rs_status");
			}
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in getStatusById");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
		return status;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		MyLogger.logger.trace("Updating reimbursement");
		PreparedStatement ps = null;
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "UPDATE ERS_REIMBURSEMENTS SET " + 
					"r_amount = ?, r_description = ?, r_receipt = ?, "
					+ "r_submitted = ?, r_resolved = ?, u_id_author = ?, "
					+ "u_id_resolver = ?, rt_id = ?, rs_id = ?"
					+ "WHERE r_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, reimbursement.getAmount());
			ps.setString(2, reimbursement.getDescription());
			ps.setBlob(3, reimbursement.getReceipt());
			ps.setTimestamp(4, reimbursement.getSubmitted());
			ps.setTimestamp(5, reimbursement.getResolved());
			ps.setInt(6, reimbursement.getAuthorId());
			ps.setInt(7, reimbursement.getResolverId());
			ps.setInt(8, reimbursement.getTypeId());
			ps.setInt(9, reimbursement.getStatusId());
			ps.setInt(10, reimbursement.getId());
			int affected = ps.executeUpdate();
			
			MyLogger.logger.info("Rows updated: " + affected);
			return true;
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in updateReimbursement");
			e.printStackTrace();
			return false;
		} finally {
			close(ps);
		}
	}

	@Override
	public void deleteReimbursementById(int id) {
		MyLogger.logger.trace("Deleting reimbursement by id");
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			
			String sql = "DELETE FROM ERS_REIMBURSEMENTS WHERE r_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
		} catch(SQLException e) {
			MyLogger.logger.debug("SQLException found in deleteReimbursementById");
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}
	}
}

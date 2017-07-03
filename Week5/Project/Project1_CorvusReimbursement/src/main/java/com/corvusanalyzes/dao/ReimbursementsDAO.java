package com.corvusanalyzes.dao;

import static com.corvusanalyzes.util.CloseStreams.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.corvusanalyzes.pojos.Reimbursement;
import com.corvusanalyzes.util.DBConnectionUtil;

public class ReimbursementsDAO implements ReimbursementsDAOInterface {
	final static Logger logger = Logger.getRootLogger();

	@Override
	public void createReimbursement(Reimbursement reimbursement) {
		CallableStatement cs = null;
		try(Connection conn = DBConnectionUtil.getConnection();) {
			String PLQuery = "{call insert_reimbursement_proc(?, ?, ?, ?, ?)}";
			cs = conn.prepareCall(PLQuery);
			cs.setFloat(1, reimbursement.getAmount());
			cs.setString(2, reimbursement.getDescription());
			cs.setBlob(3, reimbursement.getReceipt());
			cs.setInt(4, reimbursement.getAuthor());
			cs.setInt(5, reimbursement.getType());
			cs.executeQuery();
			
			logger.debug("Inserted reimbursement successfully.");
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(cs);
		}
	}

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		PreparedStatement ps = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {
			String query = "SELECT * FROM reimbursements";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();
				
				reimb.setId(rs.getInt("r_id"));
				reimb.setAmount(rs.getInt("r_amount"));
				reimb.setDescription(rs.getString("r_description"));
				reimb.setReceipt(rs.getBlob("r_receipt"));
				reimb.setSubmitted(rs.getTimestamp("r_submitted"));
				reimb.setResolved(rs.getTimestamp("r_resolved"));
				reimb.setAuthor(rs.getInt("u_id_author"));
				reimb.setResolver(rs.getInt("u_id_resolver"));
				reimb.setType(rs.getInt("rtype_id"));
				reimb.setStatus(rs.getInt("rstatus_id"));
				
				reimbursements.add(reimb);
			}
			
			logger.debug("Selected all reimbursements successfully.");
			
			return reimbursements;
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public String selectTypeFromTypeId(int type) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "SELECT rtype_type FROM Reimbursement_type WHERE rtype_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, type);
			rs = ps.executeQuery();
			rs.next();
			
			return rs.getString("rtype_type");
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public String selectStatusFromStatusId(int status) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "SELECT rstatus_status FROM Reimbursement_status WHERE rstatus_id = ?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, status);
			rs = ps.executeQuery();
			rs.next();
			
			return rs.getString("rstatus_status");
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public void updateStatusAndResolver(String newStatus, int reimbId, int u_id) {
		CallableStatement cs = null;
		int statusId = 0;
		
		if(newStatus.equals("approve")) statusId = 1;
		else if(newStatus.equals("deny")) statusId = 0;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {	
			String query = "{call update_reimbstatusresolver(?, ?, ?)}";
			cs = conn.prepareCall(query);
			cs.setInt(1, statusId);
			cs.setInt(2, u_id);
			cs.setInt(3, reimbId);
			cs.executeQuery();
			
			logger.debug("Updated reimbursement #" + reimbId + " to status " + newStatus + " (id: " + statusId + ") and resolver #" + u_id);
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(cs);
		}
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByAuthorId(int author_id) {
		PreparedStatement ps = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {
			String query = "SELECT * FROM reimbursements WHERE u_id_author=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, author_id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();
				
				reimb.setId(rs.getInt("r_id"));
				reimb.setAmount(rs.getInt("r_amount"));
				reimb.setDescription(rs.getString("r_description"));
				reimb.setReceipt(rs.getBlob("r_receipt"));
				reimb.setSubmitted(rs.getTimestamp("r_submitted"));
				reimb.setResolved(rs.getTimestamp("r_resolved"));
				reimb.setAuthor(rs.getInt("u_id_author"));
				reimb.setResolver(rs.getInt("u_id_resolver"));
				reimb.setType(rs.getInt("rtype_id"));
				reimb.setStatus(rs.getInt("rstatus_id"));
				
				reimbursements.add(reimb);
			}
			
			logger.debug("Selected reimbursements by author #" + author_id);
			
			return reimbursements;
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByAuthorIdAndStatus(int author_id, int status) {
		PreparedStatement ps = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {
			String query = null;
			if(status == 1) {
				query = "SELECT * FROM reimbursements WHERE u_id_author=? AND (rstatus_id=? OR rstatus_id=?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, author_id);
				ps.setInt(2, 0);
				ps.setInt(3, 1);
			}
			else if(status == 2) {
				query = "SELECT * FROM reimbursements WHERE u_id_author=? AND rstatus_id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, author_id);
				ps.setInt(2, status);
			}

			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();
				
				reimb.setId(rs.getInt("r_id"));
				reimb.setAmount(rs.getInt("r_amount"));
				reimb.setDescription(rs.getString("r_description"));
				reimb.setReceipt(rs.getBlob("r_receipt"));
				reimb.setSubmitted(rs.getTimestamp("r_submitted"));
				reimb.setResolved(rs.getTimestamp("r_resolved"));
				reimb.setAuthor(rs.getInt("u_id_author"));
				reimb.setResolver(rs.getInt("u_id_resolver"));
				reimb.setType(rs.getInt("rtype_id"));
				reimb.setStatus(rs.getInt("rstatus_id"));
				
				reimbursements.add(reimb);
			}
			
			logger.debug("Selected reimbursements by author #" + author_id + " and status #" + status);
			
			return reimbursements;
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByStatus(int status) {
		PreparedStatement ps = null;
		List<Reimbursement> reimbursements = new ArrayList<>();
		ResultSet rs = null;
		
		try(Connection conn = DBConnectionUtil.getConnection();) {
			String query = null;
			if(status == 1) {
				query = "SELECT * FROM reimbursements WHERE (rstatus_id=? OR rstatus_id=?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, 0);
				ps.setInt(2, 1);
			}
			else if(status == 2) {
				query = "SELECT * FROM reimbursements WHERE rstatus_id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, status);
			}

			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement reimb = new Reimbursement();
				
				reimb.setId(rs.getInt("r_id"));
				reimb.setAmount(rs.getInt("r_amount"));
				reimb.setDescription(rs.getString("r_description"));
				reimb.setReceipt(rs.getBlob("r_receipt"));
				reimb.setSubmitted(rs.getTimestamp("r_submitted"));
				reimb.setResolved(rs.getTimestamp("r_resolved"));
				reimb.setAuthor(rs.getInt("u_id_author"));
				reimb.setResolver(rs.getInt("u_id_resolver"));
				reimb.setType(rs.getInt("rtype_id"));
				reimb.setStatus(rs.getInt("rstatus_id"));
				
				reimbursements.add(reimb);
			}
			
			return reimbursements;
		} catch(SQLException e) {
			logger.error("SQLException thrown: ", e);
		} finally {
			close(ps);
			close(rs);
		}
		return null;
	}
}

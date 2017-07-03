package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimburseImplDAO implements ReimburseDAO  {

	public void createReimbursement(Reimbursement r) {
		CallableStatement call = null;
		try (Connection connect = ConnectionUtil.getConnection()) {
	 		String sql = "{CALL reimburse_insert_procedure(?,?,?,?,?,?)}";
			call = connect.prepareCall(sql);
			call.setDouble(1, r.getAmount());
			call.setString(2, r.getReport());
			call.setBlob(3, r.getReceipt());
			call.setInt(4,  r.getAuthor());
			call.setString(5, r.getStatus());
			call.setString(6, r.getType());
			int affected = call.executeUpdate();
			System.out.println(affected + " row inserted.");
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			close(call);
		}
		
	}

	public Reimbursement selectReimbursement(int r_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement reimburse = null;
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT A.R_ID, A.AMOUNT, A.REPORT, A.RECEIPT, A.SUBMITTED, A.RESOLVED, A.AUTHOR, A.RESOLVED_BY, "
					+ "B.STATUS, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN (SELECT A.R_ID, A.STATUS, B.R_TYPE FROM "
					+ "(SELECT A.R_ID, B.STATUS FROM REIMBURSEMENTS A LEFT JOIN STATUS B ON A.STATUS = B.STATUS_ID) A "
					+ "LEFT JOIN (SELECT A.R_ID, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN R_TYPES B ON A.R_TYPE = B.TYPE_ID) B "
					+ "ON A.R_ID = B.R_ID) B ON A.R_ID = B.R_ID WHERE A.R_ID = ?";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, r_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				double amt = rs.getDouble(2);
				String summary = rs.getString(3);
				Blob rec = rs.getBlob(4);
				String sdt = dateFormat.format(rs.getDate(5));
				String rdt;
				if (rs.getDate(6) == null) {
					rdt = null;
				} else {
					rdt = dateFormat.format(rs.getDate(6));
				}
				int author = rs.getInt(7);
				int resolved_by = rs.getInt(8);
				String stat = rs.getString(9);
				String type = rs.getString(10);
				reimburse = new Reimbursement(r_id, amt, summary, rec, sdt, rdt, author, resolved_by, stat, type);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return reimburse;
	}


	public void resolveReimbursement(Reimbursement r, int m_id) {
		CallableStatement call = null;
		try (Connection connect = ConnectionUtil.getConnection()) {
	 		String sql = "{CALL resolve_procedure(?,?,?)}";
			call = connect.prepareCall(sql);
			call.setInt(1, r.getR_id());
			call.setString(2, r.getStatus());
			call.setInt(3, m_id);
			int affected = call.executeUpdate();
			System.out.println(affected + " row updated.");
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			close(call);
		}	
	}
	
	public Collection<Reimbursement> selectEmployPendingReimbursements(int e_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection<Reimbursement> reimburse = new ArrayList<Reimbursement>();
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT A.R_ID, A.AMOUNT, A.REPORT, A.RECEIPT, A.SUBMITTED, A.RESOLVED, A.AUTHOR, A.RESOLVED_BY, "
					+ "B.STATUS, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN (SELECT A.R_ID, A.STATUS, B.R_TYPE FROM "
					+ "(SELECT A.R_ID, B.STATUS FROM REIMBURSEMENTS A LEFT JOIN STATUS B ON A.STATUS = B.STATUS_ID) A "
					+ "LEFT JOIN (SELECT A.R_ID, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN R_TYPES B ON A.R_TYPE = B.TYPE_ID) B "
					+ "ON A.R_ID = B.R_ID) B ON A.R_ID = B.R_ID WHERE A.AUTHOR = ? AND A.STATUS = 1";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, e_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				double amt = rs.getDouble(2);
				String summary = rs.getString(3);
				Blob rec = rs.getBlob(4);
				String sdt = dateFormat.format(rs.getDate(5));
				String rdt;
				if (rs.getDate(6) == null) {
					rdt = null;
				} else {
					rdt = dateFormat.format(rs.getDate(6));
				}
				int author = rs.getInt(7);
				int resolved_by = rs.getInt(8);
				String stat = rs.getString(9);
				String type = rs.getString(10);
				reimburse.add(new Reimbursement(id, amt, summary, rec, sdt, rdt, author, resolved_by, stat, type));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return reimburse;
	}

	public Collection<Reimbursement> selectEmployResolvedReimbursements(int e_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection<Reimbursement> reimburse = new ArrayList<Reimbursement>();
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT A.R_ID, A.AMOUNT, A.REPORT, A.RECEIPT, A.SUBMITTED, A.RESOLVED, A.AUTHOR, A.RESOLVED_BY, "
					+ "B.STATUS, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN (SELECT A.R_ID, A.STATUS, B.R_TYPE FROM "
					+ "(SELECT A.R_ID, B.STATUS FROM REIMBURSEMENTS A LEFT JOIN STATUS B ON A.STATUS = B.STATUS_ID) A "
					+ "LEFT JOIN (SELECT A.R_ID, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN R_TYPES B ON A.R_TYPE = B.TYPE_ID) B "
					+ "ON A.R_ID = B.R_ID) B ON A.R_ID = B.R_ID WHERE A.AUTHOR = ? AND A.STATUS <> 1";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, e_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				double amt = rs.getDouble(2);
				String summary = rs.getString(3);
				Blob rec = rs.getBlob(4);
				String sdt = dateFormat.format(rs.getDate(5));
				String rdt;
				if (rs.getDate(6) == null) {
					rdt = null;
				} else {
					rdt = dateFormat.format(rs.getDate(6));
				}
				int author = rs.getInt(7);
				int resolved_by = rs.getInt(8);
				String stat = rs.getString(9);
				String type = rs.getString(10);
				reimburse.add(new Reimbursement(id, amt, summary, rec, sdt, rdt, author, resolved_by, stat, type));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return reimburse;
	}
	
	public Collection<Reimbursement> selectPendingReimbursements() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection<Reimbursement> reimburse = new ArrayList<Reimbursement>();
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT A.R_ID, A.AMOUNT, A.REPORT, A.RECEIPT, A.SUBMITTED, A.RESOLVED, A.AUTHOR, A.RESOLVED_BY, "
					+ "B.STATUS, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN (SELECT A.R_ID, A.STATUS, B.R_TYPE FROM "
					+ "(SELECT A.R_ID, B.STATUS FROM REIMBURSEMENTS A LEFT JOIN STATUS B ON A.STATUS = B.STATUS_ID) A "
					+ "LEFT JOIN (SELECT A.R_ID, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN R_TYPES B ON A.R_TYPE = B.TYPE_ID) B "
					+ "ON A.R_ID = B.R_ID) B ON A.R_ID = B.R_ID WHERE A.STATUS = 1";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				double amt = rs.getDouble(2);
				String summary = rs.getString(3);
				Blob rec = rs.getBlob(4);
				String sdt = dateFormat.format(rs.getDate(5));
				String rdt;
				if (rs.getDate(6) == null) {
					rdt = null;
				} else {
					rdt = dateFormat.format(rs.getDate(6));
				}
				int author = rs.getInt(7);
				int resolved_by = rs.getInt(8);
				String stat = rs.getString(9);
				String type = rs.getString(10);
				reimburse.add(new Reimbursement(id, amt, summary, rec, sdt, rdt, author, resolved_by, stat, type));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return reimburse;
	}

	public Collection<Reimbursement> selectResolvedReimbursements() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection<Reimbursement> reimburse = new ArrayList<Reimbursement>();
		DateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy HH:mm:ss");
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT A.R_ID, A.AMOUNT, A.REPORT, A.RECEIPT, A.SUBMITTED, A.RESOLVED, A.AUTHOR, A.RESOLVED_BY, "
					+ "B.STATUS, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN (SELECT A.R_ID, A.STATUS, B.R_TYPE FROM "
					+ "(SELECT A.R_ID, B.STATUS FROM REIMBURSEMENTS A LEFT JOIN STATUS B ON A.STATUS = B.STATUS_ID) A "
					+ "LEFT JOIN (SELECT A.R_ID, B.R_TYPE FROM REIMBURSEMENTS A LEFT JOIN R_TYPES B ON A.R_TYPE = B.TYPE_ID) B "
					+ "ON A.R_ID = B.R_ID) B ON A.R_ID = B.R_ID WHERE A.STATUS <> 1";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				double amt = rs.getDouble(2);
				String summary = rs.getString(3);
				Blob rec = rs.getBlob(4);
				String sdt = dateFormat.format(rs.getDate(5));
				String rdt;
				if (rs.getDate(6) == null) {
					rdt = null;
				} else {
					rdt = dateFormat.format(rs.getDate(6));
				}
				int author = rs.getInt(7);
				int resolved_by = rs.getInt(8);
				String stat = rs.getString(9);
				String type = rs.getString(10);
				reimburse.add(new Reimbursement(id, amt, summary, rec, sdt, rdt, author, resolved_by, stat, type));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return reimburse;
	}
}

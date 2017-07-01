package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojos.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImp implements ReimbursementDAO {

	final static Logger logger = Logger.getLogger(ReimbursementDAOImp.class);

	@Override
	public void createReimbursement(Reimbursement r) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "insert into ers_reimbursements (r_amount, r_description, r_receipt, r_submitted, r_resolved, u_id_author, u_id_resolver, rt_type, rs_status) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, r.getAmount());
			stmt.setString(2, r.getDescription());
			stmt.setString(3, r.getReceipt());
			stmt.setTimestamp(4, r.getSubmitted());
			stmt.setTimestamp(5, r.getResolved());
			stmt.setInt(6, r.getAuthor_id());
			stmt.setNull(7, 0);
			stmt.setInt(8, r.getReimb_type());
			stmt.setInt(9, r.getReimb_status());
			int affected = stmt.executeUpdate();

			logger.trace("Rows inserted: " + affected);
		} catch (Exception e) {
			logger.warn("Exception was caught: " + e.toString());
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}

	@Override
	public Reimbursement selectReimbursementById(int id) {
		Reimbursement reimbursement = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where r_id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			while (rs.next()) {
				reimbursement = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(10),
						rs.getTimestamp("r_submitted"), rs.getTimestamp("r_resolved"), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9));
			}
			logger.trace("Selected Reimbursement: " + id);
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}

		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements order by r_id";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4),
						rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7), rs.getInt(8), rs.getInt(9),
						rs.getInt(10)));
				count++;
			}
			logger.trace("Select All Reimbursement Status': " + count + " records");
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}

		return reimbursements;
	}

	@Override
	public void deleteReimbursementById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "delete from ers_reimbursements where r_id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int affected = stmt.executeUpdate();

			logger.trace("Deleted " + affected + " Reimbursements");
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}
	}

	@Override
	public List<Reimbursement> selectReimbursementsById(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where r_id = ?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(10),
						rs.getTimestamp(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9)));
				count++;
			}
			logger.trace("Select All Reimbursement Status': " + count + " records");
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}

		return reimbursements;
	}

	@Override
	public List<Reimbursement> selectPendingReimbursementsById(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where u_id_author = ? and rs_status=1";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(10),
						rs.getTimestamp(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9)));
				count++;
			}
			logger.trace("Select All Reimbursement Status': " + count + " records");
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}

		return reimbursements;
	}

	@Override
	public List<Reimbursement> selectResolvedReimbursementsById(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where u_id_author = ? and rs_status>1";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(10),
						rs.getTimestamp(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9)));
				count++;
			}
			logger.trace("Select All Reimbursement Status': " + count + " records");
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}

		return reimbursements;
	}

	@Override
	public List<Reimbursement> selectPendingReimbursementsExcludingId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where u_id_author <> ? and rs_status=1";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(10),
						rs.getTimestamp(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9)));
				count++;
			}
			logger.trace("Select All Reimbursement Status': " + count + " records");
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}

		return reimbursements;
	}

	@Override
	public List<Reimbursement> selectResolvedReimbursementsExcludingId(int id) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from ers_reimbursements where u_id_author <> ? and rs_status > 1";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			int count = 0;
			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(10),
						rs.getTimestamp(4), rs.getTimestamp(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						rs.getInt(9)));
				count++;
			}
			logger.trace("Select All Reimbursement Status': " + count + " records");
		} catch (Exception e) {
			logger.warn("Exception was caught");
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rs);
		}

		return reimbursements;
	}

	@Override
	public void updateReimbursement(Reimbursement r) {
		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "update ers_reimbursements set r_amount=?, r_description=?, r_receipt=?, r_submitted=?, "
					+ "r_resolved=?, u_id_author=?, u_id_resolver=?, rt_type=?, rs_status=? where r_id=?";

			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, r.getAmount());
			stmt.setString(2, r.getDescription());
			stmt.setString(3, r.getReceipt());
			stmt.setTimestamp(4, r.getSubmitted());
			stmt.setTimestamp(5, r.getResolved());
			stmt.setInt(6, r.getAuthor_id());
			stmt.setInt(7, r.getResolver_id());
			stmt.setInt(8, r.getReimb_type());
			stmt.setInt(9, r.getReimb_status());
			stmt.setInt(10, r.getId());
			int affected = stmt.executeUpdate();

			logger.trace("Rows updated: " + affected);
		} catch (Exception e) {
			logger.warn("Exception was caught: " + e.toString());
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}

}

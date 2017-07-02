package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.revature.pojo.Reimbursement;
import com.revature.pojo.Users;
import com.revature.util.ConnectionUtil;

public class ReimbusementDaoImp implements ReimbursementDao {

	@Override
	public void createReimbursement(Reimbursement reim) {

		PreparedStatement stmt = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			double amount = reim.getR_AMOUNT();
			String description = reim.getDescription();
			Part receiptpath = reim.getReceipt();
			Timestamp rsubmitted = reim.getR_Submitted();
			Timestamp rresolved = reim.getR_resolved();
			int author = reim.getU_ID_AUTHOR();
			int resolver = reim.getU_ID_RESOLVER();
			int rtype = reim.getRT_ID();
			int rstatus = reim.getRS_ID();

			String sql = "INSERT INTO REIM Values( NULL,?,?,?,NULL,?,NULL,?, 3 ,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, amount);
			stmt.setString(2, description);
			stmt.setTimestamp(3, rsubmitted);
			stmt.setInt(4, author);
			stmt.setInt(5, rtype);
			stmt.setBinaryStream(6, receiptpath.getInputStream(), (int) receiptpath.getSize());

			int affected = stmt.executeUpdate();

			System.out.println("Rows inserted: " + affected);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(stmt);
		}
	}

	@Override
	public boolean deleteReim(int id) {
		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "DELETE FROM REIM WHERE R_ID = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int altered = ps.executeUpdate();

			System.out.println("Rows Deleted: " + altered);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(ps);
		}

	}

	@Override
	public boolean denyRequest(int uid, int rid) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE REIM SET R_RESOLVED = ?, U_ID_RESOLVER = ?, RS_ID = 2 WHERE R_ID=?";

			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, timestamp);
			ps.setInt(2, uid);
			ps.setInt(3, rid);
			int altered = ps.executeUpdate();

			System.out.println("Rows altered: " + altered);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(ps);
		}

	}

	@Override
	public boolean approveRequest(int uid, int rid) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		PreparedStatement ps = null;

		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE REIM SET R_RESOLVED = ?, U_ID_RESOLVER = ?, RS_ID = 1 WHERE R_ID=?";

			ps = conn.prepareStatement(sql);
			ps.setTimestamp(1, timestamp);
			ps.setInt(2, uid);
			ps.setInt(3, rid);
			int altered = ps.executeUpdate();

			System.out.println("Rows altered: " + altered);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			close(ps);
		}

	}

	@Override
	public List<Reimbursement> listAllReimsE(int uid) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement r = null;

		List<Reimbursement> rl = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reim Where U_ID_AUTHOR = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();

			while (rs.next()) {
				r = new Reimbursement();
				r.setR_ID(rs.getInt(1));
				r.setR_AMOUNT(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setR_Submitted(rs.getTimestamp(4));
				r.setR_resolved(rs.getTimestamp(5));
				r.setU_ID_AUTHOR(rs.getInt(6));
				r.setU_ID_RESOLVER(rs.getInt(7));
				r.setRT_ID(rs.getInt(8));
				r.setRS_ID(rs.getInt(9));
				r.setB(rs.getBlob(10));

				rl.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}

		return rl;

	}

	@Override
	public List<Reimbursement> listAllReimsM(int uid) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement r = null;

		List<Reimbursement> rl = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reim Where U_ID_AUTHOR <> ? AND RS_ID = 3";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();

			while (rs.next()) {
				r = new Reimbursement();
				r.setR_ID(rs.getInt(1));
				r.setR_AMOUNT(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setR_Submitted(rs.getTimestamp(4));
				r.setR_resolved(rs.getTimestamp(5));
				r.setU_ID_AUTHOR(rs.getInt(6));
				r.setU_ID_RESOLVER(rs.getInt(7));
				r.setRT_ID(rs.getInt(8));
				r.setRS_ID(rs.getInt(9));
				r.setB(rs.getBlob(10));

				rl.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}

		return rl;
	}

	@Override
	public List<Reimbursement> listAllRReimsM() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement r = null;

		List<Reimbursement> rl = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reim Where RS_ID = 1";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				r = new Reimbursement();
				r.setR_ID(rs.getInt(1));
				r.setR_AMOUNT(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setR_Submitted(rs.getTimestamp(4));
				r.setR_resolved(rs.getTimestamp(5));
				r.setU_ID_AUTHOR(rs.getInt(6));
				r.setU_ID_RESOLVER(rs.getInt(7));
				r.setRT_ID(rs.getInt(8));
				r.setRS_ID(rs.getInt(9));
				r.setB(rs.getBlob(10));

				rl.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}

		return rl;
	}

	@Override
	public List<Reimbursement> listAllDeimsM() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement r = null;

		List<Reimbursement> rl = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reim Where RS_ID = 2";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				r = new Reimbursement();
				r.setR_ID(rs.getInt(1));
				r.setR_AMOUNT(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setR_Submitted(rs.getTimestamp(4));
				r.setR_resolved(rs.getTimestamp(5));
				r.setU_ID_AUTHOR(rs.getInt(6));
				r.setU_ID_RESOLVER(rs.getInt(7));
				r.setRT_ID(rs.getInt(8));
				r.setRS_ID(rs.getInt(9));
				r.setB(rs.getBlob(10));

				rl.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}

		return rl;
	}

	@Override
	public Reimbursement selectReimById(int r_id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement r = null;

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reim Where R_ID = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, r_id);
			rs = ps.executeQuery();

			while (rs.next()) {
				r = new Reimbursement();
				r.setR_ID(rs.getInt(1));
				r.setR_AMOUNT(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setR_Submitted(rs.getTimestamp(4));
				r.setR_resolved(rs.getTimestamp(5));
				r.setU_ID_AUTHOR(rs.getInt(6));
				r.setU_ID_RESOLVER(rs.getInt(7));
				r.setRT_ID(rs.getInt(8));
				r.setRS_ID(rs.getInt(9));
				r.setB(rs.getBlob(10));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

		return r;
	}

	@Override
	public List<Reimbursement> listAllReimsById(int ruid) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Reimbursement r = null;

		List<Reimbursement> rl = new ArrayList<Reimbursement>();

		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reim Where U_ID_AUTHOR = ?";

			ps = conn.prepareStatement(sql);
			ps.setInt(1, ruid);
			rs = ps.executeQuery();

			while (rs.next()) {
				r = new Reimbursement();
				r.setR_ID(rs.getInt(1));
				r.setR_AMOUNT(rs.getDouble(2));
				r.setDescription(rs.getString(3));
				r.setR_Submitted(rs.getTimestamp(4));
				r.setR_resolved(rs.getTimestamp(5));
				r.setU_ID_AUTHOR(rs.getInt(6));
				r.setU_ID_RESOLVER(rs.getInt(7));
				r.setRT_ID(rs.getInt(8));
				r.setRS_ID(rs.getInt(9));
				r.setB(rs.getBlob(10));

				rl.add(r);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(ps);
			close(rs);
		}

		return rl;
	}
}

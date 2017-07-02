package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ReimStatus;
import com.revature.pojo.ReimType;
import com.revature.pojo.Reimbursement;
import com.revature.util.ConnectionUtil;

public class DaoReimbursementImpl implements DaoReimbursement {
	
	@Override
	public void createReim(Reimbursement r) {
		PreparedStatement ps = null;
			
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			double b = r.getAmount();
			String c = r.getDescription();
			Blob d = r.getReceipt();
			Timestamp e = r.getSubmitted();
			int g = r.getId_author();
			int i = r.getRt_id();
			int j = r.getRs_id();
			
			String sql = "INSERT INTO REIM" + "(r_amount, r_descrip, r_receipt, r_submitted, u_id_author, rt_id, rs_id)" + " VALUES (?,?,?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setDouble(1, b);
			ps.setString(2, c);
			System.out.println("test" + d);
			ps.setBlob(3, d);
			ps.setTimestamp(4, e);
			ps.setInt(5, g);
			ps.setInt(6, i);
			ps.setInt(7, j);
			
			int affected = ps.executeUpdate();
			
			System.out.println("Rows inserted: " + affected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			close(ps);
		}
	}
	
	@Override
	public List<Reimbursement> getReimById(int id) {
		
		PreparedStatement ps = null;
		List<Reimbursement> reims = new ArrayList<Reimbursement>();
		ResultSet rs = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM REIM WHERE U_ID_AUTHOR = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				reims.add(new Reimbursement(rs.getInt("R_ID"), rs.getDouble("R_AMOUNT"),
						rs.getString("R_DESCRIP"),rs.getBlob("R_RECEIPT"),rs.getTimestamp("R_SUBMITTED"),
						rs.getTimestamp("R_RESOLVED"),rs.getInt("U_ID_AUTHOR"),rs.getInt("U_ID_RESOLVER"),
						rs.getInt("RT_ID"), rs.getInt("RS_ID")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return reims;
	}
	
	@Override
	public void updateReim(Reimbursement r) {
		PreparedStatement ps = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
		
			String sql = "UPDATE REIM SET "+
					"R_RESOLVED = ?, "+
					"U_ID_RESOLVER = ?,"+
					"RS_ID = ? WHERE R_ID = ?";
			
			ps = con.prepareStatement(sql);
			ps.setTimestamp(1, r.getResolved());
			ps.setInt(2, r.getId_resolver());
			ps.setInt(3, r.getRs_id());
			ps.setInt(4, r.getId());
			int affected = ps.executeUpdate();
			
			System.out.println("Rows changed: " + affected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			close(ps);
		}
	}
	
	@Override
	public List<Reimbursement> getReimByUsername(String un) {
		
		PreparedStatement ps = null;
		List<Reimbursement> reims = new ArrayList<Reimbursement>();
		ResultSet rs = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			//join the user table with the reim table on u_id_author = u_id
			//where users.username = un
			String sql = "SELECT * FROM REIM INNER JOIN USERS ON U_ID_AUTHOR = U_ID"
					+ " WHERE U_USERNAME = ?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, un);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				reims.add(new Reimbursement(rs.getInt("R_ID"), rs.getDouble("R_AMOUNT"),
						rs.getString("R_DESCRIP"),rs.getBlob("R_RECEIPT"),rs.getTimestamp("R_SUBMITTED"),
						rs.getTimestamp("R_RESOLVED"),rs.getInt("U_ID_AUTHOR"),rs.getInt("U_ID_RESOLVER"),
						rs.getInt("RT_ID"), rs.getInt("RS_ID")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return reims;
	}
	
	@Override
	public Reimbursement getReimbursementById(int id) {
		
		PreparedStatement ps = null;
		Reimbursement reims = null;
		ResultSet rs = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM REIM WHERE R_ID = ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				reims = (new Reimbursement(rs.getInt("R_ID"), rs.getDouble("R_AMOUNT"),
						rs.getString("R_DESCRIP"),rs.getBlob("R_RECEIPT"),rs.getTimestamp("R_SUBMITTED"),
						rs.getTimestamp("R_RESOLVED"),rs.getInt("U_ID_AUTHOR"),rs.getInt("U_ID_RESOLVER"),
						rs.getInt("RT_ID"), rs.getInt("RS_ID")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return reims;
	}
	
	@Override
	public int getTypeByString(String t) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int type = 0;
		
		try {
			
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM REIM_TYPE WHERE RT_TYPE = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, t);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				type = rs.getInt("RT_ID");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return type;
	}

	@Override
	public int getResolveById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ReimType getTypeById(int id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ReimType r = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM REIM_TYPE WHERE RT_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				r = new ReimType(rs.getInt("RT_ID"), rs.getString("RT_TYPE"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return r;
	}

	@Override
	public ReimStatus getStatusById(int id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		ReimStatus r = null;
		
		try {
			
			Connection conn = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM REIM_STATUS WHERE RS_ID = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				r = new ReimStatus(rs.getInt("RS_ID"), rs.getString("RS_STATUS"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return r;
	}

	@Override
	public List<Reimbursement> getReimExcludeId(int id) {

		PreparedStatement ps = null;
		List<Reimbursement> reims = new ArrayList<Reimbursement>();
		ResultSet rs = null;
		
		try {
			
			Connection con = ConnectionUtil.getConnectionUtil().getConnection();
			String sql = "SELECT * FROM REIM WHERE U_ID_AUTHOR <> ?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				reims.add(new Reimbursement(rs.getInt("R_ID"), rs.getDouble("R_AMOUNT"),
						rs.getString("R_DESCRIP"),rs.getBlob("R_RECEIPT"),rs.getTimestamp("R_SUBMITTED"),
						rs.getTimestamp("R_RESOLVED"),rs.getInt("U_ID_AUTHOR"),rs.getInt("U_ID_RESOLVER"),
						rs.getInt("RT_ID"), rs.getInt("RS_ID")));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		finally {
			close(ps);
			close(rs);
		}
		return reims;
	}

}

package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojos.ReimbursementStatus;
import com.revature.util.ConnectionUtil;

public class ReimbursementStatusDAOImp implements ReimbursementStatusDAO {

	final static Logger logger = Logger.getLogger(ReimbursementStatusDAOImp.class);

	@Override
	public void createReimbursementStatus(ReimbursementStatus r) {
		PreparedStatement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_reimbursement_status (rs_status) values ('"+r.getStatus()+"')";
			
			stmt = conn.prepareStatement(sql);
			int affected = stmt.executeUpdate(sql);
			
			logger.trace("Rows inserted: " + affected);
		}catch(Exception e){
			logger.warn("Exception was caught: " + e.toString());
			e.printStackTrace();
		}finally{
			close(stmt);
		}
	}

	@Override
	public ReimbursementStatus selectReimbursementStatusById(int id) {
		ReimbursementStatus reimb = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_reimbursement_status where rs_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				reimb = new ReimbursementStatus(rs.getInt(1), rs.getString(2));
			}
			logger.trace("Selected Reimbursement Status: " + id);
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return reimb;
	}

	@Override
	public List<ReimbursementStatus> selectReimbursementStatus() {
		
		List<ReimbursementStatus> status = new ArrayList<ReimbursementStatus>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_reimbursement_status order by rs_id";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int count = 0;
			while(rs.next()){
				status.add(new ReimbursementStatus(rs.getInt(1), rs.getString(2)));
				count++;
			}
			logger.trace("Select All Reimbursement Status': " + count + " records");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return status;
	}

	@Override
	public void deleteReimbursementStatusById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "delete from ers_reimbursement_status where rs_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int affected = stmt.executeUpdate();
			
			logger.trace("Deleted "+ affected +" Reimbursement Status'");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
	}

}

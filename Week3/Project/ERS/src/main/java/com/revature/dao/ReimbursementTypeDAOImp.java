package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pojos.ReimbursementType;
import com.revature.util.ConnectionUtil;

public class ReimbursementTypeDAOImp implements ReimbursementTypeDAO {

	final static Logger logger = Logger.getLogger(ReimbursementTypeDAOImp.class);

	@Override
	public void createReimbursementType(ReimbursementType r) {
		PreparedStatement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "insert into ers_reimbursement_type (rt_type) values ('"+r.getType()+"')";
			
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
	public ReimbursementType selectReimbursementTypeById(int id) {
		ReimbursementType reimb = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_reimbursement_type where rt_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				reimb = new ReimbursementType(rs.getInt(1), rs.getString(2));
			}
			logger.trace("Selected Reimbursement Type: " + id);
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
	public List<ReimbursementType> selectReimbursementTypes() {
		
		List<ReimbursementType> types = new ArrayList<ReimbursementType>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "select * from ers_reimbursement_type order by rt_id";
			
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			int count = 0;
			while(rs.next()){
				types.add(new ReimbursementType(rs.getInt(1), rs.getString(2)));
				count++;
			}
			logger.trace("Select All Reimbursement Types: " + count + " records");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
		
		return types;
	}

	@Override
	public void deleteReimbursementTypeById(int id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "delete from ers_reimbursement_type where rt_id = ?";
			
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			int affected = stmt.executeUpdate();
			
			logger.trace("Deleted "+ affected +" Reimbursement Types");
		}catch(Exception e){
			logger.warn("Exception was caught");
			e.printStackTrace();
		}finally{
			close(stmt);
			close(rs);
		}
	}

	
}

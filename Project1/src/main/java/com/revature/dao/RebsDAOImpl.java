package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.revature.pojo.RebsObj;
import com.revature.util.ConnectionUtil;

public class RebsDAOImpl implements RebsDAO {

	@Override
	public void createReimbursement(RebsObj reb) {
		
		// creating PS which will run queries
		PreparedStatement ps = null;
		
		// looks in util/ConnectionUtil.java and saves the url, username and password to "conn"
		try(Connection conn = ConnectionUtil.getConnection();){ 
			
			//int reb_id = reb.getRebsId(); // REBS_ID IS AUTO INCREMENTING
			int user_id = reb.getUserId();
			//int man_id = reb.getManagerId(); // not needed
			int rebs_type = reb.getRebsType();
			int rebs_status = reb.getRebsStatus();
			double rebs_amount = reb.getRebsAmount();
			String rebs_description = reb.getRebsDescription();
			// Blob rebs_attachments
			Timestamp time_submitted = new Timestamp(System.currentTimeMillis());		
			// Timestamp time_resolved
			
			
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-YY hh:mm:ss.SSSSSSSSS");
			dateFormat.format(time_submitted);
			System.out.println("TIME STAMP IN DAO: " + time_submitted);
			
			// you can put this string 'sql' into multiple lines by adding +, and having everything within ""
			// this sql line will be ran on SQL
			String sql = "INSERT INTO ERS_REIMBURSEMENTS(rebs_id, user_id_author, user_id_resolver, "
					+ "rebs_type, rebs_status, rebs_amount, rebs_description, rebs_receipt, "
					+ "rebs_submitted, rebs_resolved) " 
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			// creating prepared statement
			ps = conn.prepareStatement(sql);  // uses connection to send string as a prepared statement
			ps.setString(1, null);   // USER_ID IS AUTO INCREMENTING
			ps.setInt(2, user_id);
			ps.setString(3, null);
			ps.setInt(4, rebs_type);
			ps.setInt(5, rebs_status);
			ps.setDouble(6, rebs_amount);
			ps.setString(7, rebs_description);
			ps.setString(8, null);
			ps.setTimestamp(9, time_submitted);
			ps.setString(10, null);
			
			// rows affected
			int affected = ps.executeUpdate();
			System.out.println("Rows inserted: " + affected);
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		
		System.out.println("Created new reimbursement request!");

	}

	@Override
	public RebsObj selectReimbursementById(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RebsObj> selectReimbursements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RebsObj updateReimbursement(RebsObj reb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReimbursementById(int id) {
		// TODO Auto-generated method stub

	}

}

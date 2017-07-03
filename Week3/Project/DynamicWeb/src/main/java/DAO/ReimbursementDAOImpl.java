package DAO;

import static Database.CloseStreams.close;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import Database.ConnectionUtil;
import Database.ReimbursementPOJO;

public class ReimbursementDAOImpl implements ReimbursementDAO {
	
	/*
	 * This method will add a new reimbursement to the database
	 */
	public void AddReimbursement(ReimbursementPOJO reimb) {
		Statement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			int id = reimb.getId();
			String descr = reimb.getDescr();
			String dateCr = reimb.getDateCr();
			int empCr = reimb.getEmpCr();
			double amt = reimb.getAmt();
			int type = reimb.getType();
			String rcpt = reimb.getRcpt();
			
			// Creating the SQL statement that will insert the new row into the database
			String sql = "INSERT INTO Reimbursements VALUES (" + id + ", '"
													  		   + descr + "', "
													  		   + "TO_DATE('" + dateCr + "', 'yyyy-mm-dd hh24:mi:ss'), "
													  		   + "NULL , "
													  		   + empCr + ", "
													  		   + "NULL , "
													  		   + amt + ", "
													  		   + type + ", "
													  		   + "1, '"
													  		   + rcpt + "')";
			
			stmt = conn.createStatement();
			int affected = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	};
	
	/*
	 * This method will be used to delete reimbursements
	 */
	public void DeleteReimbursement(int id) {
		
	};
	
	/*
	 * This method will return a list of reimbursements
	 */
	public List<ReimbursementPOJO> getAllReimbs() {
		ResultSet rs = null;
		
		LinkedList<ReimbursementPOJO> reimbList = new LinkedList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			Statement stmt = null;
			String sql = "SELECT * FROM Reimbursements " +
					"ORDER BY StatusID, DateCreated DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				reimbList.add(new ReimbursementPOJO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getDouble(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getString(10)
					));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
		}
		
		return reimbList;
	};
	
	/*
	 * This method will return a list of pending reimbursements
	 */
	public List<ReimbursementPOJO> getPendReimbs() {
		ResultSet rs = null;
		
		LinkedList<ReimbursementPOJO> reimbList = new LinkedList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			Statement stmt = null;
			String sql = "SELECT * FROM Reimbursements WHERE StatusID=1 " +
					"ORDER BY DateCreated DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				reimbList.add(new ReimbursementPOJO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getDouble(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getString(10)
					));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
		}
		
		return reimbList;
	};
	
	/*
	 * This method will select reimbursements by a single userID
	 */
	public List<ReimbursementPOJO> selectReimbByID(int id) {
		ResultSet rs = null;
		
		LinkedList<ReimbursementPOJO> reimbList = new LinkedList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			Statement stmt = null;
			String sql = "SELECT * FROM Reimbursements WHERE CreatedByID=" + id +
					"ORDER BY DateCreated DESC";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				reimbList.add(new ReimbursementPOJO(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getDouble(7),
						rs.getInt(8),
						rs.getInt(9),
						rs.getString(10)
					));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
		}
		
		return reimbList;
	};
	
	/*
	 * This method will allow a manager to approve or reject reimbursements
	 */
	public void ApproveReimb (int id, int action, int mgrId) {
		Statement stmt = null;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			String updReimb = null;
			if (action == 1) {
				updReimb = "2";
			} else {
				updReimb = "3";
			}
			
			Calendar calendar = Calendar.getInstance();
			/*Timestamp tStamp = new java.sql.Timestamp(calendar.getTime().getTime());
			String tStampStr = 
			String curTime = tStamp.substring(0, 18);*/
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String curTime = dateFormat.format(new java.sql.Timestamp(calendar.getTime().getTime()));
			System.out.println(curTime);
			
			String sql = "UPDATE Reimbursements SET StatusID=" +
					updReimb + ", DateResolved=TO_DATE('" + curTime +
					"', 'yyyy-mm-dd hh24:mi:ss'), ResolvedByID=" + mgrId + " WHERE ReimbID=" + id;
			
			System.out.println(sql);
			
			stmt = conn.createStatement();
			int affected = stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	};
	
	public int GetMaxId() {
		Statement stmt = null;
		int maxId = 0;
		
		try(Connection conn = ConnectionUtil.getConnection();) {
			
			String sql = "SELECT MAX(ReimbID) FROM Reimbursements";
			
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				maxId = rs.getInt("Max(ReimbID)");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		return maxId;
	};

}

package dao;

import static util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import pojo.ErsReimburse;
import util.CloseStreams;
import util.ConnectionUtil;

public class ReimDaoImpl implements ReimDao{

	@Override
	public ErsReimburse selectReimburseById(int id) {
		return null;
	}

	@Override
	public List<ErsReimburse> selectAllReimbursements() {
		PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedList<ErsReimburse> list = new LinkedList<>();

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "SELECT * FROM ERS_REIMBURSEMENTS";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
    
            while(rs.next())
            {
                list.add(new ErsReimburse(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10) ));
            }

        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
        return list;
	}
	
	@Override
	public List<ErsReimburse> selectReimbursementsById(int id) {
		PreparedStatement ps = null;
        ResultSet rs = null;
        LinkedList<ErsReimburse> list = new LinkedList<>();

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
    
            while(rs.next())
            {
                list.add(new ErsReimburse(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getTimestamp(5), rs.getTimestamp(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10) ));
            }

        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
        return list;
		
	}

	@Override
	public void createReimbursementMinReq(ErsReimburse er) {
		Statement st = null;

		try(Connection conn = ConnectionUtil.getConnection()){
			int R_ID = er.getR_ID();
			int U_ID_AUTHOR = er.getU_ID_AUTHOR();
			int RT_TYPE = er.getRT_TYPE();
			int RS_STATUS = 1;
			
			String sql = "INSERT INTO ERS_REIMBURSEMENTS(R_ID, R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, RT_TYPE, RS_STATUS)"
			+ " VALUES ('"+R_ID+"','','','', current_timestamp , current_timestamp ,'"+U_ID_AUTHOR+"','','"+RT_TYPE+"','"+RS_STATUS+"')";
			st = conn.createStatement();
			int affected = st.executeUpdate(sql);
			
			System.out.println("Rows inserted: " + affected);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			CloseStreams.close(st);
		}
	}





}

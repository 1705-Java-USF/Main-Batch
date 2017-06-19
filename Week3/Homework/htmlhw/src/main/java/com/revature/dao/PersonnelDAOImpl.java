package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Personnel;
import com.revature.util.ConnectionUtil;

public class PersonnelDAOImpl implements PersonnelDAO{
	
	@Override
	public void createPersonnel(Personnel fc) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection();){
			int pid = fc.getId();
			String u = fc.getUsername();
			String p = fc.getPassword();
			String f = fc.getFirstname();
			String l = fc.getLastname();
			String e = fc.getEmail();
			int prid = fc.getPrid();
			
			String sql = "INSERT INTO cs_personnel "
					+ "VALUES ('"+pid+"','"+u+"','"+p+"','"+f+"','"+l+"','"+e+"','"+prid+"')";
			
			ps = conn.prepareStatement(sql);
			int affected = ps.executeUpdate(sql);
			
			System.out.println("Rows inserted: " + affected);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		
	}

	@Override
	public Personnel selectPersonnelById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Personnel fc = null;
		
		//Must implement auto closeable
		//Connection string will be closed and work only in try block
		//"try-with-resources" (alternative to CloseStreams.java)
		try(Connection conn = ConnectionUtil.getConnection();){
	
			String sql = "SELECT * FROM cs_personnel WHERE p_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			fc = new Personnel();
			while(rs.next()){
				fc.setId(rs.getInt(1));
				fc.setUsername(rs.getString(2));
				fc.setPassword(rs.getString(3));
				fc.setFirstname(rs.getString(4));
				fc.setLastname(rs.getString(5));
				fc.setEmail(rs.getString(6));
				fc.setPrid(rs.getInt(7));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		
		return fc;
	}

	@Override
	public List<Personnel> selectPersonnels() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Personnel> fc = new ArrayList<Personnel>();
		
		try(Connection conn = ConnectionUtil.getConnection();){
								
			String sql = "SELECT * FROM cs_personnel";		
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while(rs.next()){
				fc.add(new Personnel(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7)));
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		
		return fc;
	}

	@Override
	public void deletePersonnelById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection();){
			
			String sql = "DELETE FROM cs_personnel WHERE p_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
	}



	////^^^ mandatory DAO methods
	@Deprecated
	@Override
	public void createPersonnelSP(Personnel fc) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection();){
			
			//String a = fc.getAnswer();
			//String q = fc.getQuestion();
			
			//plsql requires {}
			String sql = "{call insert_fc_procedure(?,?)}";
			cs = conn.prepareCall(sql);
			//cs.setString(1, q);
			//cs.setString(2, a);
			cs.executeQuery();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(cs);
			
		}
	}
	
	
}

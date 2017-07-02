package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.GunRequests;
import com.revature.util.ConnectionUtil;

public class GunRequestsDAOImpl implements GunRequestsDAO {
	
//	private static int gid = 0;
//	private int cost;
//	private String desc;
//	private byte[] rf;
//	private String sub;
//	private String clo;
//	private int pidauth;
//	private int pidclo;
//	private int gtype;
//	private int gstatus;	
	
	@Override
	public void createGunRequest(GunRequests fc) {
		PreparedStatement ps = null;
		
		try(Connection conn = ConnectionUtil.getConnection();){
			int gid = fc.getGid();
			int cost = fc.getCost();
			String d = fc.getDesc();
			InputStream rf = fc.getRf();
			Timestamp sbmt = fc.getSub();
			Timestamp clsd = fc.getClo();
			int pauth = fc.getPidauth();
			int pclsd = fc.getPidclo();
			int gtype = fc.getGtype();
			int gstatus = fc.getGstatus();
						
			String sql = "INSERT INTO cs_gun_requests "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			ps.setInt(2, cost);
			ps.setString(3, d);
			ps.setBlob(4, rf);
			ps.setTimestamp(5, sbmt);
			if(clsd == null){
				ps.setNull(6, java.sql.Types.TIMESTAMP);	
			}else{
				ps.setTimestamp(6, clsd);
			}
			ps.setInt(7, pauth);
			if(pclsd == pauth){
				ps.setNull(8, java.sql.Types.INTEGER);
			}else{
				ps.setInt(8, pclsd);
			}
			ps.setInt(9, gtype);
			ps.setInt(10, gstatus);
			
			ps.executeQuery();
						
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(ps);
		}
		
	}

	@Override
	public GunRequests selectGunRequestById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		GunRequests fc = null;
		
		//Must implement auto closeable
		//Connection string will be closed and work only in try block
		//"try-with-resources" (alternative to CloseStreams.java)
		try(Connection conn = ConnectionUtil.getConnection();){
	
			String sql = "SELECT * FROM cs_gun_requests WHERE g_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			fc = new GunRequests();
			while(rs.next()){
				fc.setGid(rs.getInt(1));
				fc.setCost(rs.getInt(2));
				fc.setDesc(rs.getString(3));
				fc.setRf(rs.getBlob(4).getBinaryStream());
				fc.setSub(rs.getTimestamp(5));
				fc.setClo(rs.getTimestamp(6));
				fc.setPidauth(rs.getInt(7));
				fc.setPidclo(rs.getInt(8));
				fc.setGtype(rs.getInt(9));
				fc.setGstatus(rs.getInt(10));
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
	public List<GunRequests> selectGunRequests() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<GunRequests> fc = new ArrayList<GunRequests>();
		
		try(Connection conn = ConnectionUtil.getConnection();){
								
			String sql = "SELECT * FROM cs_gun_requests";		
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while(rs.next()){
				fc.add(new GunRequests(
						rs.getInt(1),
						rs.getInt(2), 
						rs.getString(3), 
						rs.getBlob(4).getBinaryStream(), 
						rs.getTimestamp(5), 
						rs.getTimestamp(6), 
						rs.getInt(7), 
						rs.getInt(8), 
						rs.getInt(9),
						rs.getInt(10)));
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
	public void deleteGunRequestById(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection();){
			
			String sql = "DELETE FROM cs_gun_requests WHERE g_id = ?";
			
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

	public int getCurrentMaxId(){		
		PreparedStatement ps = null;
		ResultSet rs = null;
		int gid = 0;
		
		try(Connection conn = ConnectionUtil.getConnection();){
								
			String sql = "select max(g_id) from cs_gun_requests";		
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		
			while(rs.next()){
				gid = rs.getInt(1);
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		
		return gid;
	}
	
	
	@Override
	public void updateGunRequestStatusById(int status, int mid, Timestamp closed, int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try(Connection conn = ConnectionUtil.getConnection();){
			
			String sql = "UPDATE cs_gun_requests "
					+ "SET gs_status = ?,"
					+ "p_id_closer = ?,"
					+ "g_closed = ? "
					+ "WHERE g_id = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, mid);
			ps.setTimestamp(3, closed);
			ps.setInt(4, id);
			rs = ps.executeQuery();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
	}
	
	
	public byte[] getImageByGunId(int gid){		
		PreparedStatement ps = null;
		ResultSet rs = null;
		byte[] imageData = null;
		
		try(Connection conn = ConnectionUtil.getConnection();){
								
			String sql = "select g_req_form from cs_gun_requests where g_id = ?";		
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			rs = ps.executeQuery();
		
			while(rs.next()){
				imageData = rs.getBytes(1);
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rs);
			close(ps);
		}
		
		return imageData;
	}
	
}
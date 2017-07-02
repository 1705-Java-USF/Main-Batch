package main.java.com.revature.DAO;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import main.java.com.revature.pojo.ERS_REIMBURSEMENTS;
import main.java.com.revature.pojo.ERS_USERS;

import oracle.jdbc.OracleResultSet;
import oracle.sql.BLOB;

public class ERS_DAO implements DAO {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	private final static String url = "jdbc:oracle:thin:@sandbox.c7gydzn7nvzj.us-east-1.rds.amazonaws.com:1521:orcl";
	private final static String ERS_USERSname = "paul";
	private final static String password = "paul1234";

	@Override
	public String getPassword(String uname) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT u_password FROM ers_ERS_USERSs WHERE u_ERS_USERSname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ERS_USERS getERS_USERS(String uname) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT u_id, u_ERS_USERSname, u_firstname, u_lastname, u_email, ur_role FROM ers_ERS_USERSs JOIN ers_ERS_USERS_roles ON ers_ERS_USERSs.ur_id = ers_ERS_USERS_roles.ur_id WHERE u_ERS_USERSname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ERS_USERS ERS_USERS = new ERS_USERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			return ERS_USERS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ERS_USERS getERS_USERS(int uid) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT u_id, u_ERS_USERSname, u_firstname, u_lastname, u_email, ur_role FROM ers_ERS_USERSs JOIN ers_ERS_USERS_roles ON ers_ERS_USERSs.ur_id = ers_ERS_USERS_roles.ur_id WHERE u_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ERS_USERS ERS_USERS = new ERS_USERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			return ERS_USERS;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateRequest(int id, String type, int uid){
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "UPDATE ers_ERS_REIMBURSEMENTSs SET rt_status = ?, r_resolved = ?, u_id_resolver = ? WHERE r_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			switch (type){
			case "Approved":
				ps.setInt(1, 1);
				break;
			case "Denied":
				ps.setInt(1, 2);
				break;
			default:
				ps.setInt(1, 0);
			}
			ps.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
			ps.setInt(3, uid);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ERS_REIMBURSEMENTS getRequest(int id) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT r_id, r_amount, r_description, r_receipt, r_submitted, r_resolved, rs_status, ers_ERS_REIMBURSEMENTS_type.rt_type, u_id_author, u_id_resolver FROM ers_ERS_REIMBURSEMENTSs JOIN ers_ERS_REIMBURSEMENTS_type on ers_ERS_REIMBURSEMENTSs.rt_type = ers_ERS_REIMBURSEMENTS_type.rt_id JOIN ers_ERS_REIMBURSEMENTS_status on ers_ERS_REIMBURSEMENTSs.rt_status = ers_ERS_REIMBURSEMENTS_status.rs_id WHERE r_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			ERS_USERS auth = getERS_USERS(rs.getInt(9));
			ERS_USERS res;
			Blob img = rs.getBlob(4);
			String rec = null;
			if(img!=null){
				byte[] imgData = img.getBytes(1,(int)img.length());
				rec = new String(Base64.getEncoder().encode(imgData), "UTF-8");
			}
			else rec = null;
			if (rs.getInt(10) == 0)
				res = null;
			else
				res = getERS_USERS(rs.getInt(10));
			return new ERS_REIMBURSEMENTS(rs.getInt(1), rs.getDouble(2), rs.getString(3), rec, rs.getTimestamp(5),
					rs.getTimestamp(6), auth, res, rs.getString(7), rs.getString(8));
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ERS_REIMBURSEMENTS> getAllRequests() {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT r_id, r_amount, r_description, r_receipt, r_submitted, r_resolved, rs_status, ers_ERS_REIMBURSEMENTS_type.rt_type, u_id_author, u_id_resolver FROM ers_ERS_REIMBURSEMENTSs JOIN ers_ERS_REIMBURSEMENTS_type on ers_ERS_REIMBURSEMENTSs.rt_type = ers_ERS_REIMBURSEMENTS_type.rt_id JOIN ers_ERS_REIMBURSEMENTS_status on ers_ERS_REIMBURSEMENTSs.rt_status = ers_ERS_REIMBURSEMENTS_status.rs_id";
			List<ERS_REIMBURSEMENTS> result = new ArrayList<ERS_REIMBURSEMENTS>();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ERS_USERS auth = getERS_USERS(rs.getInt(9));
				ERS_USERS res;
				Blob img = rs.getBlob(4);
				String rec = null;
				if(img!=null){
					byte[] imgData = img.getBytes(1,(int)img.length());
					rec = new String(Base64.getEncoder().encode(imgData), "UTF-8");
				}
				else rec = null;
				if (rs.getInt(10) == 0)
					res = null;
				else
					res = getERS_USERS(rs.getInt(10));

				result.add(new ERS_REIMBURSEMENTS(rs.getInt(1), rs.getDouble(2), rs.getString(3), rec, rs.getTimestamp(5),
						rs.getTimestamp(6), auth, res, rs.getString(7), rs.getString(8)));
			}
			return result;
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ERS_REIMBURSEMENTS> getAllERS_USERSRequests(int uid) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT r_id, r_amount, r_description, r_receipt, r_submitted, r_resolved, rs_status, ers_ERS_REIMBURSEMENTS_type.rt_type, u_id_author, u_id_resolver FROM ers_ERS_REIMBURSEMENTSs JOIN ers_ERS_REIMBURSEMENTS_type on ers_ERS_REIMBURSEMENTSs.rt_type = ers_ERS_REIMBURSEMENTS_type.rt_id JOIN ers_ERS_REIMBURSEMENTS_status on ers_ERS_REIMBURSEMENTSs.rt_status = ers_ERS_REIMBURSEMENTS_status.rs_id WHERE u_id_author = ?";
			List<ERS_REIMBURSEMENTS> result = new ArrayList<ERS_REIMBURSEMENTS>();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ERS_USERS auth = getERS_USERS(rs.getInt(9));
				ERS_USERS res;
				Blob img = rs.getBlob(4);
				String rec = null;
				if(img!=null){
					byte[] imgData = img.getBytes(1,(int)img.length());
					rec = new String(Base64.getEncoder().encode(imgData), "UTF-8");
				}
				else rec = null;
				if (rs.getInt(10) == 0)
					res = null;
				else
					res = getERS_USERS(rs.getInt(10));

				result.add(new ERS_REIMBURSEMENTS(rs.getInt(1), rs.getDouble(2), rs.getString(3),rec, rs.getTimestamp(5),
						rs.getTimestamp(6), auth, res, rs.getString(7), rs.getString(8)));
			}
			return result;
		} catch (SQLException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addReceipt(int rid, byte[] rec){
		try(Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			PreparedStatement ps = con.prepareStatement("UPDATE ers_ERS_REIMBURSEMENTSs SET r_receipt = ? WHERE r_id = ?");
			ps.setInt(2, rid);
			ps.setBytes(1, rec);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Blob getReceipt(int rid){
		try(Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT r_receipt FROM ers_ERS_REIMBURSEMENTSs WHERE r_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			Blob b = null;
			if (rs.next()){
				b = rs.getBlob(1);
			}
			
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ERS_REIMBURSEMENTS> getResolvedRequests(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ERS_REIMBURSEMENTS> getPendingRequests(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ERS_REIMBURSEMENTS> getDeniedRequests(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setPassword(int id, String newPass) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ERS_USERS updateInfo(ERS_USERS ERS_USERS) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "UPDATE ers_ERS_USERSs SET u_firstname = ?, u_lastname = ?, u_email = ? WHERE u_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ERS_USERS.getFname());
			ps.setString(2, ERS_USERS.getLname());
			ps.setString(3, ERS_USERS.getEmail());
			ps.setInt(4, ERS_USERS.getId());
			int res = ps.executeUpdate();
			if (res == 1)
				return ERS_USERS;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createRequest(ERS_REIMBURSEMENTS re) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "INSERT INTO ers_ERS_REIMBURSEMENTSs(r_amount, r_description, r_submitted, u_id_author, rt_type, rt_status) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, re.getAmount());
			ps.setString(2, re.getDesc());
			ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			ps.setInt(4, re.getAuthor().getId());
			switch (re.getType()) {
			case "Travel":
				ps.setInt(5, 1);
				break;
			case "Certification":
				ps.setInt(5, 2);
				break;
			case "Other":
				ps.setInt(5, 3);
				break;
			}
			ps.setInt(6, 0);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ERS_USERS registerERS_USERS(ERS_USERS newERS_USERS) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkERS_USERSname(String uname) {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT count(u_ERS_USERSname) FROM ers_ERS_USERSs WHERE u_ERS_USERSname = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<ERS_USERS> getEmployees() {
		try (Connection con = DriverManager.getConnection(url, ERS_USERSname, password);) {
			String sql = "SELECT u_id, u_ERS_USERSname, u_firstname, u_lastname, u_email, ur_role FROM ers_ERS_USERSs JOIN ers_ERS_USERS_roles ON ers_ERS_USERSs.ur_id = ers_ERS_USERS_roles.ur_id WHERE ers_ERS_USERSs.ur_id = 0";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<ERS_USERS> ERS_USERSs = new ArrayList<>();
			while (rs.next()) {
				ERS_USERSs.add(new ERS_USERS(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6)));
			}
			return ERS_USERSs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
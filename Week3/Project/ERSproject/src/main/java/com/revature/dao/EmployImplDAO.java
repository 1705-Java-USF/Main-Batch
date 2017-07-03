package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.revature.pojos.Employee;
import com.revature.util.ConnectionUtil;

public class EmployImplDAO implements EmployDAO {

	public void createEmployee(Employee e) {
		CallableStatement call = null;
		try (Connection connect = ConnectionUtil.getConnection()) {
	 		String sql = "{CALL employee_insert_procedure(?,?,?,?,?,?)}";
			call = connect.prepareCall(sql);
			call.setString(1, e.getUsername());
			call.setString(2, e.getPassword());
			call.setString(3, e.getFirstname());
			call.setString(4, e.getLastname());
			call.setString(5, e.getEmail());
			call.setString(6, e.getTitle());
			int affected = call.executeUpdate();
			System.out.println(affected + " row inserted.");
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			close(call);
		}
	}

	public Collection<Employee> selectAllEmployees() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Collection<Employee> company = new ArrayList<Employee>();
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT A.EMPLOYEE_ID,A.E_USERNAME,A.E_PASSWORD,A.FIRSTNAME,A.LASTNAME,A.EMAIL,B.TITLE "
					+ "FROM EMPLOYEES A LEFT JOIN TITLES B ON A.TITLE = B.TITLE_ID WHERE A.TITLE = 2";
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				company.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return company;
	}

	public Employee selectEmployee(int employee_id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee e = null;
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT A.EMPLOYEE_ID,A.E_USERNAME,A.E_PASSWORD,A.FIRSTNAME,A.LASTNAME,A.EMAIL,B.TITLE "
					+ "FROM (SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?) A LEFT JOIN TITLES B ON A.TITLE = B.TITLE_ID";
			ps = connect.prepareStatement(sql);
			ps.setInt(1, employee_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return e;
	}

	public void updateEmployee(Employee e) {
		CallableStatement call = null;
		try (Connection connect = ConnectionUtil.getConnection()) {
	 		String sql = "{CALL employee_update_procedure(?, ?, ?, ?, ?)}";
			call = connect.prepareCall(sql);
			call.setInt(1, e.getEmployee_id());
			call.setString(2, e.getPassword());
			call.setString(3, e.getFirstname());
			call.setString(4, e.getLastname());
			call.setString(5, e.getEmail());
			int affected = call.executeUpdate();
			System.out.println(affected + " row updated.");
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			close(call);
		}	
	}

	public void promoteEmployee(int employee_id) {
		CallableStatement call = null;
		try (Connection connect = ConnectionUtil.getConnection()) {
	 		String sql = "{CALL promote_procedure(?)}";
			call = connect.prepareCall(sql);
			call.setInt(1, employee_id);
			int affected = call.executeUpdate();
			System.out.println(affected + " row updated.");
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			close(call);
		}	
	}

	@Override
	public int loginEmployee(String username, String password) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		int id = 0;
		try (Connection connect = ConnectionUtil.getConnection()) {
			String sql = "SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE E_USERNAME = ? AND E_PASSWORD = ?";
			ps = connect.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				id = rs.getInt(1);
			}
		} catch(SQLException exception) {
			exception.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return id;
	}
	
}

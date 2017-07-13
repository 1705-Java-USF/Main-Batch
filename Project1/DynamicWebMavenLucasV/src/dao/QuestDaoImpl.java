package dao;

import static util.CloseStreams.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionUtil;

public class QuestDaoImpl implements QuestDao{

	@Override
	public void quest10() {
//		UPDATE ERS_REIMBURSEMENTS
//		SET R_AMOUNT = 120,
//		    R_DESCRIPTION = 'Hunt a Popo'
//		WHERE (RT_TYPE = 10);
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 10";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 120);
            ps.setString(2, "Hunt A Gentle Popo!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest11() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 11";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 140);
            ps.setString(2, "Hunt A Cute Kelbi!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
		
	}

	@Override
	public void quest12() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 12";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 160);
            ps.setString(2, "Hunt An Annoying Blango!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest20() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 20";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 900);
            ps.setString(2, "Hunt A Predatory Velocidrome!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest21() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 21";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1200);
            ps.setString(2, "Hunt A Stubborn Bulldrome!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest22() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 22";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1500);
            ps.setString(2, "Hunt A Silly Kut-Ku!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest30() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 30";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 1800);
            ps.setString(2, "Hunt A Deceptive Gyperceros!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest31() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 31";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2100);
            ps.setString(2, "Hunt A Lurking Khezu!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest32() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 32";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2100);
            ps.setString(2, "Hunt A Submerged Plesioth!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest40() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 40";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 2400);
            ps.setString(2, "Hunt A Hardened Basarios!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest41() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 41";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 3000);
            ps.setString(2, "Hunt A Graceful Monoblos!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest42() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 42";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 4500);
            ps.setString(2, "Hunt A Revered Kushala Daora!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest50() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 50";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 4200);
            ps.setString(2, "Hunt An Aggressive Diablos!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest51() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 51";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 4500);
            ps.setString(2, "Hunt An Elusive Kirin!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest52() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 52";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 4500);
            ps.setString(2, "Hunt A Fearsome Tigrex!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest60() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 60";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 6000);
            ps.setString(2, "Hunt A Legendary Teostra!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest61() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 61";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 8400);
            ps.setString(2, "Hunt Rathian And Rathalos!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

	@Override
	public void quest62() {
		PreparedStatement ps = null;
        ResultSet rs = null;

        try(Connection con = ConnectionUtil.getConnection())

        {
            String sql = "UPDATE ERS_REIMBURSEMENTS SET R_AMOUNT = ?, R_DESCRIPTION = ? WHERE RT_TYPE = 62";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 9000);
            ps.setString(2, "REPEL LAO-SHAN LUNG!");
            rs = ps.executeQuery();
    
        }catch (SQLException e){
        	e.printStackTrace();
        }finally{
            close(ps);
            close(rs);
        }
	}

}

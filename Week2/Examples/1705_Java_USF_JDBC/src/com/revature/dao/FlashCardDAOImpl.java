package com.revature.dao;

import static com.revature.util.CloseStreams.close;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.revature.pojos.FlashCard;
import com.revature.util.ConnectionUtil;

public class FlashCardDAOImpl implements FlashCardDAO{

	@Override
	public void createFlashCard(FlashCard fc) {
		Statement stmt = null;
		/*
		 * Try-with-resources
		 * -As the name implies, its a try block that uses a resource.
		 * -Only resources that implement auto-closeable may be tried.
		 * -As the interface hints, java will handle the closing of the
		 * -resource itself once execution finishes.
		 */
		try(Connection conn = ConnectionUtil.getConnection();){
			
			String q = fc.getQuestion();
			String a = fc.getAnswer();
			
			String sql = "INSERT INTO flash_cards(fc_question, fc_answer) VALUES ('" +
			q + "', '" + a + "' )";
			
			stmt = conn.createStatement();
			int affected = stmt.executeUpdate(sql);
			
			System.out.println("Rows inserted: " + affected);
			
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(stmt);
		}
		
		
	}

	@Override
	public FlashCard selectFlashCardById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlashCard> selectFlashCards() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFlashCardById(int id) {
		// TODO Auto-generated method stub
		
	}

}

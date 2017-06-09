package com.revature.dao;

import java.util.List;

import com.revature.pojos.FlashCard;

public interface FlashCardDAO {
	
	public void createFlashCard(FlashCard fc);
	public FlashCard selectFlashCardById(int id);
	public List<FlashCard> selectFlashCards();
	public void deleteFlashCardById(int id);
	
	
}

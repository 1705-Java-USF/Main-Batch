package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.example.beans.FlashCard;
import com.example.dao.FlashCardRepository;

@Transactional
public class FlashCardService {
	
	@Autowired
	FlashCardRepository fcDao;
	
	public FlashCard getFlashCardById(Integer id){
		return fcDao.findById(id);
	}
	
	public List<FlashCard> findAllFlashCards(){
		return fcDao.findAll();
	}
}

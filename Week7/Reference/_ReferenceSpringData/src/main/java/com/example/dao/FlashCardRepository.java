package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.beans.FlashCard;


@Repository
public interface FlashCardRepository extends JpaRepository<FlashCard, Integer>{
	public FlashCard findById(Integer id);
	
}

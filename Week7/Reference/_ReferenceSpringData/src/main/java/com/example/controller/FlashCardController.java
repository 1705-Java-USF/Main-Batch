package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.beans.FlashCard;
import com.example.service.FlashCardService;


@RestController
@RequestMapping(value="/flashcard/")
public class FlashCardController {
	
	@Autowired
	FlashCardService fcs;

	@CrossOrigin(origins = {"*"})
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public ResponseEntity<Object> getFlashCardById(@PathVariable("id") Integer id){
		return ResponseEntity.ok(fcs.getFlashCardById(id));
	}
	
	
	@CrossOrigin(origins = {"*"})
	@RequestMapping(value="all", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<FlashCard> getAllFlashCards(){
		return fcs.findAllFlashCards();
	}
	
	
}

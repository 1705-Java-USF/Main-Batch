package com.example.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name ="flash_cards")
public class FlashCard {



	@Id
	@Column(name="fc_id")
	@SequenceGenerator(allocationSize=1,name="flashcardSeq",sequenceName="FC_SEQ")
	@GeneratedValue(generator="flashcardSeq",strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="fc_question")
	private String question;
	
	@Column(name="fc_answer")
	private String answer;
	
	public FlashCard() {
	}

	public FlashCard(Integer id) {
		super();
		this.id = id;
	}

	public FlashCard(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public FlashCard(Integer id, String question, String answer) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
	}


	@Override
	public String toString() {
		return "FlashCard [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
}

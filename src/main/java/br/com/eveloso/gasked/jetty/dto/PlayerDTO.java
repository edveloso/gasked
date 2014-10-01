package br.com.eveloso.gasked.jetty.dto;

import java.util.List;


public class PlayerDTO {
	
	private String name;
	
	private int questionCount;
	
	private List<QuestionDTO> questions;

	public Integer getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	public List<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDTO> questions) {
		this.questions = questions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	
}

package br.com.eveloso.gasked.jetty.dto;

import java.util.Set;


public class PlayerDTO {
	
	private String name;
	
	private int questionCount;
	
	private Set<QuestionDTO> questions;

	public Integer getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	public Set<QuestionDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionDTO> questions) {
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

	@Override
	public String toString() {
		return "PlayerDTO ["
				+ (questions != null ? "questions=" + questions : "") + "]";
	}

	
}

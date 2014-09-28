package br.com.eveloso.gasked.jetty.dto;

import java.util.List;

import br.com.eveloso.gasked.jetty.domain.Question;


public class PartidaDTO {
	
	private Integer questionCount;
	
	private List<Question> questions;

	public Integer getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(Integer questionCount) {
		this.questionCount = questionCount;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}

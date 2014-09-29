package br.com.eveloso.gasked.jetty.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alternative {

	@Id @GeneratedValue
	private Integer id;
	
	private String value;
	
	private Boolean response;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Question question;
	
	public Alternative() {
	}
	
	public Alternative(String value, Boolean response, Question question) {
		super();
		this.value = value;
		this.response = response;
		this.question = question;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Boolean getResponse() {
		return response;
	}

	public void setResponse(Boolean response) {
		this.response = response;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
}

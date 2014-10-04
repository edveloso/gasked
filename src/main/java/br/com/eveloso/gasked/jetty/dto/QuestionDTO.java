package br.com.eveloso.gasked.jetty.dto;

import java.util.List;

public class QuestionDTO implements Comparable<QuestionDTO>{

	private Integer id;
	
	private String description;
	
	private Boolean correctAnswered;

	private List<AlternativeDTO> alternatives;
	
	private CategoryDTO category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getCorrectAnswered() {
		return correctAnswered;
	}

	public void setCorrectAnswered(Boolean correctAnswered) {
		this.correctAnswered = correctAnswered;
	}

	public List<AlternativeDTO> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<AlternativeDTO> alternatives) {
		this.alternatives = alternatives;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "QuestionDTO [" + (id != null ? "id=" + id : "") + "]";
	}

	@Override
	public int compareTo(QuestionDTO o) {
		return this.id.compareTo(o.getId());
	}

	
}

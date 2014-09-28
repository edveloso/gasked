package br.com.eveloso.gasked.jetty.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class Question {

	@Id @GeneratedValue
	private Integer id;
	
	private String description;
	
	@Transient
	private Boolean correctAnswered;

	@OneToMany(mappedBy="question", fetch=FetchType.EAGER)
	@Cascade(value=CascadeType.ALL)
	private List<Alternative> alternatives;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=javax.persistence.CascadeType.ALL)
	private Category category;

	public Question() {
	}
	
	public Question(String description, Category category, List<Alternative> alternatives) {
		super();
		this.description = description;
		this.category = category;
		this.alternatives = alternatives;
	}



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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Alternative> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<Alternative> alternatives) {
		this.alternatives = alternatives;
	}

	public Boolean getCorrectAnswered() {
		return correctAnswered;
	}

	public void setCorrectAnswered(Boolean correctAnswered) {
		this.correctAnswered = correctAnswered;
	}

	@Override
	public String toString() {
		return "Question ["
				+ (id != null ? "id=" + id + ", " : "")
				+ (description != null ? "description=" + description + ", "
						: "")
				+ (correctAnswered != null ? "correctAnswered="
						+ correctAnswered + ", " : "")
				+ (alternatives != null ? "alternatives=" + alternatives + ", "
						: "")
				+ (category != null ? "category=" + category : "") + "]";
	}
	
	

	
}

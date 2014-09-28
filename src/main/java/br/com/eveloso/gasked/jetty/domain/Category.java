package br.com.eveloso.gasked.jetty.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {

	@Id @GeneratedValue
	private Integer id;
	
	private String name;

	public Category() {
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [" + (id != null ? "id=" + id + ", " : "")
				+ (name != null ? "name=" + name : "") + "]";
	}
	
	
	
}

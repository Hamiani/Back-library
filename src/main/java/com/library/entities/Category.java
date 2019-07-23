package com.library.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	@OneToMany(mappedBy="category",fetch=FetchType.LAZY)
	private List<Book> books;
	
	public Long getIdentifiant() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Book> getBooks() {
		return this.books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public Category(String title,String description) {
		this.title = title;
		this.description=description;
	}
	
	public Category(Long id) {
		super();
		this.id = id;
	}
	public Category() {
		super();
	}
	

}

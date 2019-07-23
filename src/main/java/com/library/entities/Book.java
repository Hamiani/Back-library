package com.library.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.library.utils.ConstantsUtils;


@Entity
public class Book {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String description;
	
	private String author;
	
	private Double price;
	
	private String fileName;
	
	@DateTimeFormat(pattern = ConstantsUtils.FORM_DATE_FORMAT)
	private Date publish_date;
	
	@ManyToOne
	@JoinColumn(name="id_cat")
	private Category category;
	
	public Long getIdentifiant() {
		return this.id;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String FileName) {
		this.fileName = FileName;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public Book(String title, String description, String author, Double price, String FileName, Date publish_date,
			Category category) {
		
		this.title = title;
		this.description = description;
		this.author = author;
		this.price = price;
		this.fileName = FileName;
		this.publish_date = publish_date;
		this.category = category;
	}
	
	public Book() {
		super();
	}
	
	
	
}

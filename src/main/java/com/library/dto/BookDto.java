package com.library.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.utils.ConstantsUtils;

public class BookDto {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private String author;
	
	private Double price;
	
	private String fileName;
	
	private String  publishDate;
	
	private Long category_id;
	
	@DateTimeFormat(pattern = ConstantsUtils.FORM_DATE_FORMAT)
	private Date publish_date;
	
	@JsonIgnore
	private MultipartFile file;

	public String getPublishDate() {
		return this.publishDate;
	}


	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	
	
	public Long getCategory_id() {
		return this.category_id;
	}
	
	
	
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
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
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Double getPrice() {
		return this.price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public Date getPublish_date() {
		return this.publish_date;
	}
	
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	
	public MultipartFile getFile() {
		return this.file;
	}
	
	public void setFile(MultipartFile file) {
		this.file = file;
	}	
	
	
	
	
	
}

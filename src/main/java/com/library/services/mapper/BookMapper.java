package com.library.services.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.library.dto.BookDto;
import com.library.entities.Book;
import com.library.entities.Category;


public class BookMapper {

	private static final String DATE_FORMAT = "yyyy-MM-dd";

	public static Book buildNewCommunication(BookDto bookDto) throws ParseException {

		Date publish_date = new SimpleDateFormat(DATE_FORMAT).parse(bookDto.getPublishDate());
		

		return new Book( bookDto.getTitle(),bookDto.getDescription(),bookDto.getAuthor(), bookDto.getPrice(),
				bookDto.getFileName(),publish_date,new Category(bookDto.getCategory_id()) );
	}

	public static void buildCommunicationFromDto(Book book, BookDto bookDto)
			throws ParseException {

		if (book == null || bookDto == null) {
			return;
		}

		book.setTitle(bookDto.getTitle());
		book.setDescription(bookDto.getDescription());
		book.setAuthor(bookDto.getAuthor());
		book.setPrice(bookDto.getPrice());
		book.setFileName(bookDto.getFileName());
		book.setPublish_date(new SimpleDateFormat(DATE_FORMAT).parse(bookDto.getPublishDate()));
		book.setCategory(new Category(bookDto.getCategory_id()));
	}

}
package com.library.services;

import java.text.ParseException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.BookRepository;
import com.library.dto.BookDto;
import com.library.entities.Book;
import com.library.services.mapper.BookMapper;

@Service
public class BookService {
	
	private final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	FileStorageService fileStorageService;
	
	public BookDto saveOrUpdate(BookDto bookDto) throws ParseException {
			
		this.logger.debug("Start storing the book", bookDto);
		
		this.storeImageFile(bookDto);

		this.saveOrUpdateBook(bookDto);

		return bookDto;
	}
	
	private void storeImageFile(BookDto bookDto) {
		if (bookDto.getFile() != null) {

			this.logger.debug("Start store image", bookDto.getFile().getOriginalFilename());

			bookDto.setFileName(
					this.fileStorageService.storeFile(bookDto.getFile(), bookDto.getFileName()));
		}
	}
	
	private Book saveOrUpdateBook(BookDto bookDto) throws ParseException {
		Book book = null;

		if (bookDto.getId() == null || !this.bookRepository.existsById(bookDto.getId())) {
			book = BookMapper.buildNewCommunication(bookDto);

			this.bookRepository.save(book);

		} else {
			book = this.bookRepository.findById(bookDto.getId()).get();
			BookMapper.buildCommunicationFromDto(book, bookDto);

			this.bookRepository.save(book);
		}
		return book;
	}
	
}

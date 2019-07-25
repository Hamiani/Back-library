package com.library.controllers;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import com.library.dto.BookDto;
import com.library.exception.MyFileNotFoundException;
import com.library.exception.MyResourceNotFoundException;
import com.library.services.BookService;
import com.library.services.FileStorageService;




@RestController
public class BookController {	

	private final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;
	
	@Autowired
	FileStorageService fileStorageService;
	
	@PostMapping(value = "/bookResource")
	@ResponseStatus(code = HttpStatus.CREATED)
	public BookDto createBook(@ModelAttribute BookDto bookDto)
			throws ParseException {

		this.logger.debug("REST request to save Book : {}", bookDto);

		if (bookDto.getId() != null) {
			throw new MyResourceNotFoundException("A new Book cannot have an ID");
		}

		return this.bookService.saveOrUpdate(bookDto);
	}
	
	@PutMapping(value = "/bookResource/{book_id}")
	@ResponseStatus(code = HttpStatus.OK)
	public BookDto updateBook(@PathVariable String book_id,
			@ModelAttribute BookDto bookDto) throws ParseException {

		this.logger.debug("REST request to update Book : {}", bookDto);

		bookDto.setId(StringUtils.isEmpty(book_id) ? null : Long.valueOf(book_id));

		if (bookDto.getId() == null) {
			throw new MyResourceNotFoundException("An existing book must have an ID");
		}

		return this.bookService.saveOrUpdate(bookDto);
	}
	
	@GetMapping("/bookResource/download/{fileName:.+}")
	public ResponseEntity<Resource> downloadBookImage(@PathVariable String fileName,
			HttpServletRequest request) throws MyFileNotFoundException {

		// Load file as Resource
		Resource resource = this.fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			this.logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}

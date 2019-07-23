package com.library.dao;

import org.springframework.data.repository.CrudRepository;

import com.library.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long>{

}

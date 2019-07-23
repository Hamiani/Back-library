package com.library.dao;

import org.springframework.data.repository.CrudRepository;

import com.library.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}

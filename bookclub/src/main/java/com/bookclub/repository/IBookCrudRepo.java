package com.bookclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookclub.model.Book;

@Repository
public interface IBookCrudRepo extends CrudRepository<Book, Integer>{
	public Book findByIdBook(Integer idBook);
	
}

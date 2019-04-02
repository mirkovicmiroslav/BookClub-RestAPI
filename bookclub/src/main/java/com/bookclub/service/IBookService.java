package com.bookclub.service;

import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.model.User;

public interface IBookService {	
	
	public List<Book> getAll();
	public Book addBook(Book bookRequest, User userRequest);
	public Book findByIdBook(Integer idBook);
	
}

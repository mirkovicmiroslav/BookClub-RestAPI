package com.bookclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.model.Book;
import com.bookclub.model.User;
import com.bookclub.repository.IBookCrudRepo;

@Service
public class BookService implements IBookService {

	private IBookCrudRepo bcr;

	@Override
	public Book addBook(Book bookRequest, User userRequest) {
		Book book = new Book();
		book.setAuthor(bookRequest.getAuthor());
		book.setTitle(bookRequest.getTitle());
		book.setPublisher(bookRequest.getPublisher());
		book.setDescription(bookRequest.getDescription());
		book.setBookImage(bookRequest.getBookImage());
		book.setUser(userRequest);
		book.setBookCategories(null);
		book.setComments(null);
		
		return bcr.save(book);
	}

	@Override
	public Book findByIdBook(Integer idBook) {
		return bcr.findByIdBook(idBook);
	}

	@Override
	public List<Book> getAll() {
		return (List<Book>) bcr.findAll();
	}

	@Autowired
	public void setBcr(IBookCrudRepo bcr) {
		this.bcr = bcr;
	}

}

package com.bookclub.service;

import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.model.BookCategory;
import com.bookclub.model.Category;

public interface IBookCategoryService {
	
	public BookCategory addBookCategory(Book bookRequest, Category categoryRequest);

	List<String> getBookCategories(Integer idBook);
	
}

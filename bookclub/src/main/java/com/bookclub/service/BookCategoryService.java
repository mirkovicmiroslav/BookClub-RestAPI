package com.bookclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.model.Book;
import com.bookclub.model.BookCategory;
import com.bookclub.model.Category;
import com.bookclub.repository.IBookCategoryCrudRepo;

@Service
public class BookCategoryService implements IBookCategoryService {

	IBookCategoryCrudRepo bookCategoryRepo;

	@Override
	public BookCategory addBookCategory(Book bookRequest, Category categoryRequest) {
		BookCategory bookCategory = new BookCategory();
		bookCategory.setBook(bookRequest);
		bookCategory.setCategory(categoryRequest);

		return bookCategoryRepo.save(bookCategory);
	}
	
	@Override
	public List<String> getBookCategories(Integer idBook){
		return bookCategoryRepo.getBookCategories(idBook);
	}

	@Autowired
	public void setBookCategoryRepo(IBookCategoryCrudRepo bookCategoryRepo) {
		this.bookCategoryRepo = bookCategoryRepo;
	}

}

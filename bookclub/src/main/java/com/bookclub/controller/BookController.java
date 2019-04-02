package com.bookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookclub.model.Book;
import com.bookclub.model.BookCategory;
import com.bookclub.model.Category;
import com.bookclub.model.Comment;
import com.bookclub.model.User;
import com.bookclub.service.IBookCategoryService;
import com.bookclub.service.IBookService;
import com.bookclub.service.ICategoryService;
import com.bookclub.service.ICommentService;
import com.bookclub.service.IUserService;

@RestController
@RequestMapping("/book")
public class BookController {

	private IBookService bookService;
	private ICommentService commentService;
	private IUserService userService;
	private IBookCategoryService bookCategoryService;
	private ICategoryService categoryService;

	@ResponseBody
	@GetMapping("/getBook/{idBook}")
	public Book getBook(@PathVariable("idBook") Integer idBook) {
		return bookService.findByIdBook(idBook);
	}

	@ResponseBody
	@PostMapping("/addComment/{idUser}/{idBook}")
	public Comment addComment(@RequestBody Comment commentRequest, @PathVariable("idUser") Integer idUser,
			@PathVariable("idBook") Integer idBook) {
		return commentService.addComment(commentRequest, userService.findByIdUser(idUser),
				bookService.findByIdBook(idBook));
	}

	@ResponseBody
	@GetMapping("/getAllComments/{idBook}")
	public List<Comment> getAllComments(@PathVariable("idBook") Integer idBook) {
		return commentService.getAll(idBook);
	}

	@ResponseBody
	@PostMapping("/addBook/{idUser}")
	public Book addBook(@RequestBody Book bookRequest, @PathVariable("idUser") Integer idUser) {
		User userkRequest = userService.findByIdUser(idUser);
		return bookService.addBook(bookRequest, userkRequest);
	}

	@ResponseBody
	@PostMapping("/addBookCategory/{idCategory}")
	public BookCategory addBookCategory(@PathVariable Integer idCategory, @RequestBody Book bookRequest) {
		Category category = categoryService.findByIdCategory(idCategory);

		return bookCategoryService.addBookCategory(bookRequest, category);
	}

	@ResponseBody
	@GetMapping("/getBookCategories/{idBook}")
	public List<String> getBookCategories(@PathVariable("idBook") Integer idBook) {
		return bookCategoryService.getBookCategories(idBook);
	}

	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@Autowired
	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setBookCategoryService(IBookCategoryService bookCategoryService) {
		this.bookCategoryService = bookCategoryService;
	}

	@Autowired
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

}

package com.bookclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookclub.model.Book;
import com.bookclub.model.Category;
import com.bookclub.model.User;
import com.bookclub.service.IBookService;
import com.bookclub.service.ICategoryService;
import com.bookclub.service.IUserService;

@RestController
@RequestMapping("/")
public class RootController {

	private IUserService userService;
	private IBookService bookService;
	private ICategoryService categoryService;

	@ResponseBody
	@GetMapping("/")
	public List<Book> getAllBooks() {
		return bookService.getAll();
	}

	@ResponseBody
	@PostMapping("/register")
	public User addUser(@RequestBody User userRequest) {
		return userService.addUser(userRequest);
	}
	
	@ResponseBody
	@PutMapping("/updateUser/{idUser}")
	public User updateUser(@RequestBody User userRequest, @PathVariable("idUser") Integer idUser) {
		return userService.updateUser(userRequest, idUser);
	}
	
	@ResponseBody
	@GetMapping("/getUserByEmail/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		return userService.findByEmail(email);
	}
	
	@ResponseBody
	@GetMapping("/getUserById/{idUser}")
	public User getUserById(@PathVariable("idUser") Integer idUser) {
		return userService.findByIdUser(idUser);
	}

	@ResponseBody
	@GetMapping("/getAllCategories")
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}
	
	@ResponseBody
	@GetMapping("/getCategoryIdByName/{name}")
	public Integer getCategoryIdByName(@PathVariable("name") String name) {
		return categoryService.getCategoryIdByName(name);
	}

	@Autowired
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@Autowired
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

}

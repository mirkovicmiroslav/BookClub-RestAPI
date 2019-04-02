package com.bookclub.service;

import java.util.List;

import com.bookclub.model.Category;

public interface ICategoryService {

	public List<Category> getAllCategories();

	public Category findByIdCategory(Integer idCategory);

	public Integer getCategoryIdByName(String name);

}

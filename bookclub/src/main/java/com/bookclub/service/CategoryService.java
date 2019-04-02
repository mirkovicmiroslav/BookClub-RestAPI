package com.bookclub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.model.Category;
import com.bookclub.repository.ICategoryCrudRepo;

@Service
public class CategoryService implements ICategoryService {

	private ICategoryCrudRepo ccr;

	@Override
	public List<Category> getAllCategories() {
		return (List<Category>) ccr.findAll();
	}
	
	@Override
	public Category findByIdCategory(Integer idCategory) {
		return ccr.findByIdCategory(idCategory);
	}
	
	@Override
	public Integer getCategoryIdByName(String name) {
		return ccr.findCategoryIdByName(name);
	}
	
	@Autowired
	public void setCcr(ICategoryCrudRepo ccr) {
		this.ccr = ccr;
	}

}

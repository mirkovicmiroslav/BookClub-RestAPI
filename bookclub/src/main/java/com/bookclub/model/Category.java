package com.bookclub.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category")
	private int idCategory;

	private String name;

	//bi-directional many-to-one association to BookCategory
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<BookCategory> bookCategories;

	public Category() {
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookCategory> getBookCategories() {
		return this.bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public BookCategory addBookCategory(BookCategory bookCategory) {
		getBookCategories().add(bookCategory);
		bookCategory.setCategory(this);

		return bookCategory;
	}

	public BookCategory removeBookCategory(BookCategory bookCategory) {
		getBookCategories().remove(bookCategory);
		bookCategory.setCategory(null);

		return bookCategory;
	}

}
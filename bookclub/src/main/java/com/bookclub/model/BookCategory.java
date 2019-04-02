package com.bookclub.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the book_category database table.
 * 
 */
@Entity
@Table(name="book_category")
@NamedQuery(name="BookCategory.findAll", query="SELECT b FROM BookCategory b")
public class BookCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_book_category")
	private int idBookCategory;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="id_book")
	private Book book;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;

	public BookCategory() {
	}

	public int getIdBookCategory() {
		return this.idBookCategory;
	}

	public void setIdBookCategory(int idBookCategory) {
		this.idBookCategory = idBookCategory;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
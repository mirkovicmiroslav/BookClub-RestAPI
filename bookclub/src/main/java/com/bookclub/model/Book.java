package com.bookclub.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@Table(name="book")
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_book")
	private int idBook;

	private String author;

	@Lob
	@Column(name="book_image")
	private byte[] bookImage;

	private String publisher;
	
	private String description;

	private String title;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;

	//bi-directional many-to-one association to BookCategory
	@JsonIgnore
	@OneToMany(mappedBy="book")
	private List<BookCategory> bookCategories;

	//bi-directional many-to-one association to Comment
	@JsonIgnore
	@OneToMany(mappedBy="book")
	private List<Comment> comments;

	public Book() {
	}

	public int getIdBook() {
		return this.idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public byte[] getBookImage() {
		return this.bookImage;
	}

	public void setBookImage(byte[] bookImage) {
		this.bookImage = bookImage;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BookCategory> getBookCategories() {
		return this.bookCategories;
	}

	public void setBookCategories(List<BookCategory> bookCategories) {
		this.bookCategories = bookCategories;
	}

	public BookCategory addBookCategory(BookCategory bookCategory) {
		getBookCategories().add(bookCategory);
		bookCategory.setBook(this);

		return bookCategory;
	}

	public BookCategory removeBookCategory(BookCategory bookCategory) {
		getBookCategories().remove(bookCategory);
		bookCategory.setBook(null);

		return bookCategory;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setBook(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setBook(null);

		return comment;
	}

}
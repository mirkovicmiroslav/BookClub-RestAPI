package com.bookclub.service;

import java.util.List;

import com.bookclub.model.Book;
import com.bookclub.model.Comment;
import com.bookclub.model.User;

public interface ICommentService {

	public Comment addComment(Comment commentRequest, User userRequest, Book bookRequest);

	public List<Comment> getAll(int idBook);

}

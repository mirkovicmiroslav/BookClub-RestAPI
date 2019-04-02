package com.bookclub.service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.model.Book;
import com.bookclub.model.Comment;
import com.bookclub.model.User;
import com.bookclub.repository.ICommentCrudRepo;

@Service
public class CommentService implements ICommentService {

	private ICommentCrudRepo ccr;

	@Override
	public Comment addComment(Comment commentRequest, User userRequest, Book bookRequest) {
		commentRequest.setDateTime(new Date());
		commentRequest.setUser(userRequest);
		commentRequest.setBook(bookRequest);
		return ccr.save(commentRequest);
	}
	
	@Override
	public List<Comment> getAll(int idBook) {
		return ccr.findAllByIdBook(idBook).stream().sorted(Comparator.comparing(Comment::getDateTime).reversed()).collect(Collectors.toList());
	}
	
	@Autowired
	public void setKcr(ICommentCrudRepo ccr) {
		this.ccr = ccr;
	}

}

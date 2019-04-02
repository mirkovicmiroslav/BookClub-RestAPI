package com.bookclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookclub.model.Comment;

@Repository
public interface ICommentCrudRepo extends CrudRepository<Comment, Integer> {
	
	@Query("SELECT c FROM Comment c WHERE c.book.idBook =:bookId")
	List<Comment> findAllByIdBook(@Param("bookId") int idBook);

}

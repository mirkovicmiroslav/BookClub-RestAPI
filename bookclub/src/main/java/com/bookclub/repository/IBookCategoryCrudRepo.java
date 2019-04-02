package com.bookclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookclub.model.BookCategory;

@Repository
public interface IBookCategoryCrudRepo extends CrudRepository<BookCategory, Integer> {
	
	@Query("SELECT bk.category.name FROM BookCategory bk WHERE bk.book.idBook =:idBook")
	List<String> getBookCategories(@Param("idBook") Integer idBook);
	
}

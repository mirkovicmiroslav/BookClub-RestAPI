package com.bookclub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookclub.model.Category;

@Repository
public interface ICategoryCrudRepo extends CrudRepository<Category, Integer> {

	@Query("SELECT c FROM Category c WHERE c.idCategory =:idCategory")
	Category findByIdCategory(@Param("idCategory") Integer idCategory);
	
	@Query("SELECT c.idCategory FROM Category c WHERE c.name LIKE :nameCat")
	Integer findCategoryIdByName(@Param("nameCat") String name);

}

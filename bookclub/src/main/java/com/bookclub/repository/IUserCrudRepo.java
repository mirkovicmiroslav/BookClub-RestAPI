package com.bookclub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bookclub.model.User;

@Repository
public interface IUserCrudRepo extends CrudRepository<User, Integer> {
	public User findByEmail(String email);
	public User findByIdUser(Integer idUser);
	
}

package com.bookclub.service;

import com.bookclub.model.User;

public interface IUserService {
	
	public User addUser(User userRequest);
	public User findByEmail(String email);
	public User findByIdUser(Integer idUser);
	public User updateUser(User userRequest, Integer idUser);
}

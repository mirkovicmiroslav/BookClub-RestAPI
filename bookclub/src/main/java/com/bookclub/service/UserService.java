package com.bookclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookclub.model.User;
import com.bookclub.repository.IUserCrudRepo;

@Service
public class UserService implements IUserService {

	private IUserCrudRepo ucr;

	@Override
	public User addUser(User userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setUserImage(null);

		return ucr.save(user);
	}

	@Override
	public User findByEmail(String email) {
		return ucr.findByEmail(email);
	}

	@Override
	public User findByIdUser(Integer idUser) {
		return ucr.findByIdUser(idUser);
	}

	@Override
	public User updateUser(User userRequest, Integer idUser) {
		User user = findByIdUser(idUser);
		user.setName(userRequest.getName());
		user.setLastName(userRequest.getLastName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setUserImage(userRequest.getUserImage());
		
		return ucr.save(user);
	}

	@Autowired
	public void setUcr(IUserCrudRepo ucr) {
		this.ucr = ucr;
	}

}

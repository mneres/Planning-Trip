package com.planning.service;

import java.util.List;

import com.planning.model.User;

public interface UserService {
	User addUser(User user);
	
	User updateUser(User user);
	
	void deleteUser(Integer id);
	
	List<User> listAll();
	
	User findOneByEmail(String email);
}

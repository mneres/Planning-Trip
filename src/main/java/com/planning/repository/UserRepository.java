package com.planning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.planning.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findOneByEmail(String email);
}

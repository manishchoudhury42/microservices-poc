package com.microservice.userService.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.microservice.userService.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	@Procedure(name="microservices.get_n_users")
	List<User> get_n_users(int n);
	
	@Procedure(name="microservices.insertUser")
	void insertUser(String name, int age);
}

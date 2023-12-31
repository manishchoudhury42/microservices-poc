package com.microservice.userService.services;

import java.util.*;

import com.microservice.userService.entities.User;

public interface UserService {

	//user operations
	
	//create user
	User saveUser(User user);
	
	//get all the users
	List<User> getAllUser();
	
	//get user from userId
	User getUser(String userId);
	
	//delete user by id
	User deleteUser(String userId);
	
	
	//Procedure calls from Springboot
	
	List<User> getNUsers(int n);
	
	void insertUser(String name, int age);
	
	//TODO: update
	
	
}

package com.microservice.userService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.userService.entities.User;
import com.microservice.userService.exceptions.ResourceNotFoundException;
import com.microservice.userService.repositories.UserRepository;
import com.microservice.userService.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		//generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id was not found. userId: "+ userId));
	}

	@Override
	public User deleteUser(String userId) {
		
		User deleteUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user with given id was not found. userId: "+ userId));
		userRepository.deleteById(userId);
		return deleteUser;
	}

}

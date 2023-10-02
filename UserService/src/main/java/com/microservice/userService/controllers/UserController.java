package com.microservice.userService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userService.entities.User;
import com.microservice.userService.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	// create user
	@PostMapping
	ResponseEntity<User> createUser(@RequestBody User user) {
		User savedUser = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}

	// get all users
	@GetMapping
	ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUser();
		return ResponseEntity.ok(users);
	}

	// get user by id
	@GetMapping("/{id}")
	ResponseEntity<User> getUserById(@PathVariable String id) {
		User getUser = userService.getUser(id);
		return ResponseEntity.ok(getUser);
	}

	// delete user by id
	@DeleteMapping("/{id}")
	ResponseEntity<User> deleteUserById(@PathVariable String id) {
		User deletedUser = userService.deleteUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(deletedUser);
	}

	// get n users ----- procedure call
	@GetMapping("/test/{n}")
	ResponseEntity<List<User>> getNUsers(@PathVariable int n) {
		List<User> nUsers = this.userService.getNUsers(n);
		return ResponseEntity.ok(nUsers);
	}

	// insert into another table --- procedure call
	@PostMapping("/test")
	ResponseEntity<String> insertUser(@RequestParam String name, @RequestParam int age) {
		this.userService.insertUser(name, age);
		return ResponseEntity.ok("Inserted into table");
	}

}

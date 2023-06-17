package com.microservice.userService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.userService.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}

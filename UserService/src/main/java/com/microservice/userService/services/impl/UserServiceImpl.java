package com.microservice.userService.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.userService.entities.Hotel;
import com.microservice.userService.entities.Rating;
import com.microservice.userService.entities.User;
import com.microservice.userService.exceptions.ResourceNotFoundException;
import com.microservice.userService.external.services.HotelService;
import com.microservice.userService.repositories.UserRepository;
import com.microservice.userService.services.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	HotelService hotelService;

	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		// generate unique userId
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

		User user = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("user with given id was not found. userId: " + userId));

		// fetch ratings of the above user from rating service

		String url = "http://RATING-SERVICE/ratings/users/" + userId;
		Rating[] ratingsOfUser = restTemplate.getForObject(url, Rating[].class);

		List<Rating> ratingList = Arrays.stream(ratingsOfUser).map(rating -> {

			// api call to hotel service to get the hotel
//			String url2 = "http://HOTEL-SERVICE/hotels/" + rating.getHotelId();
//			Hotel hotel = restTemplate.getForObject(url2, Hotel.class);

			// api call using feign client
			Hotel hotel = hotelService.getHotel(rating.getHotelId());

			// set the hotel to rating
			rating.setHotel(hotel);

			// return the rating
			return rating;

		}).collect(Collectors.toList());
		logger.info("{}", ratingList);

		user.setRatings(ratingList);

		return user;
	}

	@Override
	public User deleteUser(String userId) {

		User deleteUser = userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("user with given id was not found. userId: " + userId));
		userRepository.deleteById(userId);
		return deleteUser;
	}

	
	@Override
	public List<User> getNUsers(int n) {
		
		List<User> nUser= this.userRepository.get_n_users(n);
		
		return nUser;
	}

	@Override
	public void insertUser(String name, int age) {
		// TODO Auto-generated method stub
		this.userRepository.insertUser(name, age);
	}

}

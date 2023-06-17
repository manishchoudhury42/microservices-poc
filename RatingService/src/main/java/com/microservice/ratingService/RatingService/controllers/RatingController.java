package com.microservice.ratingService.RatingService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.ratingService.RatingService.entities.Rating;
import com.microservice.ratingService.RatingService.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService service;

	// create
	@PostMapping
	ResponseEntity<Rating> saveRating(@RequestBody Rating rating) {

		Rating savedRating = service.saveRating(rating);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedRating);
	}

	// get all
	@GetMapping
	ResponseEntity<List<Rating>> getAllRatings() {

		List<Rating> listOfRatings = service.getAllRatings();
		return ResponseEntity.ok(listOfRatings);
	}

	// get by userId
	@GetMapping("users/{userId}")
	ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {

		List<Rating> userRatings = service.getRatingByUserId(userId);
		return ResponseEntity.ok(userRatings);
	}

	// get by hotelId
	@GetMapping("/hotels/{hotelId}")
	ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {

		List<Rating> hotelRatings = service.getRatingByHotelId(hotelId);
		return ResponseEntity.ok(hotelRatings);
	}

}

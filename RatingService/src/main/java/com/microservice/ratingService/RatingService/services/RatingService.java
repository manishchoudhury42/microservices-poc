package com.microservice.ratingService.RatingService.services;

import java.util.List;

import com.microservice.ratingService.RatingService.entities.Rating;

public interface RatingService {

	// create
	Rating saveRating(Rating rating);

	// get all
	List<Rating> getAllRatings();	
	
	//get all by hotelId
	List<Rating> getRatingByUserId(String userId);
	
	//get all by userId
	List<Rating> getRatingByHotelId(String hotelId);
}

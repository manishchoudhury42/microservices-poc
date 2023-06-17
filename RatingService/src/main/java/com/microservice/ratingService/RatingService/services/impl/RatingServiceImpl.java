package com.microservice.ratingService.RatingService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.ratingService.RatingService.entities.Rating;
import com.microservice.ratingService.RatingService.repositories.RatingRepository;
import com.microservice.ratingService.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepository repository;
	
	@Override
	public Rating saveRating(Rating rating) {
		
		return repository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		
		return repository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return repository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return repository.findByHotelId(hotelId);
	}

	
}

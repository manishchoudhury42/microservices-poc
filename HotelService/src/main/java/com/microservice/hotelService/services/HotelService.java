package com.microservice.hotelService.services;

import java.util.List;

import com.microservice.hotelService.entities.Hotel;

public interface HotelService {

	//create 
	Hotel createHotel(Hotel hotel);
	
	//get all
	List<Hotel> getAllHotels();
	
	//get single hotel
	Hotel getHotel(String hotelId);
	
}

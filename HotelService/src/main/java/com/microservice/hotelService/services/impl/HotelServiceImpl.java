package com.microservice.hotelService.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotelService.entities.Hotel;
import com.microservice.hotelService.exceptions.ResourceNotFoundException;
import com.microservice.hotelService.repositories.HotelRepository;
import com.microservice.hotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setHotelId(id);
		
		Hotel createdHotel = hotelRepository.save(hotel);
		return createdHotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> listOfHotels = hotelRepository.findAll();
		return listOfHotels;
	}

	@Override
	public Hotel getHotel(String hotelId) {
		Hotel foundHotel = hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found. hotelId: " + hotelId));
		return foundHotel;
	}
	
	
}

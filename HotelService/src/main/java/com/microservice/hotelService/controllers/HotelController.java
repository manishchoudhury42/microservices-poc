package com.microservice.hotelService.controllers;

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

import com.microservice.hotelService.entities.Hotel;
import com.microservice.hotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	HotelService service;
	
	@GetMapping("/{hotelId}")
	ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		Hotel foundHotel = service.getHotel(hotelId);
		return ResponseEntity.ok(foundHotel);
	}
	
	@PostMapping
	ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createdHotel = service.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdHotel);
	}
	
	@GetMapping
	ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotels = service.getAllHotels();
		
		return ResponseEntity.ok(hotels);
		
	}

}

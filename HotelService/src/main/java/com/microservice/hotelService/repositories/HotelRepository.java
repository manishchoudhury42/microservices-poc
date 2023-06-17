package com.microservice.hotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.hotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}

package com.microservice.hotelService.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> notFoundHandler(ResourceNotFoundException ex){
		Map<String,Object> apiResponse = new HashMap<>();
		apiResponse.put("message", ex.getMessage());
		apiResponse.put("success", false);
		apiResponse.put("status", HttpStatus.NOT_FOUND);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
	}
}

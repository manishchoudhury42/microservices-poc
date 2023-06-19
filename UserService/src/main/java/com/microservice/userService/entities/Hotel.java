 package com.microservice.userService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

	String hotelId;
	String name;
	String location;
	String about;

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", location=" + location + ", about=" + about + "]";
	}
	
}

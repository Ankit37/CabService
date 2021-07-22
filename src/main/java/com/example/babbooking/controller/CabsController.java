package com.example.babbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.babbooking.database.CabsManager;
import com.example.babbooking.database.TripsManager;
import com.example.babbooking.model.Cab;
import com.example.babbooking.model.Location;

@RestController
public class CabsController {

	@Autowired 
	private CabsManager cabsManager;
	@Autowired
	private TripsManager tripsManager;
	
	
	@PostMapping("/register/cab")
	public ResponseEntity registerCab(final String cabId, final String driverName)
	{
		cabsManager.createCab(new Cab(cabId, driverName));
		return ResponseEntity.ok("");
				
	}
	
	@PostMapping("/update/cab/location")
	public ResponseEntity updateCabLocation(
			final String cabId, final Double newX, final double newY)
	{
		cabsManager.updateCabLocation(cabId, new Location(newX, newY));
		return ResponseEntity.ok("");
	}
	
	
	@PostMapping("/update/cab/availability")
	public ResponseEntity updateCabAvailability(final String cabId, final Boolean newAvailability)
	{
		cabsManager.updateCabavalability(cabId, newAvailability);
		return ResponseEntity.ok("");
	}
	
	
	
	
	
}

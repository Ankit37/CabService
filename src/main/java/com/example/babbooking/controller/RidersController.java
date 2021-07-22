package com.example.babbooking.controller;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.babbooking.database.RiderManager;
import com.example.babbooking.database.TripsManager;
import com.example.babbooking.model.Location;
import com.example.babbooking.model.Rider;

@RestController
public class RidersController {

	private RiderManager riderManager;
	private TripsManager tripsManager;

	public RidersController(RiderManager riderManager, TripsManager tripsManager) {
		super();
		this.riderManager = riderManager;
		this.tripsManager = tripsManager;
	}

	@PostMapping("/register/rider")
	public ResponseEntity registerRider(final String riderId, final String riderName) {
		riderManager.createRider(new Rider(riderId, riderName));
		return ResponseEntity.ok(" ");
	}

	public ResponseEntity Book(final String riderId, final double sourceX, final double sourceY, final double destX,
			final double destY) {
		tripsManager.createTrip(riderManager.getRider(riderId), new Location(sourceX, sourceY),
				new Location(destX, destY));
		return ResponseEntity.ok("");

	}

}

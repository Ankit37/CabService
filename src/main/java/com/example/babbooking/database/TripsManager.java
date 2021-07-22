package com.example.babbooking.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.babbooking.exception.NoCabsAvalaibleException;
import com.example.babbooking.exception.TripNotFoundException;
import com.example.babbooking.model.Cab;
import com.example.babbooking.model.Location;
import com.example.babbooking.model.Rider;
import com.example.babbooking.model.Trip;
import com.example.babbooking.startegy.CabMatchingStrategy;
import com.example.babbooking.startegy.PricingStrategy;

@Service
public class TripsManager {

	public final static Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
	private Map<String, List<Trip>> trips = new HashMap();

	@Autowired	
	private CabsManager cabsManager;
	@Autowired
	private RiderManager ridersManager;
	@Autowired
	private CabMatchingStrategy cabMatchingStrategy;
	@Autowired
	private PricingStrategy pricingStrategy;

	
	  public TripsManager(CabsManager cabsManager, RiderManager ridersManager,
	  CabMatchingStrategy cabMatchingStrategy, PricingStrategy pricingStrategy) {
	  super(); this.cabsManager = cabsManager; this.ridersManager = ridersManager;
	  this.cabMatchingStrategy = cabMatchingStrategy; this.pricingStrategy =
	  pricingStrategy; }
	 

	public void createTrip(@NonNull final Rider rider, @NonNull final Location fromPoint,
			@NonNull final Location toPoint) {
		final List<Cab> closeByCabs = cabsManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);

		final Optional<Cab> selectedCabopt = cabMatchingStrategy.matchCabToRider(rider, closeByCabs, fromPoint,
				toPoint);
		if (!selectedCabopt.isPresent()) {
			throw new NoCabsAvalaibleException();
		}

		final Cab selectedCab = selectedCabopt.get();
		final double price = pricingStrategy.findPrice(fromPoint, toPoint);
		final Trip newTrip = new Trip(rider, selectedCab,price, fromPoint, toPoint);
		if (!trips.containsKey(rider.getRiderId())) {
			trips.put(rider.getRiderId(), new ArrayList<>());
		}
		trips.get(rider.getRiderId()).add(newTrip);
		selectedCab.setCurrentTrip(newTrip);

	}

	public List<Trip> tripHistory(@NonNull final Rider rider) {
		return trips.get(rider.getRiderId());
	}

	public void endTrip(@NonNull final Cab cab) {
		if (cab.getCurrentTrip() == null) {
			throw new TripNotFoundException();

		}
		((Trip) cab.getCurrentTrip()).endTrip();
		cab.setCurrentTrip(null);

	}

}

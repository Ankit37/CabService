package com.example.babbooking.startegy;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.babbooking.model.Cab;
import com.example.babbooking.model.Location;
import com.example.babbooking.model.Rider;

@Service
public class DefaultCabMatchingStrategy  implements CabMatchingStrategy{

	@Override
	public Optional<Cab> matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint) {
		// TODO Auto-generated method stub
		return candidateCabs.stream().filter(cab->cab.getCurrentTrip()==null).findAny();
	}

	
	
}

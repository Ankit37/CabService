package com.example.babbooking.startegy;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.babbooking.model.Cab;
import com.example.babbooking.model.Location;
import com.example.babbooking.model.Rider;

@Component
public interface CabMatchingStrategy {

	Optional<Cab> matchCabToRider(Rider rider, List<Cab> closeByCabs, Location fromPoint, Location toPoint);

}

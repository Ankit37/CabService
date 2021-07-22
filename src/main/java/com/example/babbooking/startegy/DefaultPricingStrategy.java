package com.example.babbooking.startegy;

import org.springframework.stereotype.Service;

import com.example.babbooking.model.Location;

@Service
public class DefaultPricingStrategy implements PricingStrategy {

	public static final double PER_KM_RATE = 10.0;

	@Override
	public double findPrice(Location fromPoint, Location toPoint) {
		// TODO Auto-generated method stub
		return fromPoint.distance(toPoint) * PER_KM_RATE;
	}

}

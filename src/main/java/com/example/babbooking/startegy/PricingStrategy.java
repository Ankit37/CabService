package com.example.babbooking.startegy;

import org.springframework.stereotype.Component;

import com.example.babbooking.model.Location;

@Component
public interface PricingStrategy {

	double findPrice(Location fromPoint, Location toPoint);
}

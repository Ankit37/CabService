package com.example.babbooking.model;

import org.springframework.lang.NonNull;

enum TripStatus{
	IN_PROGRESS,
	FINISHED
}

public class Trip {

	private Rider rider;
	private Cab cab;
	private TripStatus status;
	private Double price;
	private Location fromPoint;
	private Location toPoint;

	public Trip(@NonNull Rider rider, @NonNull Cab cab, @NonNull Double price,
			@NonNull Location fromPoint, @NonNull Location toPoint) {
		super();
		this.rider = rider;
		this.cab = cab;
		this.status = status.IN_PROGRESS;
		this.price = price;
		this.fromPoint = fromPoint;
		this.toPoint = toPoint;
	}

	@Override
	public String toString() {
		return "Trip [rider=" + rider + ", cab=" + cab + ", status=" + status + ", price=" + price + ", fromPoint="
				+ fromPoint + ", toPoint=" + toPoint + "]";
	}

	public void endTrip()
	{
		this.status= status.FINISHED;
	}
	
	
}

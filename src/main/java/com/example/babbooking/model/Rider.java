package com.example.babbooking.model;

public class Rider {

	private String riderId;
	private String riderName;

	public Rider(String riderId, String riderName) {
		super();
		this.riderId = riderId;
		this.riderName = riderName;
	}

	public String getRiderId() {
		return riderId;
	}

	public String getRiderName() {
		return riderName;
	}

	@Override
	public String toString() {
		return "Rider [riderId=" + riderId + ", riderName=" + riderName + "]";
	}

}

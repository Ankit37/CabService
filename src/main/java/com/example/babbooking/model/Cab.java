package com.example.babbooking.model;

public class Cab {

	private String cabId;
	private String driverName;

	private Trip currentTrip;
	private Location location;
	private Boolean isAvailable;

	
	
	
	public Cab(String cabId, String driverName) {
		super();
		this.cabId = cabId;
		this.driverName = driverName;
		this.isAvailable = true;
	}

	public void setCurrentTrip(Trip currentTrip) {
		this.currentTrip = currentTrip;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getCabId() {
		return cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}


	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", driverName=" + driverName + ", currentTrip=" + currentTrip + ", location="
				+ location + ", isAvailable=" + isAvailable + "]";
	}

	public Trip getCurrentTrip() {
		return currentTrip;
	}

	public Location getLocation() {
		return location;
	}

	public Boolean getIsAvailable() {
		return isAvailable;
	}



}

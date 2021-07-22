package com.example.babbooking.model;



public class Location {

	private double destX;
	private double destY;

	public double getDestX() {
		return destX;
	}


	public double getDestY() {
		return destY;
	}

	public Location(double destX, double destY) {
		super();
		this.destX = destX;
		this.destY = destY;
	}


	@Override
	public String toString() {
		return "Location [destX=" + destX + ", destY=" + destY + "]";
	}



	public Double distance(Location location2)
	{
		return Math.sqrt(Math.pow(this.destX-location2.destX,2)+Math.pow(this.destY-location2.destY,2));
	}

}

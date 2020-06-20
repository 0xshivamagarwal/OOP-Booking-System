/*	This class implements the following specification from the Rubrik
*	1. 	Heirarchial Inheritance x 1
*	2. 	Static Nested Classes x 2 (Line 11,21)
*	3. 	Constructor Overloading x 1  (Line 39)
*	4.	Method Overriding x 1 (Line 67)
*	5. 	Wrappers - Double
*/
package Automotives;

public class Taxi extends Vehicle {
	
	//Static Nested Class
	
	public static class ACTaxi {
		private Double rate = 15.0;
		public Double getRate() {
			return this.rate;
		}
		public void setRate(Double rate) {
			this.rate = rate;
		}
	}

	public static class NonACTaxi {
		private Double rate = 10.0;
		public Double getRate() {
			return this.rate;
		}
		public void setRate(Double rate) {
			this.rate = rate;
		}
	}

	public boolean isAvailable;//True if taxi is empty

	/*
	*	Constructor Overloading
	*/
	
	public Taxi(String vehicleID, String companyName, String source, String startTime) {
		super(vehicleID, companyName, source, null, startTime, null, true);
		this.isAvailable = true;
		this.source = source;
	}

	public Taxi(String vehicleID, String companyName, String source, String startTime, boolean ac) {
		super(vehicleID, companyName, source, null, startTime, null, ac);
		this.isAvailable = true;
		this.source = source;
	}

	public boolean getIsAvailable() {//Return true if taxi is available
		return this.isAvailable;
	}

	public void offloadTaxi() {// Offload from the taxi
		this.isAvailable = true;
	}

	public Double getFare(int duration) {//Get fare of taxi
		if (this.ac) {
			return new ACTaxi().getRate() * duration;
		}
		return new NonACTaxi().getRate() * duration;
	}

	@Override
	public boolean bookSeats(int duration) {//Book seats
		if (this.isAvailable) {
			this.isAvailable = false;
			System.out.println("Fare: " + this.getFare(duration));
			return true;
		}
		return false;
	}
	
}

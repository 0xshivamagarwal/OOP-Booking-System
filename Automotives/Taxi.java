package Automotives;

public class Taxi extends Vehicle {
	
	public static class ACTaxi {
		private double rate = 15;
		public double getRate() {
			return this.rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
	}

	public static class NonACTaxi {
		private double rate = 10;
		public double getRate() {
			return this.rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
	}

	public boolean isAvailable;
	
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

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void offloadTaxi() {
		this.isAvailable = true;
	}

	public double getFare(int duration) {
		if (this.ac) {
			return new ACTaxi().getRate() * duration;
		}
		return new NonACTaxi().getRate() * duration;
	}

	@Override
	public boolean bookSeats(int duration) {
		if (this.isAvailable) {
			this.isAvailable = false;
			System.out.println("Fare: " + this.getFare(duration));
			return true;
		}
		return false;
	}
	
}

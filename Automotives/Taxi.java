package Automotives;

public class Taxi extends Vehicle {
	
	public static class ACTaxi {
		
		private int rate = 15;
		
		public int getRate() {
			return this.rate;
		}

		public void setRate(int rate) {
			this.rate = rate;
		}

	}

	public static class NonACTaxi {

		private int rate = 10;
		
		public int getRate() {
			return this.rate;
		}

		public void setRate(int rate) {
			this.rate = rate;
		}
		
	}

	public boolean isAvailable;
	
	public Taxi(String vehicleID, String cityName) {
		super(cityName, vehicleID, true);
		this.isAvailable = true;
	}

	public Taxi(String vehicleID, String cityName, boolean ac) {
		super(cityName, vehicleID, ac);
		this.isAvailable = true;
	}

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void offloadTaxi() {
		this.isAvailable = true;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public String getVehicleID() {
		return this.vehicleID;
	}

	public int getFare(int distance) {
		if(this.ac) {
			return ACTaxi.getRate() * distance;
		}
		return new NonACTaxi().getRate() * distance;
	}

	public void bookTaxi(int distance) {
		if(this.isAvailable) {
			this.isAvailable = false;
			System.out.println("The taxi is booked");
			System.out.println("Your fare is " + this.getFare(distance));
		} else {
			System.out.println("Taxi not available");
		}
	}
}

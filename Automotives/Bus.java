package Automotives;

public class Bus extends Vehicle {

	public static class ACBus {
		private int rate = 500;

		public int getRate() {
			return this.rate;
		}

		public void setRate(int rate) {
			this.rate = rate;
		}
	}

	public class NonACBus {
		private int rate = 250;

		public int getRate() {
			return this.rate;
		}

		public void setRate(int rate) {
			this.rate = rate;
		}
	}

	protected int fare;
	protected char source;
	protected char destination;
	protected String startTime;
	protected String endTime;
	protected boolean[] frequency; // [Su, M, T, W, Th, F, Sat] 
	protected int capacity;
	protected int reservedSeats;

	public Bus(String companyName, String vehicleID, char source, char destination,
				String startTime, String endTime, boolean[] frequency) {
		super(companyName, vehicleID, true);
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
		this.capacity = 100;
		this.reservedSeats = 0;
	}

	public Bus(String companyName, String vehicleID, char source, char destination,
				String startTime, String endTime, boolean[] frequency, boolean ac) {
		super(companyName, vehicleID, ac);
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
		this.capacity = 100;
		this.reservedSeats = 0;
	}

	public int getFare() {
		return this.fare;
	}

	public char getSource() {
		return this.source;
	}

	public char getDestination() {
		return this.destination;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	
	public boolean[] getFrequency() {
		return this.frequency;
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public int getReservedSeats() {
		return this.reservedSeats;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public String getvehicleID() {
		return this.vehicleID;
	}

	public boolean bookSeats(int numOfSeats) {
		if(this.capacity - this.reservedSeats >= numOfSeats) {
			this.reservedSeats = this.reservedSeats + numOfSeats;
			System.out.println("Fare: " + this.getFare());
			return true;
		}
		return false;
	}

	private void setFare(int distance) {
		if (ac) {
			this.fare = ACBus.getRate() * distance;
		}
		this.fare = new NonACBus().getRate() * distance;
	}

}

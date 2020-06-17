package Automotives;

public class Bus extends Vehicle implements ACBus, NonACBus {

	protected boolean[] frequency; // [Su, M, T, W, Th, F, Sat] 
	protected int capacity;
	protected int reservedSeats;
	private int distance;

	public Bus(String vehicleID, String companyName, String source, String destination, String startTime,
				String endTime, int distance, int capacity, boolean[] frequency) {
		super(vehicleID, companyName, source, destination, startTime, endTime, true);
		this.frequency = frequency;
		this.capacity = capacity;
		this.distance = distance;
		this.reservedSeats = 0;
	}

	public Bus(String vehicleID, String companyName, String source, String destination, String startTime,
				String endTime, int distance, int capacity, boolean[] frequency, boolean ac) {
		super(vehicleID, companyName, source, destination, startTime, endTime, ac);
		this.frequency = frequency;
		this.capacity = capacity;
		this.distance = distance;
		this.reservedSeats = 0;
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

	public double getFare() {
		if (this.ac) {
			return ACBus.getRate() * this.distance;
		}
		return NonACBus.getRate() * this.distance;
	}

	@Override
	public boolean bookSeats(int numOfSeats) {
		if (this.capacity - this.reservedSeats >= numOfSeats) {
			this.reservedSeats = this.reservedSeats + numOfSeats;
			System.out.println("Fare: " + numOfSeats * this.getFare());
			return true;
		}
		return false;
	}

}

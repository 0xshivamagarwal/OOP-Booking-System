/*	This class implements the following specification from the Rubrik
*	1. 	Heirarchial Inheritance x 1
*	2. 	Constructor Overloading x 1  (Line 21)
*	3.	Multiple Inheritance x 1
*	4.	Method Overriding x 1 (Line 60)
*/

package Automotives;

public class Bus extends Vehicle implements ACBus, NonACBus {

	protected boolean[] frequency; // [Su, M, T, W, Th, F, Sat] /frequency of the bus
	protected int capacity;//Capacity of the bus
	protected int reservedSeats;//Reserved seats
	private int distance;//Distance travelled by the bus

	/*
	*	CONSTRUCTOR OVERLOADING
	*/
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
	
	public boolean[] getFrequency() {//return frequency
		return this.frequency;
	}
	
	public int getCapacity() {//return capacity
		return this.capacity;
	}
	
	public int getReservedSeats() {//return number of seats reserved
		return this.reservedSeats;
	}

	public double getFare() {//return fare
		if (this.ac) {
			return ACBus.getRate() * this.distance;
		}
		return NonACBus.getRate() * this.distance;
	}
	/*
	*	METHOD OVERRIDING
	*/
	@Override
	public boolean bookSeats(int numOfSeats) {//Book seats
		if (this.capacity - this.reservedSeats >= numOfSeats) {
			this.reservedSeats = this.reservedSeats + numOfSeats;
			System.out.println("Fare: " + numOfSeats * this.getFare());
			return true;
		}
		return false;
	}

}

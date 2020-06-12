package Automotives;

public class Bus extends Vehicle{
	protected int fare;
	protected String source;
	protected String destination;
	protected String startTime;
	protected String endTime;
	protected  boolean[] frequency; // [Su, M, T, W, Th, F, Sat] 
	protected int capacity;
	protected int reservedSeats;


	public Bus(String companyName, String vehicleID, String source, String destination, String startTime,
			String endTime, boolean[] frequency, int capacity, int fare){
		super(companyName,vehicleID,true);
		this.fare = fare;
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
		this.capacity = capacity;
		this.reservedSeats = 0;
	}
	public Bus(boolean ac, String companyName, String vehicleID, String source, String destination, String startTime,
			String endTime, boolean[] frequency, int capacity, int fare){
		super(companyName,vehicleID,ac);
		this.fare = fare;
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
		this.capacity = capacity;
		this.reservedSeats = 0;
	}
	public void setfare(int fare){
		this.fare = fare;
	}
	public int getfare(){
		return this.fare;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public boolean[] getFrequency() {
		return frequency;
	}
	public void setFrequency(boolean[] frequency) {
		this.frequency = frequency;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getReservedSeats() {
		return reservedSeats;
	}
	public void setReservedSeats(int reservedSeats) {
		this.reservedSeats = reservedSeats;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getvehicleID(){
		return vehicleID;
	}
}

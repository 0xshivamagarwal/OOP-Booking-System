package Reservation;

public class Bus {
	
	String companyName;
	String busNumber;
	String source;
	String destination;
	String startTime;
	String endTime;
	boolean[] frequency; // [Su, M, T, W, Th, F, Sat] 
	int capacity;
	int reservedSeats;
	
	public Bus(String companyName, String busNumber, String source, String destination, String startTime,
			String endTime, boolean[] frequency, int capacity) {
		this.companyName = companyName;
		this.busNumber = busNumber;
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
		this.capacity = capacity;
		this.reservedSeats = 0;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBusNumber() {
		return busNumber;
	}
	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
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
	@Override
	public String toString() {
		return "\nBus Company Name : " + companyName + "\nBus Number : " + busNumber + "\nSource : " + source + "\nDestination : "
				+ destination + "\nDeparture Time : " + startTime + "\nArrival Time : " + endTime + "\nVacant Seats : " + (capacity-reservedSeats) + "\n";
	}
	
}

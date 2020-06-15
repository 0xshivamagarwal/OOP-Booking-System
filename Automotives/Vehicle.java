package Automotives;

public abstract class Vehicle {

	protected String companyName;
	protected String vehicleID;
	protected String source;
	protected String destination;
	protected String startTime;
	protected String endTime;
	protected boolean ac;
	
	public Vehicle(String vehicleID, String companyName, String source, String destination, String startTime, String endTime, boolean ac) {
		this.vehicleID = vehicleID;
		this.companyName = companyName;
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.ac = ac;
	}

	public String getCompanyName() {
		return this.companyName;
	}
	
	public String getVehicleID() {
		return this.vehicleID;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public void setvehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getSource() {
		return this.source;
	}

	public String getDestination() {
		return this.destination;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public abstract boolean bookSeats(int x);

}

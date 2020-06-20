/*	This class implements the following specification from the Rubrik
*	1. 	Abstract Class x 1
*	2. 	Abstract Method x 1
*/
package Automotives;

public abstract class Vehicle {

	protected String companyName;//Company of the Vehicle
	protected String vehicleID;//Licence plate of vehicle
	protected String source;//Source of vehicle
	protected String destination;//destination of vehicle
	protected String startTime;//start time
	protected String endTime;//end time
	protected boolean ac;//ac or non ac
	
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

    public boolean getAC(){
        return this.ac;
    }

	public abstract boolean bookSeats(int x);

}

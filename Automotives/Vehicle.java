package Automotives;

public abstract class Vehicle{

	protected String companyName;
	protected String vehicleID;
	protected boolean ac;
	
	public Vehicle(String companyName, String vehicleID, boolean ac){
		this.ac = ac;
		this.companyName = companyName;
		this.vehicleID = vehicleID;
	}
	abstract String getCompanyName();
	abstract String getvehicleID(); 
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setvehicleID(String vehicleID) {
		this.vehicleID = vehicleID;
	}

}

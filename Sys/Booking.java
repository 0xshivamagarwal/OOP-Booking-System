package Sys;
/*	This class implements the following specification from the Rubrik
*	1. 	Constructor Overloading x 1 (Line 23)
*	2.	Varargs Overloading x 2 (Line 23,35) 
*/
public class Booking {

	private String vtype;//Vechicle type(Bus or Taxi)
	private int bookingId;//Unique Booking Id
	private String companyName;//Name of the bus/taxi company
	private String source;//Area of pickup
	private String destination;//Area of drop
	private String startTime;//Start Time 
	private String endTime;//End time
	private int nSeats;// Number of Seats booked
	

	/*
	*	CONSTRUCTOR OVERLOADING
	*/

	//VARARGS OVERLOADING
	public Booking(int nSeats, String ... s) {
		// String companyName, String source, String destination, String startTime, String endTime
		this.vtype = "Bus";
 		this.bookingId = (int)(Math.random()*Math.pow(10, 6));
		this.companyName = s[0];
		this.source = s[1];
		this.destination = s[2];
		this.startTime = s[3];
		this.endTime = s[4];
		this.nSeats = nSeats;
	}
	//VARARGS OVERLOADING
	public Booking(String ... s) {
		// String companyName, String source, String startTime
		this.vtype = "Taxi";
		this.bookingId = (int)(Math.random()*Math.pow(10, 6));
		this.companyName = s[0];
		this.source = s[1];
		this.startTime = s[2];
	}
	
	public String getBookingType() {//return vechicle type
		return this.vtype;
	}
	
	public String getCompanyName() {//return company name
		return this.companyName;
	}
	
	public void setCompanyName(String companyName) {//set company name
		this.companyName = companyName;
	}

	public int getBookingId() {//return booking id
		return this.bookingId;
	}
	
	public void setBookingId(int bookingId) {//set booking id
		this.bookingId = bookingId;
	}
	
	public String getSource() {//return area of pickup
		return this.source;
	}
	
	public void setSource(String source) {//set pickup area
		this.source = source;
	}
	
	public String getDestination() {//return drop area
		return this.destination;
	}
	
	public void setDestination(String destination) {//set drop area
		this.destination = destination;
	}
	
	public String getStartTime() {//return start time
		return this.startTime;
	}
	
	public void setStartTime(String startTime) {//set start time
		this.startTime = startTime;
	}
	
	public String getEndTime() {//return end time
		return this.endTime;
	}
	
	public void setEndTime(String endTime) {//set end time
		this.endTime = endTime;
	}
	
	public int getNSeats() {//return number of seats booked
		return this.nSeats;
	}
	
	public void setNSeats(int nSeats) {// set number of seats booked
		this.nSeats = nSeats;
	}

	public String printDetails() {//Print all details
		if (this.vtype.compareTo("Bus") == 0) {
			return String.format("Booking ID: %d\nBooking Type: %s\nBooking Company: %s\nSource: %s\nDeparture Time: %s\nDestination: %s\nArrival Time: %s\nNumber of Seats: %d",
				this.bookingId, this.vtype, this.companyName, this.source, this.startTime, this.destination, this.endTime, this.nSeats);
		}
		return String.format("Booking ID: %d\nBooking Type: %s\nBooking Company: %s\nSource: %s\nDeparture Time: %s",
			this.bookingId, this.vtype, this.companyName, this.source, this.startTime);
	}

}

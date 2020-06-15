package Sys;

interface Booking {

	String vtype;
	int bookingId;
	String companyName;
	String source;
	String destination;
	String startTime;
	String endTime;
	int nSeats;
	
	public Booking(int nSeats, String ... s ) {
		// companyName, String source, String destination, String startTime, String endTime) {
		this.vtype = "Bus";
 		this.bookingId = (int)(Math.random()*Math.pow(10, 6));
		this.companyName = s[0];
		this.source = s[1];
		this.destination = s[2];
		this.startTime = s[3];
		this.endTime = s[4];
		this.nSeats = nSeats;
	}

	public Booking(String ... s) {
		this.vtype = "Taxi";
		this.bookingId = (int)(Math.random()*Math.pow(10, 6));
		this.companyName = s[0];//cityname
		this.startTime = s[1];
	}
	
	public String getBookingType() {
		return this.vtype;
	}
	
	public String getCompanyName() {
		return this.companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getBookingId() {
		return this.bookingId;
	}
	
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	public String getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public int getNSeats() {
		return this.nSeats;
	}
	
	public void setNSeats(int nSeats) {
		this.nSeats = nSeats;
	}

	public String printDetails() {
		if (this.vtype.compareTo("Bus") == 0) {
			return String.format("Booking ID: %d\nBooking Type: %s\nBooking Company: %s\nSource: %s\nDeparture Time: %s\nDestination: %s\nArrival Time: %s\nNumber of Seats: %d",
				this.bookingId, this.vtype, this.companyName, this.source, this.startTime, this.destination, this.endTime, this.nSeats);
		}
		return String.format("Booking ID: %d\nBooking Type: %s\nBooking Company: %s\nDeparture Time: %s",
			this.bookingId, this.vtype, this.companyName, this.startTime);
	}

}

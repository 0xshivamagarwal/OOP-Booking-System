package Reservation;

public class Booking {
	String vtype;
	int bookingId;
	String companyName;
	String source;
	String destination;
	String startTime;
	String endTime;
	int nSeats;
	
	public Booking(int nSeats, String ... s){//companyName, String source, String destination, String startTime,
			//String endTime) {
		this.vtype = "Bus";
 		this.bookingId = (int)(Math.random()*Math.pow(10, 6));
		this.companyName = s[0];
		this.source = s[1];
		this.destination = s[2];
		this.startTime = s[3];
		this.endTime = s[4];
		this.nSeats = nSeats;
	}

	public Booking(String ... s){
		this.vtype = "Taxi";
		this.bookingId = (int)(Math.random()*Math.pow(10, 6));
		this.companyName = s[0];//cityname
		this.startTime = s[1];
	}
	public String getbookingType(){
		return this.vtype;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
	public int getnSeats() {
		return nSeats;
	}
	public void setnSeats(int nSeats) {
		this.nSeats = nSeats;
	}
	


}

package Reservation;

public class Booking {
	int bookingId;
	String companyName;
	String busNo;
	String source;
	String destination;
	String startTime;
	String endTime;
	int nSeats;
	
	public Booking(String companyName, String busNo, String source, String destination, String startTime,
			String endTime, int nSeats) {
		this.bookingId = (int)(Math.random()*Math.pow(10, 6));
		this.companyName = companyName;
		this.busNo = busNo;
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.nSeats = nSeats;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBusNo() {
		return busNo;
	}
	public void setBusNo(String busNo) {
		this.busNo = busNo;
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
	
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", companyName=" + companyName + ", busNo=" + busNo + ", source="
				+ source + ", destination=" + destination + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", nSeats=" + nSeats + "]";
	}
}

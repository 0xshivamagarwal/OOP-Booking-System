package Sys;

import java.util.HashMap;

public class User {
	
	HashMap<Integer, Booking> bookingHistory;
	protected String username;
	private String password;
	String name;
	String age;
	String contactNo;

	//Called to create a new user
	public User() {
		this.bookingHistory = null;
		this.username = null;
		this.password = null;
		this.name = null;
		this.age = null;
		this.contactNo = null;
	}

	public User(String ... u) {
		this.bookingHistory = new HashMap<Integer, Booking>();
		this.username = u[0];
		this.password = u[1];
		if(u.length > 2) {
			this.name = u[2];
		}
		if(u.length > 3) {
			this.age = u[3];
		}
		if(u.length > 4) {
			this.contactNo = u[4];
		}
	}

	public String getUsername() {
		return this.username;
	}
	
    public String getPassword() {
        return this.password;
    }

    public String getName() {
		return this.name;
	}
	
	public String getAge() {
		return this.age;
	}
	
	public String getContactNo() {
		return this.contactNo;
	}
	
	public boolean setPassword(String password) {
		try {
			if (password.length() < 6) {
				throw new Exception();
			}
			this.password = password;
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean setContactNo(String contactNo) {
		try {
			if (contactNo.length() != 10) {
				throw new Exception();
			}
			this.contactNo = contactNo;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public HashMap<Integer, Booking> getBookingHistory() {
		return this.bookingHistory;
	}

	public void createBooking(Booking booking) {
		this.bookingHistory.put(booking.getBookingId(), booking);
		System.out.println("Booking Created!");
		System.out.println("Your Booking ID: " + booking.getBookingId());
	}
	
	public void createBooking(int id, Booking booking) {
		this.bookingHistory.put(id, booking);
		System.out.println("Booking Created!");
		System.out.println("Your Booking ID: " + id);
	}

	public void deleteBooking(int id) {
		this.bookingHistory.remove(id);
		System.out.println("Booking ID: " + id + " successfully deleted");
	}

	public void deleteBooking() {
		System.out.println("Booking IDs: " + this.bookingHistory.keySet() + " successfully deleted");
		this.bookingHistory.clear();
	}

}

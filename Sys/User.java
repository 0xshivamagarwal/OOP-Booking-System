
/*	This class implements the following specification from the Rubrik
*	1. 	Constructor Overloading x 1 (Line 23)
*	2.	Varargs Overloading x 1 (Line 41)
*	3.	Method Overloading x 2 (Line 122,105)
*	4. 	Exception Handling x 2 (Line 78,90)
*	5. 	Wrappers - Integer
*/


package Sys;

import java.util.HashMap;

public class User {
	
	private HashMap<Integer, Booking> bookingHistory;//Stores the Booking History
	protected String username;//Username of the user
	private String password;//Password of the user
	private String name;//Name of the user
	private String age;//Age of the user
	private String contactNo;//Contact Number of the user


	/*
	*CONSTRUCTOR OVERLOADING
	*/

	//Called to create a new user
	public User() {
		this.bookingHistory = null;
		this.username = null;
		this.password = null;
		this.name = null;
		this.age = null;
		this.contactNo = null;
	}

	/*
	*VARARGS OVERLOADING
	*/

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

	public String getUsername() {//returns username
		return this.username;
	}
	
    public String getPassword() {//returns password
        return this.password;
    }

    public String getName() {//returns name of the user
		return this.name;
	}
	
	public String getAge() {//returns age of the user
		return this.age;
	}
	
	public String getContactNo() {//returns contact number of the user
		return this.contactNo;
	}
	
	public boolean setPassword(String password) {//changes the password of the user
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
	
	public boolean setContactNo(String contactNo) {//changes the contact number of the user
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

	public HashMap<Integer, Booking> getBookingHistory() {//returns the booking history of the user
		return this.bookingHistory;
	}


	/*
	*	METHOD OVERLOADING
	*/

	//Adds a booking to the booking history of the user
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

	/*
	*	METHOD OVERLOADING
	*/

	//Deletes a particular booking/ entire booking history of the user
	public void deleteBooking(int id) {
		this.bookingHistory.remove(id);
		System.out.println("Booking ID: " + id + " successfully deleted");
	}

	public void deleteBooking() {
		System.out.println("Booking IDs: " + this.bookingHistory.keySet() + " successfully deleted");
		this.bookingHistory.clear();
	}

}

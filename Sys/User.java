package Sys;

import java.util.HashMap;
import java.util.Scanner;

public class User implements UserInterface {
	
	HashMap<Integer, BookingInterface> bookingHistory = new HashMap<Integer, BookingInterface>();
	protected String username;
	private String password;
	String name = null;
	String age = null;
	String contactNo = null;

	//Called to create a new user
	public User(String ... u) {
		this.bookingHistory = new HashMap<Integer, BookingInterface>();
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
		if(u.length > 5) {
			//Write exception here
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
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public HashMap<Integer, BookingInterface> getBookingHistory() {
		return this.bookingHistory;
	}
	
	public void createBooking(int id, BookingInterface booking) {
		this.bookingHistory.put(id, booking);
	}

	public void deleteBooking(int id) {
		this.bookingHistory.remove(id);
		System.out.println("Booking ID: " + id + " successfully deleted");
	}
	
	public void changePassword(String oldpassword) {
		if(oldpassword.equals(this.password)) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new Password");
			this.password = sc.nextLine();
			System.out.println("Password Changed successfully");
			sc.close();
		} else {
			System.out.println("Password incorrect");
		}
	}

}

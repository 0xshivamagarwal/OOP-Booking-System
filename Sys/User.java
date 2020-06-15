package Sys;

import java.util.Scanner;

interface User {
	
	HashMap<Integer, Booking> bookingHistory = new HashMap<Integer, Booking>();
	protected String username;
	private String password;
	String name = null;
	String age = null;
	String contactNo = null;

	//Called to create a new user
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
		if(u.length > 5) {
			//Write exception here
		}
	}
	
	public void changePassword(String oldpassword) {
		if(oldpassword == this.password) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new Password");
			this.password = sc.nextline();
			System.out.println("Password Changed successfully");
		} else {
			System.out.println("Password incorrect");
		}
	}

	public String getUsername() {
		return this.username;
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

	public HashMap<Integer, String> getBookingHistory() {
		return this.bookingHistory;
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public void addBooking(int key, Booking b) {
		this.bookingHistory.put(key,b);
	}

}
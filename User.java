package Reservation;

import java.util.HashMap;

public class User {
	HashMap<Integer, Booking> bookingHistory = new HashMap<Integer, Booking>();
	String name;
	int age;
	String contactNo;
	public User(String name, int age, String contactNo) {
		this.bookingHistory = new HashMap<Integer, Booking>();
		this.name = name;
		this.age = age;
		this.contactNo = contactNo;
	}
	public HashMap<Integer, Booking> getBookingHistory() {
		return bookingHistory;
	}
	public void setBookingHistory(HashMap<Integer, Booking> bookingHistory) {
		this.bookingHistory = bookingHistory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", contactNo=" + contactNo
				+ "bookingHistory=" + bookingHistory + "]";
	}
}

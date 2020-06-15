package Sys;

import java.util.Scanner;

public class ShowBookings implements User, Booking {
	
	public void show(User user) {

		Scanner in = new Scanner(System.in);
		HashMap<Integer, String> bookingHistory = user.getBookingHistory();
		Set bookingIds = bookingHistory.keySet();
		System.out.println("Enter Booking ID: ");
		int id = in.nextint();
		if (bookingHistory.containsKey(id)) {
			Booking b = bookingHistory.get(id);
			System.out.println(b.printDetails());
		} else {
			System.out.println("No booking with this ID exists...");
		}

	}

}
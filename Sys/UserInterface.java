package Sys;

import java.util.HashMap;

public interface UserInterface {

	public String getUsername();

	public HashMap<Integer, BookingInterface> getBookingHistory();

	public void createBooking(int id, BookingInterface booking);

}
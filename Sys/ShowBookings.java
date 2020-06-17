package Sys;

import java.util.HashMap;

public class ShowBookings implements UserInterface, BookingInterface {

	public void show(UserInterface user, int id) {


		HashMap<Integer, BookingInterface> bookingHistory = user.getBookingHistory();
		/*System.out.println(bookingHistory.keySet());
		
		System.out.println("Enter Booking ID: ");
		int id = in.nextInt();*/
		
		if (bookingHistory.containsKey(id)) {
			BookingInterface b = bookingHistory.get(id);
			System.out.println(b.printDetails());
		} else {
			System.out.println("No booking with this ID exists...");
		}

		

	}

	@Override
	public HashMap<Integer, BookingInterface> getBookingHistory() {
		return null;
	}

	@Override
	public String printDetails() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

    @Override
    public String getPassword() {
        return null;
    }

	@Override
    public String getContactNo() {
        return null;
    }

    @Override
    public void setContactNo(String ContactNo) {
    }

    @Override
	public int getBookingId() {
		return 0;
	}

	@Override
	public void createBooking(int id, BookingInterface booking) {
	}

    @Override
    public void changePassword(String oldpassword) {
    } 

}

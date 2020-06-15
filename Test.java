import java.io.IOException;
import java.util.HashMap;

import Sys.Booking;
import Sys.BookingInterface;
import Sys.ShowBookings;
import Sys.User;
import Sys.UserInterface;
import Automotives.Bus;
import Automotives.Vehicle;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println();
		HashMap<String, UserInterface> userInfo = new HashMap<String, UserInterface>();
		HashMap<String, Vehicle> vehicleInfo = new HashMap<String, Vehicle>();
		
		// Temp Users
		UserInterface user;
		user = new User("admin", "password");
		userInfo.put(user.getUsername(), user);
		user = new User("temp", "123456");
		userInfo.put(user.getUsername(), user);

		// Temp Vehicles
		Vehicle vehicle;
		vehicle = new Bus("1", "Company A", "A", "B", "10:00", "18:00", 100, 25, new boolean[] {true, false, true, false, true, false, true});
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("2", "Company B", "B", "A", "15:00", "23:00", 100, 25, new boolean[] {false, true, false, true, false, true, false});
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);

		// Book Bus Seats
		// user input: vehicleID, numSeats, username
		user = userInfo.get("temp");
		vehicle = vehicleInfo.get("1");
		int numSeats = 10;
		if (vehicle.bookSeats(numSeats)) {
			BookingInterface booking = new Booking(numSeats, vehicle.getCompanyName(), vehicle.getSource(), vehicle.getDestination(), vehicle.getStartTime(), vehicle.getEndTime());
			user.createBooking(booking.getBookingId(), booking);
		}

		// Show Bookings For Admin
		user = userInfo.get("admin");
		// user input: username
		String username = "temp";
		if (userInfo.containsKey(username)) {
			UserInterface userTemp = userInfo.get(username);
			ShowBookings s = new ShowBookings();
			s.show(userTemp);
		} else {
			System.out.println("User doesn't exist!!");
		}

	}
}

package Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Bus> busInfo = new HashMap<String, Bus>();
		HashMap<String, User> userInfo = new HashMap<String, User>();
		int q = Integer.parseInt(br.readLine());
		for(; q>0; q--) {
			String[] in = br.readLine().trim().split(" ");
			String function = in[0];
			if(function.compareTo("create-bus") == 0) {
				try {
					String busNo = in[1];
					String busCompany = in[2];
					String source = in[3];
					String dest = in[4];
					String start = in[5];
					String end = in[6];
					int capacity = Integer.parseInt(in[7]);
					String freq = in[8];
					boolean[] frequency = new boolean[7];
					for(int i=0; i<7; i++) {
						if(freq.charAt(i) == '1') {
							frequency[i] = true;
						} else {
							frequency[i] = false;
						}
					}
					Bus bus = new Bus(busCompany, busNo, source, dest, start, end, frequency, capacity);
					if(!busInfo.containsKey(busNo)) {
						busInfo.put(busNo, bus);
						System.out.println("success");
					} else {
						System.out.println("failure");
					}
				} catch (Exception e) {
					System.out.println("failure");
				}
			} else if(function.compareTo("search-bus") == 0) {
				HashMap<String, Integer> days = new HashMap<String, Integer>();
				days.put("Sunday", 0);
				days.put("Monday", 1);
				days.put("Tuesday", 2);
				days.put("Wednesday", 3);
				days.put("Friday", 4);
				days.put("Saturday", 5);
				days.put("Sunday", 6);
				String source = in[1];
				String dest = in[2];
				int day = days.get(in[3]);
				ArrayList<String> buses = new ArrayList<String>(busInfo.keySet());
				ArrayList<Bus> searchRes = new ArrayList<Bus>();
				for(String busNo : buses) {
					Bus bus = busInfo.get(busNo);
					if(bus.source.compareTo(source)==0 && bus.destination.compareTo(dest)==0 && bus.frequency[day]) {
						searchRes.add(bus);
					}
				}
				if(searchRes.size() == 0) {
					System.out.println("No Bus Found!!");
				} else {
					System.out.println(searchRes);
				}
			} else if(function.compareTo("create-user") == 0) {
				try {
					String name = in[1];
					int age = Integer.parseInt(in[2]);
					String contactNo = in[3];
					User user = new User(name, age, contactNo);
					if(!userInfo.containsKey(contactNo)) {
						userInfo.put(contactNo, user);
						System.out.println("success");
					} else {
						System.out.println("failure");
					}
				} catch(Exception e) {
					System.out.println("failure");
				}
			} else if(function.compareTo("reserve-seat") == 0) {
				try {
					String busNo = in[1];
					int nSeats = Integer.parseInt(in[2]);
					String userContactNo = in[3];
					if(busInfo.containsKey(busNo) && userInfo.containsKey(userContactNo)) {
						Bus bus = busInfo.get(busNo);
						User user = userInfo.get(userContactNo);
						int vacantSeats = bus.capacity - bus.reservedSeats;
						if(vacantSeats >= nSeats) {
							bus.setReservedSeats(bus.reservedSeats+nSeats);
							Booking b = new Booking(bus.companyName, bus.busNumber, bus.source, bus.destination, bus.startTime, bus.endTime, nSeats);
							int bookingId = b.bookingId;
							HashMap<Integer, Booking> bookingHistory = user.bookingHistory; 
							bookingHistory.put(bookingId, b);
							user.setBookingHistory(bookingHistory);
							System.out.println("Your Booking Id : " + bookingId);
						} else {
							System.out.println("failure");
						}
					} else {
						System.out.println("failure");
					}
				} catch(Exception e) {
					System.out.println("failure");
				}
			} else if(function.compareTo("view-reservations") == 0) {
				String userContactNo = in[1];
				if(userInfo.containsKey(userContactNo)) {
					User user = userInfo.get(userContactNo);
					HashMap<Integer, Booking> bookingHistory = user.bookingHistory;
					System.out.println(bookingHistory);
				} else {
					System.out.println("failure");
				}
			} else {
				System.out.println("Work in Progress!");
			}
		}
	}
}

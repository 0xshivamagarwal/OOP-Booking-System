import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import Sys.Booking;
import Sys.User;
import Automotives.Bus;
import Automotives.Taxi;
import Automotives.Vehicle;

/*	This class implements the following specification from the Rubrik
* 	1.	Exception Handling x 8
*/

public class Driver {
	public static void main(String[] args) throws IOException {
		/*
		*Main method glues together all objects of classes and implements a User Interface
		*/
		clearScreen();
		HashMap<String, User> userInfo = new HashMap<String, User>();
		HashMap<String, Vehicle> vehicleInfo = new HashMap<String, Vehicle>();
		HashMap<String, Vehicle> taxiInfo = new HashMap<String, Vehicle>();

		// Vehicles
		Vehicle vehicle;
		vehicle = new Bus("1", "Company 1", "A", "B", "10:00", "18:00", 200, 25,
				new boolean[] { true, false, true, false, true, false, true }, false);
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("2", "Company 2", "A", "C", "15:00", "23:00", 190, 25,
				new boolean[] { false, true, false, true, false, true, false });
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("3", "Company 3", "A", "D", "11:00", "18:00", 160, 25,
				new boolean[] { false, true, true, true, false, true, false }, false);
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("4", "Company 4", "B", "A", "20:00", "00:00", 100, 25,
				new boolean[] { false, true, false, false, false, true, false });
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("5", "Company 2", "B", "C", "08:00", "10:00", 50, 25,
				new boolean[] { true, true, false, true, false, true, false }, false);
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("6", "Company 1", "B", "D", "14:00", "22:00", 200, 25,
				new boolean[] { false, true, false, true, false, false, false });
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("7", "Company 4", "C", "A", "09:00", "16:00", 180, 25,
				new boolean[] { false, true, false, true, true, true, false }, false);
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("8", "Company 3", "C", "B", "13:00", "20:00", 80, 25,
				new boolean[] { true, true, false, true, false, true, false });
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("9", "Company 4", "C", "D", "07:00", "16:00", 210, 25,
				new boolean[] { true, true, false, false, false, true, false }, false);
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("10", "Company 1", "D", "A", "02:00", "10:00", 200, 25,
				new boolean[] { false, true, false, true, true, true, false });
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("11", "Company 2", "D", "B", "16:00", "21:00", 130, 25,
				new boolean[] { false, false, false, true, false, true, false }, false);
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);
		vehicle = new Bus("12", "Company 4", "D", "C", "18:00", "00:00", 150, 25,
				new boolean[] { true, true, false, true, true, true, false });
		vehicleInfo.put(vehicle.getVehicleID(), vehicle);

		// Add taxi providers
		taxiInfo.put("1", new Taxi("1", "Company 1", null, null, false));
		taxiInfo.put("2", new Taxi("2", "Company 3", null, null));
		taxiInfo.put("3", new Taxi("3", "Company 1", null, null));
		taxiInfo.put("4", new Taxi("4", "Company 2", null, null, false));
		taxiInfo.put("5", new Taxi("5", "Company 3", null, null));
		taxiInfo.put("6", new Taxi("6", "Company 1", null, null));
		taxiInfo.put("7", new Taxi("7", "Company 2", null, null));
		taxiInfo.put("8", new Taxi("8", "Company 1", null, null, false));
		taxiInfo.put("9", new Taxi("9", "Company 3", null, null));
		taxiInfo.put("10", new Taxi("10", "Company 2", null, null));

		// add admin user
		User user;
		user = new User("admin", "123456");
		userInfo.put(user.getUsername(), user);

		// Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println(
					"\n***************************************************************************************\n");
			System.out.println("Choose what you want to do from following options: (1, 2, 3)");
			System.out.println("1) Login to existing account.");
			System.out.println("2) Create new account.");
			System.out.println("3) Exit");
			System.out.print("Input: ");

			String op = br.readLine();
			clearScreen();

			if (op.equals("1")) {
				User currentUser;

				System.out.print("Enter username: ");
				String uName = br.readLine();
				String uPword = String.valueOf(System.console().readPassword("Enter Password: "));

				clearScreen();
				if (!userInfo.containsKey(uName) || !uPword.equals(userInfo.get(uName).getPassword())) {
					System.out.println("Wrong Username/Password. Please try again later.....");
					continue;
				} else {
					currentUser = userInfo.get(uName);
					System.out.println("Login Successful!");
				}

				while (true) {
					System.out.println("\n###############################################################\n");
					System.out.println("Choose what you want to do from following options: (1, 2, 3, 4, 5)");
					System.out.println("1) Change account details");
					System.out.println("2) View previous bookings");
					System.out.println("3) Create new booking");
					System.out.println("4) Delete existing booking");
					System.out.println("5) LogOut");
					System.out.print("Input: ");
					op = br.readLine();
					clearScreen();

					if (op.equals("1")) {
						System.out.println("Choose what you want to change from following options: (1, 2)");
						System.out.println("1) Password");
						System.out.println("2) Contact Number");
						System.out.println("Press any key to go back...");
						System.out.print("Input: ");
						String op1 = br.readLine();
						clearScreen();
						if (op1.equals("1")) {
							String newPassword = String.valueOf(System.console().readPassword("Enter New Password: "));
							clearScreen();
							if (currentUser.setPassword(newPassword)) {
								System.out.println("Password Changed Successfully!");
								userInfo.put(currentUser.getUsername(), currentUser);
							} else {
								System.out.println("Invalid Password");
							}
						} else if (op1.equals("2")) {
							System.out.println("Current Contact No.: " + currentUser.getContactNo());
							System.out.print("Enter New Contact No.: ");
							String newContactNo = br.readLine();
							clearScreen();
							if (currentUser.setContactNo(newContactNo)) {
								userInfo.put(currentUser.getUsername(), currentUser);
								System.out.println("Contact Number Changed Successfully!");
							} else {
								System.out.println("Invalid Contact Number!");
							}
						}
					} else if (op.equals("2")) {
						System.out.println("###############################################################");
						System.out.println("\t\tPrevious Bookings");
						System.out.println("###############################################################\n");
						HashMap<Integer, Booking> bookingHistory = currentUser.getBookingHistory();
						if (bookingHistory.size() == 0) {
							System.out.println("No Previous Bookings Found!");
							System.out.print("\nPress any key to go back...");
							br.readLine();
							clearScreen();
							continue;
						}
						System.out.print("Booking ID for all Previous Bookings: ");
						System.out.println(bookingHistory.keySet());
						System.out.print("\nEnter Booking ID: ");
						int id;
						try {
							id = Integer.parseInt(br.readLine());
							if (!bookingHistory.containsKey(id)) {
								throw new Exception();
							}
						} catch (Exception e) {
							System.out.println("\nInvalid Booking ID!");
							System.out.print("\nPress any key to go back...");
							br.readLine();
							clearScreen();
							continue;
						}
						System.out.println("\n" + bookingHistory.get(id).printDetails());
						System.out.print("\nPress any key to go back...");
						br.readLine();
						clearScreen();
						continue;
					} else if (op.equals("3")) {
						System.out.println("###############################################################");
						System.out.println("\t\tCreate New Booking");
						System.out.println("###############################################################\n");
						System.out.println("Choose what you wish to book from following: (1, 2) ");
						System.out.println("1) Bus");
						System.out.println("2) Taxi");
						System.out.println("Press any key to go back...");
						System.out.print("Input: ");
						String op1 = br.readLine();
						clearScreen();
						if (op1.equals("1")) {
							System.out.println("List of Buses from available travel points: ");
							System.out.println(
									"VehicleID\tCompany Name\tSource\t\tDestination\tDeparture Time\tArrival Time\tAC?");
							for (HashMap.Entry<String, Vehicle> entry : vehicleInfo.entrySet()) {
								Vehicle v = entry.getValue();
								System.out.println(entry.getKey() + "\t\t" + v.getCompanyName() + "\t" + v.getSource()
										+ "\t\t" + v.getDestination() + "\t\t" + v.getStartTime() + "\t\t"
										+ v.getEndTime() + "\t\t" + v.getAC());
							}
							System.out.print("\nChoose Vehicle ID (1-12): ");
							String id = br.readLine();
							if (vehicleInfo.containsKey(id)) {
								vehicle = vehicleInfo.get(id);
								System.out.print("Enter the number of seats you wish to book (Max 5): ");
								int numSeats;
								try {
									numSeats = Integer.parseInt(br.readLine());
								} catch (Exception e) {
									System.out.println("\nInvalid Input!");
									System.out.print("\nPress any key to go back...");
									br.readLine();
									clearScreen();
									continue;
								}
								if (numSeats > 5) {
									System.out.println("\nMaximum 5 seats can be booked");
									System.out.print("\nPress any key to go back...");
									br.readLine();
									clearScreen();
									continue;
								}
								clearScreen();
								if (vehicle.bookSeats(numSeats)) {
									Booking booking = new Booking(numSeats, vehicle.getCompanyName(),
											vehicle.getSource(), vehicle.getDestination(), vehicle.getStartTime(),
											vehicle.getEndTime());
									user.createBooking(booking.getBookingId(), booking);
									System.out.print("\nPress any key to go back...");
									br.readLine();
									clearScreen();
								} else {
									System.out.println("Sorry bus is full!");
									System.out.print("\nPress any key to go back...");
									br.readLine();
									clearScreen();
								}
							} else {
								System.out.println("\nInvalid Vehicle ID!");
								System.out.print("\nPress any key to go back...");
								br.readLine();
								clearScreen();
								continue;
							}
						} else if (op1.equals("2")) {
							String source, startTime;
							int duration;
							while (true) {
								System.out.print("Enter pickup location: ");
								source = br.readLine();
								if (source.length() > 0) {
									break;
								} else {
									System.out.println("Wrong Input, Try again\n");
								}
							}
							while (true) {
								System.out.print("\nEnter pickup time (in hh:mm): ");
								startTime = br.readLine();
								if (startTime.length() == 5) {
									try {
										Integer.parseInt(startTime.split(":")[0]);
                                        Integer.parseInt(startTime.split(":")[1]);
                                        if(Integer.parseInt(startTime.split(":")[0])>=0 && Integer.parseInt(startTime.split(":")[0]) < 24 &&
                                                Integer.parseInt(startTime.split(":")[1])>=0 && Integer.parseInt(startTime.split(":")[1]) < 60){
										    break;
                                        }
                                        else{
                                            throw new Exception(); 
                                        }
									} catch (Exception e) {
										System.out.println("Wrong Input, Try again\n");
									}
								} else {
									System.out.println("Wrong Input, Try again\n");
								}
							}
							while (true) {
								System.out.print("\nEnter number of hours you want to use the taxi: (Maximum 100 hours) ");
								try {
									duration = Integer.parseInt(br.readLine());
									if(duration >0 && duration <= 100){
                                        break;
                                    }
                                    else{
                                        throw new Exception();
                                    }
								} catch (Exception e) {
									System.out.println("Wrong Input, Try again\n");
								}
							}
							System.out.print("\nDo you want AC Taxi? (Y/n): ");
							String ac_inp = br.readLine();
							clearScreen();
							boolean ac = true;
							if (ac_inp.equals("n") || ac_inp.equals("N")) {
								ac = true;
							}
							Vehicle v;
							boolean flag = false;
							for (Vehicle tmp : taxiInfo.values()) {
								if (tmp.getAC() == ac && tmp.bookSeats(duration)) {
									v = tmp;
									Booking booking = new Booking(v.getCompanyName(), source, startTime);
									user.createBooking(booking.getBookingId(), booking);
									flag = true;
									break;
								}
							}
							if (!flag) {
								System.out.println("No available taxi found!");
							}
							System.out.print("\nPress any key to go back...");
							br.readLine();
							clearScreen();
						}
					} else if (op.equals("4")) {
						System.out.println("###############################################################");
						System.out.println("\t\tDelete Booking");
						System.out.println("###############################################################\n");
						HashMap<Integer, Booking> bookingHistory = currentUser.getBookingHistory();
						if (bookingHistory.size() == 0) {
							System.out.println("No Previous Bookings Found!");
							System.out.print("\nPress any key to go back...");
							br.readLine();
							clearScreen();
							continue;
						}
						System.out.println("Choose what you want to do from following options: (1, 2)");
						System.out.println("1) Delete a single booking");
						System.out.println("2) Delete all bookings");
						System.out.println("Press any key to go back...");
						System.out.print("Input: ");
						String op1 = br.readLine();
						clearScreen();
						if (op1.equals("1")) {
							System.out.print("Booking ID for all Previous Bookings: ");
							System.out.println(bookingHistory.keySet());
							System.out.print("\nEnter Booking ID: ");
							int id;
							try {
								id = Integer.parseInt(br.readLine());
								if (!bookingHistory.containsKey(id)) {
									throw new Exception();
								}
							} catch (Exception e) {
								System.out.println("\nInvalid Booking ID!");
								System.out.print("\nPress any key to go back...");
								br.readLine();
								clearScreen();
								continue;
							}
							currentUser.deleteBooking(id);
							System.out.print("\nPress any key to go back...");
							br.readLine();
							clearScreen();
							continue;
						} else if (op1.equals("2")) {
							System.out.print("Are you sure you want to delete all bookings (y/N): ");
							String in = br.readLine();
							if (in.equals("y") || in.equals("Y")) {
								currentUser.deleteBooking();
								System.out.print("\nPress any key to go back...");
								br.readLine();
							} else {
								System.out.println("\nDelete Bookings operation cancelled!");
								System.out.print("\nPress any key to go back...");
								br.readLine();
							}
							clearScreen();
							continue;
						}
					} else if (op.equals("5")) {
						System.out.println("Logging Out.");
						break;
					} else {
						System.out.println("Invalid Choice!");
						continue;
					}
				}

			} else if (op.equals("2")) {
				System.out.println("###############################################################");
				System.out.println("\t\tCreate New Account");
				System.out.println("###############################################################\n");
				System.out.print("Enter Username: ");
				String username = br.readLine();
				String password = String.valueOf(System.console().readPassword("Enter Password: "));
				if (username.length() <= 0 || password.length() <= 0) {
					System.out.println("\nUsername/Password can not be empty!!");
					System.out.print("\nPress any key to go back...");
					br.readLine();
					clearScreen();
					continue;
				} else if (userInfo.containsKey(username)) {
					System.out.println("\nUsername taken, please try with another one!!");
					System.out.print("\nPress any key to go back...");
					br.readLine();
					clearScreen();
					continue;
				}
				System.out.print("Enter Name, if not available press Enter: ");
				String name = br.readLine();
				if (name.length() == 0) {
					name = null;
				}
				String age, contact;
				while (true) {
					System.out.print("Enter Age, if not available press Enter: ");
					age = br.readLine();
					if (age.length() == 0) {
						age = null;
						break;
					} else {
						try {
							if (Integer.parseInt(age) > 0 && Integer.parseInt(age) < 130) {
								break;
							} else {
								throw new Exception();
							}
						} catch (Exception e) {
							System.out.println("\nWrong Input, Try Again!\n");
						}
					}
				}
				while (true) {
					System.out.print("Enter Contact No., if not available press Enter: ");
					contact = br.readLine();
					if (contact.length() == 0) {
						contact = null;
						break;
					} else {
						try {
							if (contact.length() == 10 && Long.parseLong(contact) > 0) {
								break;
							} else {
								throw new Exception();
							}
						} catch (Exception e) {
							System.out.println("\nWrong Input, Try Again!\n");
						}
					}
				}
				user = new User(username, password, name, age, contact);
				userInfo.put(user.getUsername(), user);
				clearScreen();
				System.out.println("User Account Created");
				continue;
			} else if (op.equals("3")) {
				System.out.println("Thank you for using our services");
				break;
			} else {
				System.out.println("Invalid Choice!");
				continue;
			}

			System.out.print("\nDo you wish to continue? (Y/n): ");
			op = br.readLine();
			if (op.equals("n") || op.equals("N")) {
				break;
			}
			clearScreen();
		}

	}

	public static void clearScreen() {
		/*
		*Used to clear screen after every input
		*/
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033\143");
			}
		} catch (Exception e) {
		}
	}

}

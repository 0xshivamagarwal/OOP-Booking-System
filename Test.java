import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

import Sys.Booking;
import Sys.BookingInterface;
import Sys.ShowBookings;
import Sys.User;
import Sys.UserInterface;
import Automotives.Bus;
import Automotives.Taxi;
import Automotives.Vehicle;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println();
		HashMap<String, UserInterface> userInfo = new HashMap<String, UserInterface>();
		HashMap<String, Vehicle> vehicleInfo = new HashMap<String, Vehicle>();
	    
        //Vehicles
        Vehicle vehicle;
        vehicle = new Bus("1", "Company 1", "A", "B", "10:00", "18:00", 200, 25, new boolean[] {true, false, true, false, true, false, true}, false);
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("2", "Company 2", "A", "C", "15:00", "23:00", 190, 25, new boolean[] {false, true, false, true, false, true, false});
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);    
        vehicle = new Bus("3", "Company 3", "A", "D", "11:00", "18:00", 160, 25, new boolean[] {false, true, true, true, false, true, false}, false);
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("4", "Company 4", "B", "A", "20:00", "00:00", 100, 25, new boolean[] {false, true, false, false, false, true, false});
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("5", "Company 2", "B", "C", "08:00", "10:00", 50, 25, new boolean[] {true, true, false, true, false, true, false}, false);
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("6", "Company 1", "B", "D", "14:00", "22:00", 200, 25, new boolean[] {false, true, false, true, false, false, false});
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("7", "Company 4", "C", "A", "09:00", "16:00", 180, 25, new boolean[] {false, true, false, true, true, true, false}, false);
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("8", "Company 3", "C", "B", "13:00", "20:00", 80, 25, new boolean[] {true, true, false, true, false, true, false});
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("9", "Company 4", "C", "D", "07:00", "16:00", 210, 25, new boolean[] {true, true, false, false, false, true, false},false);
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("10", "Company 1", "D", "A", "02:00", "10:00", 200, 25, new boolean[] {false, true, false, true, true, true, false});
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("11", "Company 2", "D", "B", "16:00", "21:00", 130, 25, new boolean[] {false, false, false, true, false, true, false}, false);
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);
        vehicle = new Bus("12", "Company 4", "D", "C", "18:00", "00:00", 150, 25, new boolean[] {true, true, false, true, true, true, false});
        vehicleInfo.put(vehicle.getVehicleID(), vehicle);

        UserInterface user;
        user = new User("admin", "123456");
        userInfo.put(user.getUsername(), user);
        
        //System.out.println(userInfo.get("admin").getPassword());
        
        boolean wantContinue = true;
        Scanner in = new Scanner(System.in);
        
        while(wantContinue != false){
            System.out.println("\n***************************************************************************************\n");
            System.out.println("Choose what you want to do from following options: (1,2)");
            System.out.println("1) Login to existing ID.");
            System.out.println("2) Create new User ID.");
            int op = in.nextInt();
            
            
            if(op == 1){
                System.out.print("Enter User Name:");
                String nL = in.nextLine();
                String uName = in.nextLine();
                
                if(userInfo.containsKey(uName)){
                    System.out.print("Enter Password:");
                    String uPword = in.nextLine();
                     
                    if(uPword.equals(userInfo.get(uName).getPassword())){
                        while(true){
                            System.out.println("\n#########################################################################################\n");
                            System.out.println("Choose what you want to do from following options: (1,2,3,4)");
                            System.out.println("1) Change details of your account");
                            System.out.println("2) View previous bookings.");
                            System.out.println("3) Make a new Booking.");
                            System.out.println("4) LogOut.");
                            int op1 = in.nextInt();

                            if(op1 == 1){
                                System.out.println("Choose what you want to change from following options: (1,2)");
                                System.out.println("1) Password.");
                                System.out.println("2) Contact Number.");
                                int op2 = in.nextInt();

                                if(op2 == 1){
                                    userInfo.get(uName).changePassword(uPword);
                                }

                                else if(op2 == 2){
                                    System.out.println("Current Contact No.: " + userInfo.get(uName).getContactNo());
                                    System.out.print("Enter New Contact No.:");
                                    String nL1 = in.nextLine();
                                    String newContactNo = in.nextLine();
                                    userInfo.get(uName).setContactNo(newContactNo);
                                }

                                else{
                                    System.out.println("Not a valid Choice.");
                                    continue;
                                }
                            }
                        
                            else if(op1 == 2){
                                System.out.println("Previous Bookings: ");
                            
                                if (userInfo.containsKey(uName)) {
                                    UserInterface userTemp = userInfo.get(uName);
                                    ShowBookings s = new ShowBookings();
                                    HashMap<Integer, BookingInterface> bookingHistory = userTemp.getBookingHistory();
                                    System.out.println("Booking ID for all Previous Bookings: ");
                                    System.out.println(bookingHistory.keySet());
                                    System.out.println("Enter Booking ID: ");
                                    int id = in.nextInt();
                                    s.show(userTemp,id);
                                    continue;
                                }    
                            }

                            else if(op1 == 3){
                                System.out.println("A New Booking: ");
                                BookingInterface booking;
                                System.out.println("Choose what you wish to book from following: (1,2) ");
                                System.out.println("1) Bus");
                                System.out.println("2) Taxi");
                                int op3 = in.nextInt();

                                if(op3 == 1){
                                    System.out.println("List of Buses from available travel points: ");
                                    System.out.println("VehicleID    Company Name   Source    Dest         Dep Time       Arr Time      AC?");
                                    for (HashMap.Entry<String, Vehicle> entry : vehicleInfo.entrySet()) {
                                        System.out.println(entry.getKey()+"          "+entry.getValue().getCompanyName()+"          "
                                        +entry.getValue().getSource()+"         "+entry.getValue().getDestination()+"         "
                                        +entry.getValue().getStartTime()+"         "+entry.getValue().getEndTime()
                                        +"         "+entry.getValue().getAC());
                                    }

                                    System.out.println("Choose from the above routes by entering the vehicle ID: (1-12)");
                                    String nl2 = in.nextLine();
                                    String op4 = in.nextLine();
                                                            
                                    if(vehicleInfo.containsKey(op4)){
                                        user = userInfo.get(uName);
                                        vehicle = vehicleInfo.get(op4);
                                        //System.out.println(vehicle);
                                        System.out.println("Enter the number of seats you wish to book: (Max 5)");
                                        int numSeats = in.nextInt();
                                        if(numSeats > 5){
                                            System.out.println("The maximum number of seats that one user can book is 5.");
                                            continue;
                                        }
                                        else{        
                                            if (vehicle.bookSeats(numSeats)) {
                                                booking = new Booking(numSeats, vehicle.getCompanyName(), vehicle.getSource(), 
                                                    vehicle.getDestination(), vehicle.getStartTime(), vehicle.getEndTime());
                                                user.createBooking(booking.getBookingId(), booking);
                                            }
                                            else{
                                                System.out.println("Sorry seats are booked!");
                                                continue;
                                            }
                                        }
                            
                                    }
                                    else{
                                        System.out.println("Invalid Vehicle ID.");
                                        continue;
                                    }

                                }
                            
                                else if (op3 == 2){
                                    //taxi
                                    ArrayList<String> company = new ArrayList<String>();
                                    company.add("Company 1"); company.add("Company 2"); company.add("Company 3"); company.add("Company 4");       
                                    ArrayList<String> source = new ArrayList<String>();
                                    source.add("A"); source.add("B"); source.add("C"); source.add("D");
                                
                                    System.out.println("Choose the company you'd like to travel with among the following: (1-4)");
                                    int i =1;
                                    for (String str : company){ 		      
	                                    System.out.print(i+") "+str+"  ");
                                        i = i+1;        
	                                }
                                    System.out.println("\n");
                                    int compName = in.nextInt();
                                    String companyName;
                                    if(compName>0 && compName <= company.size()){
                                        companyName =  company.get(compName -1);
                                    }
                                    else{
                                        System.out.println("Invalid Choice, company name.");
                                        continue;
                                    }

                                    System.out.println("Choose the source location from the following: (1-4)");
                                    i =1;
                                    for (String str : source){
                                        System.out.print(i+") "+str+"  ");
                                        i = i+1;        
                                    }
                                    System.out.println("\n");
                                    int sourceNo = in.nextInt();
                                    String sourceName;
                                    if(sourceNo>0 && sourceNo <= source.size()){
                                        sourceName =  source.get(sourceNo -1);
                                    }
                                    else{
                                        System.out.println("Invalid Choice, source.");
                                        continue;
                                    }
                                    String startTime; int hr; int min;
                                    System.out.println("Enter the hour value of start time: (0-23)");
                                    hr = in.nextInt();
                                    if(hr >=0 && hr<=23){
                                        System.out.println("Enter the minute value of start time: (0-59)");
                                        min = in.nextInt();
                                        if(min<0 || min >59){
                                            System.out.println("Invalid Minute value.");
                                            continue;
                                        }
                                    }
                                    else{
                                        System.out.println("Invalid Hour value.");
                                        continue;
                                    }
                                    startTime = hr + ":" + min; 
                                    //System.out.println(startTime);
                                    boolean ac;
                                    System.out.print("Do you want Ac or Non Ac vehicle? (y/n)?");
                                    String nl3 = in.nextLine();
                                    String wantAC = in.nextLine();

                                    if(wantAC.equals("Y") || wantAC.equals("y")){
                                        ac = true;
                                    }
                                    else{
                                        ac = false;
                                    }
                                
                                    Vehicle vehicleTaxi;
                                    String vehicleID = "Taxi" + (int)(Math.random()*Math.pow(10, 5));
                                
                                    System.out.print("Enter the distance for which you want to book the taxi? (Max 1000)");
                                    int distance = in.nextInt();
                                    if(distance <=0 || distance>1000){
                                        System.out.print("Taxi no available for this distance.");
                                        continue;
                                    }
                                    if(ac){
                                        vehicleTaxi = new Taxi(vehicleID,companyName,sourceName,startTime,ac);
                                    }
                                    else{
                                        vehicleTaxi = new Taxi(vehicleID,companyName,sourceName,startTime);
                                    }
                                    booking = new Booking(vehicleTaxi.getCompanyName(), vehicleTaxi.getSource(),vehicle.getStartTime());
                                    user.createBooking(booking.getBookingId(), booking);
                                    vehicleTaxi.bookSeats(distance);
                                }
                                else{
                                    System.out.println("Invalid Choice!");
                                    continue;
                                }       
                            }
                            else if(op1==4){
                                System.out.println("Logging Out.");
                                break;
                            } 
                            else{
                                System.out.println("Invalid Choice!");
                                continue;
                            }
                        }
                    }
                    else{
                        System.out.println("Wrong Password!");
                        continue;
                    }
                                 
                }
                else{
                    System.out.println("No such User!");
                    continue;
                }        
            }
            else if(op ==2){
                System.out.println("Create New User.");
                System.out.print("Enter User Name: ");
                String nl4 = in.nextLine();
                String newUName = in.nextLine();
                System.out.print("Enter Password: ");
                String newPword = in.nextLine();
                System.out.print("Provide Name, if not available press Enter: ");
                String newName = in.nextLine();
                if(!newName.equals(null)){
                    System.out.print("Provide Age, if not available press Enter: ");
                    String newAge = in.nextLine();
                    if(!newAge.equals(null)){
                        System.out.print("Provide Contact No., if not available press Enter: ");
                        String newContact = in.nextLine();
                        if(!newContact.equals(null)){
                            user = new User(newUName,newPword,newName,newAge,newContact);
                            userInfo.put(user.getUsername(), user);
                            continue;
                        }
                        else{
                            user = new User(newUName,newPword,newName,newAge);
                            userInfo.put(user.getUsername(), user);
                            continue;
                        }
                    }
                    else{
                        user = new User(newUName,newPword,newName);
                        userInfo.put(user.getUsername(), user);
                        continue;
                    }
                }
                else{
                    user = new User(newUName,newPword);
                    userInfo.put(user.getUsername(), user);
                    continue;
                }
                                
            }
            else{
                System.out.print("Invalid Choice!");
                continue;
            }

            System.out.print("Do you wish to continue? (y/n)");
            String nl3 = in.nextLine();
            String wContinue = in.nextLine();
            if(wContinue.equals("Y") || wContinue.equals("y")){
                wantContinue = true;
            }
            else{
                wantContinue = false;
            }    

        }

    }
}

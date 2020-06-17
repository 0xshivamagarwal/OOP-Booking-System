package Sys;

import java.util.HashMap;

public interface UserInterface {

	public String getPassword();

    public String getUsername();
    
    public void changePassword(String oldpassword);
    
    public void setContactNo(String contactNo);
    
    public String getContactNo();

	public HashMap<Integer, BookingInterface> getBookingHistory();

	public void createBooking(int id, BookingInterface booking);

}

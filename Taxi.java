package Reservation;

public class Taxi extends Vehicle{
	
	public boolean isAvailable;
	
	public Taxi(String vehicleID, String cityName){
		super(cityName,vehicleID,true);
		this.isAvailable = true;
	}

	public Taxi(boolean ac, String cityName, String vehicleID){
		super(companyName,vehicleID,ac);
		this.isAvailable = true;
	}

	public boolean getisAvailable(){
		return this.isAvailable;
	}
	public void bookTaxi(int distance){
		if(this.isAvailable){
			this.isAvailable = false;
			System.out.println("The taxi is booked");
			System.out.println("Your fare is "+ this.getFare(distance));
		}
		else{
			System.out.println("Taxi booking failed");
		}
	}
	public void offloadtaxi(){
		this.isAvailable = true;
	}
	public String getCityName() {
		return companyName;
	}
	public String getvehicleID(){
		return vehicleID;
	}
	public int getFare(int distance){
		if(ac){
			return distance*15;
		}
		else{
			return distance*9;
		}
	}


}
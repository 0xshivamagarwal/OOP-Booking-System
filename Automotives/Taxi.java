package Automotives;

public class Taxi extends Vehicle{
	public boolean isAvailable;
	public Taxi(String vehicleID, String cityName){
		super(cityName,vehicleID,true);
		this.isAvailable = true;
	}

	public Taxi(boolean ac, String cityName, String vehicleID){
		super(cityName,vehicleID,ac);
		this.isAvailable = true;
	}

	public boolean getisAvailable(){
		return this.isAvailable;
	}
	public void offloadtaxi(){
		this.isAvailable = true;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getvehicleID(){
		return vehicleID;
	}
	
	public static class ac_taxi{
		private int rate = 15;
		public int getrate(){
			return rate;
		}
	}

	public class nonac_taxi{
		private int rate = 10;
		public int getrate(){
			return rate;
		}
	}

	public int getFare(int distance){
		if(ac){
			return distance*ac_taxi.getrate();
		}
		else{
			nonac_taxi obj = new nonac_taxi()
			return distance*obj.getrate();
		}
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
}

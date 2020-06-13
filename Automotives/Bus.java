package Automotives;

public class Bus extends Vehicle{
	protected int fare;
	protected char source;
	protected char destination;
	protected String startTime;
	protected String endTime;
	protected  boolean[] frequency; // [Su, M, T, W, Th, F, Sat] 
	protected int capacity;
	protected int reservedSeats;


	public Bus(String companyName, String vehicleID, char source, char destination, String startTime,
			String endTime, boolean[] frequency){
		super(companyName,vehicleID,true);
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
		this.capacity = 100;
		this.reservedSeats = 0;
		this.setfare();
	}
	public Bus(boolean ac, String companyName, String vehicleID, char source, char destination, String startTime,
			String endTime, boolean[] frequency){
		super(companyName,vehicleID,ac);
		this.source = source;
		this.destination = destination;
		this.startTime = startTime;
		this.endTime = endTime;
		this.frequency = frequency;
		this.capacity = 100;
		this.reservedSeats = 0;
		this.setfare();
	}

	public int getfare(){
		return this.fare;
	}
	public char getSource() {
		return source;
	}
	public char getDestination() {
		return destination;
	}
	public String getStartTime() {
		return startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public boolean[] getFrequency() {
		return frequency;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getReservedSeats() {
		return reservedSeats;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getvehicleID(){
		return vehicleID;
	}
	public static class ac_bus{
		private int rate = 500;
		public int getrate(){
			return rate;
		}
	}

	public class nonac_bus{
		private int rate = 250;
		public int getrate(){
			return rate;
		}
	}	
	public boolean bookseats(int numofseats){
		if(this.capacity - this.reservedSeats >= numofseats){
			this.reservedSeats = this.reservedSeats + numofseats;
			System.out.println("Your fare was "+ this.getfare())
			return true;
		}
		return false;
	}
	private void setfare(){
		char[] ch = {'A', 'B', 'C', 'D', 'E'};
		int src=-1; int dst=-1;
			for(int i = 0; i < 5; i++){
				if(ch[i]==this.source)	src = i;
				if(ch[i]==this.destination)	dst = i;
			}
		int distance = abs(src - dst);
		if(ac){
			this.fare = distance * ac_bus.getrate();
		}
		else{
			nonac_bus obje = new nonac_bus();
			this.fare = distance * obje.getrate()
		}
	}
}

package Automotives;

public interface NonACBus {
	
	double rate = 1.0; // Rs per Kilometer
	
	public static double getRate() {//returns Rate
		return NonACBus.rate;
	}

}
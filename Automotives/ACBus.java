package Automotives;

public interface ACBus {
	
	double rate = 1.5; // Rs per Kilometer
	
	public static double getRate() {//Returns rate
		return ACBus.rate;
	}

}
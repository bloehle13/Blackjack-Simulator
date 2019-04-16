package application;

import java.io.Serializable;

public class BetPercentage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//can bet 1x, 2x, 3x, 4x, or 5x
	private double betFactors[] = {1.0, 1.0, 1.0, 1.0, 1.0};

	
	public BetPercentage() { 
		
	}


	public double[] getFactors() {
		return betFactors;
	}


	public void setFactors(double[] betFactors) {
		this.betFactors = betFactors;
	}
	
	public double calcSum() {
		double sum = 0;
		for(double x:betFactors) {
			sum += x;
		}
		return sum;
	}
	
	

	
}



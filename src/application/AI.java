package application;

import java.util.HashMap;


public class AI {
	
	private HashMap<Integer, BetPercentage> bets;
	private boolean isLearning;
	private int betFactor;
	
	
	public AI(boolean isLearning) {
		bets = DataUtility.loadHashMap();
		this.isLearning = isLearning;
		betFactor = 1;
	}
	
	public int computeBet(int streak) {
		betFactor = 1;
		
		if(isLearning) {
			if(bets.containsKey(streak)) {
				double percentSum = bets.get(streak).calcSum();
            	//will return a number within our probability range
            	double selectedSpace = Math.random() * percentSum;
            	
            	//keep subtracting a spaces probability until it is less than the random number
            	//another way to choose randomly while factoring in probability
            	double[] factors = bets.get(streak).getFactors();
            	for(int i = 0; i < factors.length; i++) {
            		if(selectedSpace < factors[i]) {
            			betFactor = i+1;
            			break;
            		}else {
            			selectedSpace -= factors[i];
            		}
            	}
				
				
			}else {
				betFactor = (int)(Math.random() * 5) + 1;
			}
			
		}else {
			if(bets.containsKey(streak)) {	
            	//keep subtracting a spaces probability until it is less than the random number
            	//another way to choose randomly while factoring in probability
            	double[] factors = bets.get(streak).getFactors();
            	double max = factors[0];
            	for(int i = 1; i < factors.length; i++) {
            		if(factors[i] > max) {
            			betFactor = i+1;
            			max = factors[i];
            		}
            	}
				
				
			}else {
				betFactor = (int)(Math.random() * 5) + 1;
			}
		}
		
		
		
		if (betFactor == 0) {
			return betFactor + 1;
		}
		
		return betFactor;
	}
	
    public void learn(int streak, double score) {
    	if(isLearning) {
    		BetPercentage bp = null;
    		if(bets.containsKey(streak)) {
    			bp = bets.get(streak);
    		}else {
    			bp = new BetPercentage();
    		}
    		double[] factors = bp.getFactors();
    		factors[betFactor-1] = factors[betFactor-1]*(1-0.01) + score*1.001;  // Set alpha to something like 0.01
    		//don't need this line, 
    		bets.put(streak, bp);  // add the board state and percentages back to the hashtable
    		
    	}
    }
    

	public HashMap<Integer, BetPercentage> getBets() {
		return bets;
	}

	public void setBets(HashMap<Integer, BetPercentage> bets) {
		this.bets = bets;
	}

	public int getBetFactor() {
		return betFactor;
	}

	public void setBetFactor(int betFactor) {
		this.betFactor = betFactor;
	}
    
    

}

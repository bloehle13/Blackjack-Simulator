package application;
import java.util.ArrayList;
import java.util.Collections;

public class Sleeve {
	
	private int decks;
	private double depth; //how many cards until reshuffling
	private ArrayList<Card> sleeve;
	
	public Sleeve(int decks, double depth) {
		this.decks = decks;
		this.depth = depth;
		this.sleeve = new ArrayList<Card>();
		
		initSleeve();
	}
	
	/**
	 * initialize sleeve with proper amount of decks and shuffle them all
	 */
	public void initSleeve() {
		for(int i = 0; i < decks; i++) {
			sleeve.addAll(new Deck().getDeck());
		}
		
		Collections.shuffle(sleeve);
		System.out.println("Size of Sleeve: " + sleeve.size());
	}
	
	public Card giveCard() {
		Card card = sleeve.get(0);
		sleeve.remove(0);
		return card;
	}
	
	public boolean needsShuffling() {
		if((double)sleeve.size() / (52 * decks) <= (1-depth)) {
			return true;
		}else return false;
	}

	public int getDecks() {
		return decks;
	}

	public double getDepth() {
		return depth;
	}

	public ArrayList<Card> getSleeve() {
		return sleeve;
	}
	
	
	
	

}

package application;

public class Card {
	
	private int val; //numeric value
	private char suit; 
	private char card; //JQKA or N for number
	
	public Card(int val, char suit, char card) {
		this.val = val;
		this.suit = suit;
		this.card = card;
	}

	public int getVal() {
		return val;
	}

	public char getSuit() {
		return suit;
	}

	public char getCard() {
		return card;
	}
	
	

}

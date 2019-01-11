package application;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	private ArrayList<Card> deck;
	
	public Deck() {
		deck = new ArrayList<Card>();
		initDeck();
	}
	
	/**
	 * initializes deck with 52 cards, then shuffles
	 */
	private void initDeck() {
		int index = 0;
		for(int i = 0; i < 13; i++) {//a loop for each card type... ace, 1, 2...king
			if(i == 0) {//aces
				deck.add(new Card(11, 'C', 'A'));
				deck.add(new Card(11, 'S', 'A'));
				deck.add(new Card(11, 'D', 'A'));
				deck.add(new Card(11, 'H', 'A'));
			}
		     else if(i < 10 && i > 0) {//not on face card yet
				deck.add(new Card(i+1, 'C', 'N'));
				deck.add(new Card(i+1, 'S', 'N'));
				deck.add(new Card(i+1, 'D', 'N'));
				deck.add(new Card(i+1, 'H', 'N'));
			}else if(i == 10){//jacks
				deck.add(new Card(10, 'C', 'J'));
				deck.add(new Card(10, 'S', 'J'));
				deck.add(new Card(10, 'D', 'J'));
				deck.add(new Card(10, 'H', 'J'));
			}else if(i == 11){//queens
				deck.add(new Card(10, 'C', 'Q'));
				deck.add(new Card(10, 'S', 'Q'));
				deck.add(new Card(10, 'D', 'Q'));
				deck.add(new Card(10, 'H', 'Q'));
			}else if(i == 12){//kings
				deck.add(new Card(10, 'C', 'K'));
				deck.add(new Card(10, 'S', 'K'));
				deck.add(new Card(10, 'D', 'K'));
				deck.add(new Card(10, 'H', 'K'));
			}
		}
		
		Collections.shuffle(deck);
		//printDeck();
	}
	
	
	
	public ArrayList<Card> getDeck() {
		return deck;
	}

	private void printDeck() {
		for(int i = 0; i < deck.size(); i++) {
			System.out.println(deck.get(i).getCard() + " " + deck.get(i).getSuit() + " " + deck.get(i).getVal());
		} 
		
		System.out.println("Total Cards: " + deck.size());
	}

}

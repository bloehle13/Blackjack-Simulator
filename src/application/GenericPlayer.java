package application;
import java.util.ArrayList;

public abstract class GenericPlayer {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	private int sum = 0;
	
	public Card hit(Sleeve sleeve) {
		Card card = sleeve.giveCard();
		if(card.getCard() == 'A') {//ace dealt
			sum += playAce(card);
		}else {
			sum += card.getVal();
		}
		hand.add(card);
		
		return card;
	}


	public ArrayList<Card> getHand() {
		return hand;
	}
	
	public int getSum() {
		return sum;
	}
	
	
	public void setSum(int sum) {
		this.sum = sum;
	}

	protected void initHand() {
		sum = hand.get(0).getVal() + hand.get(1).getVal();
	}
	
	/**
	 * Accounts for the ace having two values
	 * @param card the card dealt, obviously being an ace
	 * @return whether to play it as an 11 or 1
	 */
	protected int playAce(Card card) {
		int amt = 11;
		if(sum + 11 > 21) {
			amt = 1;
		}
		return amt;
	}
	
	
	
	

}

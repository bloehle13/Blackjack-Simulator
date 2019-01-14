package application;

public class Dealer extends GenericPlayer{
	
	private boolean s17 = false; 

	public Dealer() {

	}

	
	public void playHand(Sleeve sleeve) {
		Card upCard = getHand().get(0);
		Card downCard = getHand().get(1);
		Card card = null;//the card that was just hit, if applicable
		setSum(upCard.getVal() + downCard.getVal());
		
		System.out.println("Dealer has: " + getHand().get(0).getCard() + getHand().get(0).getSuit() + getHand().get(0).getVal() + " " + getHand().get(1).getCard() + getHand().get(1).getSuit() + getHand().get(1).getVal());
		System.out.println("Dealer sum: " + getSum());
		
		while(getSum() <= 17) {
			System.out.println("------");
			if(getSum() == 17) {
				if(getHand().size() == 2 && (upCard.getCard() == 'A' || downCard.getCard() == 'A')) {//checks for an ace in initial hand
					if(getSum() == 17 && !s17) {//dealer hits on soft 17
						System.out.println("Hittin on soft 17");
						card = hit(sleeve);
						System.out.println("Dealer gets: " + card.getCard() + card.getSuit() + card.getVal());
						System.out.println("Dealer sum: " + getSum());
					}
				}else {//normal 17
					break;
				}
			}else {
				card = hit(sleeve);
				System.out.println("Dealer gets: " + card.getCard() + card.getSuit() + card.getVal());
				System.out.println("Dealer sum: " + getSum());
			}
		}
		
	}
	
	
}

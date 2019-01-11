package application;

public class Player extends GenericPlayer{
	
	private Dealer dealer;
	private boolean playing;
	
	public Player(Dealer dealer) {
		this.dealer = dealer;
		this.playing = true;
	}
	
	public void playHand(Sleeve sleeve) {
		Card dUpCard = dealer.getHand().get(0);
		Card card1 = getHand().get(0);
		Card card2 = getHand().get(1);
		int sum = card1.getVal() + card2.getVal();
		while(playing) {
			if((card1.getCard() == card2.getCard()) && (card1.getVal() == card2.getVal()) && (card1.getVal() != 10)) {//2-9 or ace pair
				
			}else if(card1.getCard() == 'A' || card2.getCard() == 'A') {//soft totals
				switch(sum) {
				
				}
			}else{//normal total
				switch(sum) {
				case 9:
					if(dUpCard.getVal() == 2) {
						hit(sleeve);
					}else if(dUpCard.getVal() > 2 && dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
				case 10:
					if(dUpCard.getVal() < 10) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
				case 11:
					doubleDown(sleeve);
				case 12:
					if(dUpCard.getVal() == 2 || dUpCard.getVal() == 3) {
						hit(sleeve);
					}else if(dUpCard.getVal() > 3 && dUpCard.getVal() < 7) {
						stand(sleeve);
					}else {
						hit(sleeve);
					}
				case 13:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else {
						hit(sleeve);
					}
				case 14:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else {
						hit(sleeve);
					}
				case 15:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else if(dUpCard.getVal() > 6 && dUpCard.getVal() < 10) {
						hit(sleeve);
					}else {
						surrender(sleeve);
					}
				case 16:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else if(dUpCard.getVal() > 6 && dUpCard.getVal() < 9) {
						hit(sleeve);
					}else {
						surrender(sleeve);
					}
				case 17:
					if(dUpCard.getVal() < 11) {
						stand(sleeve);
					}else {
						surrender(sleeve);
					}
				case 18:
					stand(sleeve);
				case 19:
					stand(sleeve);
				case 20:
					stand(sleeve);
				case 21:
					blackjack(sleeve);
				default://4-8
					hit(sleeve);
				}
				
				
			}
			
		}
	}
	
	public void doubleDown(Sleeve sleeve) {
		
	}
	
	public void split(Sleeve sleeve) {
		
	}
	
	public void surrender(Sleeve sleeve) {
		
	}
	
	public void blackjack(Sleeve sleeve) {
		
	}

}

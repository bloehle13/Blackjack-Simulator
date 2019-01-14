package application;

public class Player extends GenericPlayer{
	
	private Dealer dealer;
	private boolean playing;
	private boolean initHand;//helps identify if player has not hit yet
	
	public Player(Dealer dealer) {
		this.dealer = dealer;
		this.playing = true;
		this.initHand = true;
	}
	
	public void playHand(Sleeve sleeve) {
		Card dUpCard = dealer.getHand().get(0);
		Card card1 = getHand().get(0);
		Card card2 = getHand().get(1);
		System.out.println("Dealer showing: " + dUpCard.getCard() + dUpCard.getSuit() + dUpCard.getVal());
		while(playing) {
			System.out.println("Player has: " + getHand().get(0).getCard() + getHand().get(0).getSuit() + getHand().get(0).getVal() + " " + getHand().get(1).getCard() + getHand().get(1).getSuit() + getHand().get(1).getVal());
			System.out.println("Player sum: " + getSum());
			if((card1.getCard() == card2.getCard()) && (card1.getVal() == card2.getVal()) && (card1.getVal() != 10) && initHand) {//pair of 2-9 or ace
				switch(card1.getVal()) {
				case 2:
					if(dUpCard.getVal() < 8) {
						split(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 3:
					if(dUpCard.getVal() < 8) {
						split(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 4:
					if(dUpCard.getVal() > 4 || dUpCard.getVal() < 7) {
						split(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 5:
					doubleDown(sleeve);
					break;
				case 6:
					if(dUpCard.getVal() < 7) {
						split(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 7:
					if(dUpCard.getVal() < 8) {
						split(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 8:
					if(dUpCard.getVal() < 11) {
						split(sleeve);
					}else {
						surrender(sleeve);
					}
					break;
				case 9:
					if(dUpCard.getVal() == 7 || dUpCard.getVal() > 9) {
						stand(sleeve);
					}else {
						split(sleeve);
					}
					break;
				case 10:
					stand(sleeve);
					break;
				case 11:
					split(sleeve);
					break;
				
				}
				
			}else if((card1.getCard() == 'A' || card2.getCard() == 'A') && initHand) {//soft totals
				switch(getSum()) {
				case 13:
					if(dUpCard.getVal() > 4 && dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 14:
					if(dUpCard.getVal() > 4 && dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 15:
					if(dUpCard.getVal() > 3 && dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 16:
					if(dUpCard.getVal() > 3 && dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 17:
					if(dUpCard.getVal() > 2 && dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 18:
					if(dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else if(dUpCard.getVal() > 6 && dUpCard.getVal() < 9) {
						stand(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 19:
					if(dUpCard.getVal() == 6) {
						doubleDown(sleeve);
					}else {
						stand(sleeve);
					}
					break;
				case 20:
					stand(sleeve);
					break;
				case 21:
					blackjack(sleeve);
					break;
				}
			}else{//normal total
				switch(getSum()) {
				case 4://intentional cascading
				case 5:
				case 6:
				case 7:
				case 8:
					hit(sleeve);
					break;
				case 9:
					if(dUpCard.getVal() > 2 && dUpCard.getVal() < 7) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 10:
					if(dUpCard.getVal() < 10) {
						doubleDown(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 11:
					doubleDown(sleeve);
					break;
				case 12:
					if(dUpCard.getVal() > 3 && dUpCard.getVal() < 7) {
						stand(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 13:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 14:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else {
						hit(sleeve);
					}
					break;
				case 15:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else if(dUpCard.getVal() > 6 && dUpCard.getVal() < 10) {
						hit(sleeve);
					}else {
						surrender(sleeve);
					}
					break;
				case 16:
					if(dUpCard.getVal() < 7) {
						stand(sleeve);
					}else if(dUpCard.getVal() > 6 && dUpCard.getVal() < 9) {
						hit(sleeve);
					}else {
						surrender(sleeve);
					}
					break;
				case 17:
					if(dUpCard.getVal() < 11) {
						stand(sleeve);
					}else {
						surrender(sleeve);
					}
					break;
				case 18:
					stand(sleeve);
					break;
				case 19:
					stand(sleeve);
					break;
				case 20:
					stand(sleeve);
					break;
				default://4-8
					bust(sleeve);
					break;
				}
				
				
			}
			
			initHand = false;
			
		}
	}
	
	public void stand(Sleeve sleeve) {
		System.out.println("Player is standing");
		playing = false;
	}
	
	public void doubleDown(Sleeve sleeve) {
		System.out.println("Player is doubling down");
		playing = false;
		
	}
	
	public void split(Sleeve sleeve) {
		System.out.println("Player is splitting");
		playing = false;
	}
	
	public void surrender(Sleeve sleeve) {
		System.out.println("Player is surrendering");
		playing = false;
	}
	
	public void blackjack(Sleeve sleeve) {
		System.out.println("Player has blackjack!");
		playing = false;
		
	}
	
	public void bust(Sleeve sleeve) {
		System.out.println("Player has busted");
		playing = false;
		
	}

}

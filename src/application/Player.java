package application;

public class Player extends GenericPlayer{
	
	private Dealer dealer;
	private boolean playing;
	private boolean initHand;//helps identify if player has not hit yet
	private boolean surrendered;
	private boolean blackjack;
	private boolean doubledDown;
	private double money;
	private int bet;
	
	public Player(Dealer dealer, double money, int bet) {
		this.dealer = dealer;
		this.playing = true;
		this.initHand = true;
		this.surrendered = false;
		this.blackjack = false;
		this.doubledDown = false;
		this.money = money;
		this.bet = bet;
	}
	
	/**
	 * 
	 * @param sleeve
	 * @return the sum of the cards
	 */
	public int playHand(Sleeve sleeve) {
		Card dUpCard = dealer.getHand().get(0);
		Card card1 = getHand().get(0);
		Card card2 = getHand().get(1);
		System.out.println("Dealer showing: " + dUpCard.getCard() + dUpCard.getSuit() + dUpCard.getVal());
		while(playing) {
			
			if(surrendered) {
				surrendered = false;
				return -1;
			}
			
			if(blackjack) {
				blackjack = false;
				return 100;
			}
			
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
		
		playing = true;
		return getSum();
	}
	
	public void resetDoubledDown() {
		if(doubledDown) {
			this.doubledDown = false;
			bet /= 2;
		}
	}
	
	public void winMoney(double amt) {
		System.out.println("Player wins $" + amt);
		this.money += amt;
	}
	
	public void bet() {
		this.money -= this.bet;
	}
	
	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getBet() {
		return bet;
	}

	public void setBet(int bet) {
		this.bet = bet;
	}

	public void stand(Sleeve sleeve) {
		System.out.println("Player is standing");
		playing = false;
	}
	
	public void doubleDown(Sleeve sleeve) {
		System.out.println("Player is doubling down");
		Card card = hit(sleeve);
		System.out.println("Player gets: " + card.getCard() + card.getSuit() + card.getVal());
		System.out.println("Player sum: " + getSum());
		money -= bet;
		bet *= 2;
		playing = false;
		doubledDown = true;
		
	}
	
	public void split(Sleeve sleeve) {
		System.out.println("Player is splitting");
		playing = false;
	}
	
	public void surrender(Sleeve sleeve) {
		System.out.println("Player is surrendering");
		surrendered = true;
		playing = false;
	}
	
	public void blackjack(Sleeve sleeve) {
		System.out.println("Player has blackjack!");
		playing = false;
		blackjack = true;
		
	}
	
	public void bust(Sleeve sleeve) {
		System.out.println("Player has busted");
		playing = false;
		
	}
	

}

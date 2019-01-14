package application;

public class Blackjack {
	
	private Sleeve sleeve;
	private Dealer dealer;
	private Player player;

	public Blackjack() {
		this.sleeve = new Sleeve(8, 0.75);
		this.dealer = new Dealer();
		this.player = new Player(dealer);
	}
	
	public void dealHand() {
		player.getHand().add(sleeve.giveCard());
		dealer.getHand().add(sleeve.giveCard());
		player.getHand().add(sleeve.giveCard());
		dealer.getHand().add(sleeve.giveCard());
		player.initHand();
	}
	
	public void play() {
		player.playHand(sleeve);
		dealer.playHand(sleeve);
	}

}

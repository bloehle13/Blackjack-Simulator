package application;

public class Blackjack {
	
	private Sleeve sleeve;
	private Dealer dealer;
	private Player player;

	public Blackjack() {
		this.sleeve = new Sleeve(8, 0.75);
		this.dealer = new Dealer();
		this.player = new Player(dealer, 200, 5);
	}
	
	public void dealHand() {
		player.bet();
		player.getHand().add(sleeve.giveCard());
		dealer.getHand().add(sleeve.giveCard());
		player.getHand().add(sleeve.giveCard());
		dealer.getHand().add(sleeve.giveCard());
		player.initHand();
	}
	
	public void reset() {
		player.clearHand();
		player.resetDoubledDown();
		dealer.clearHand();
		dealHand();
	}
	
	public void play() {
		int pSum = player.playHand(sleeve);
		
		//Scenarios where dealer does not need to play
		if(pSum == -1) {//surrendered, dealer need not play
			System.out.println("Player Surrenders");
			player.winMoney((double)player.getBet() / 2);
			System.out.println("Player Money: " + player.getMoney());
			return;
		}else if(pSum == 100) {//blackjack
			System.out.println("Player Hits Blackjack");
			player.winMoney((double)player.getBet() * 2.5);
			System.out.println("Player Money: " + player.getMoney());
			return;
		}else if(pSum > 21) {//busted
			//nothing, player lost
			System.out.println("Player Busts");
			System.out.println("Player Money: " + player.getMoney());
			return;
		}
		
		//dealer must play now
		int dSum = dealer.playHand(sleeve);
		
		if(dSum > 21) {
			System.out.println("Dealer Busts");
			player.winMoney((double)player.getBet() * 2);
		}else if(pSum > dSum) {//win
			System.out.println("Player Wins");
			player.winMoney((double)player.getBet() * 2);
		}else if(pSum == dSum) {//push
			System.out.println("Player Pushes");
			player.winMoney((double)player.getBet());
		}else {//lost
			//nothing, player lost
			System.out.println("Player Loses");
		}
		
		System.out.println("Player Money: " + player.getMoney());
	}

}

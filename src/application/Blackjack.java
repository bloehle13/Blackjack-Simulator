package application;

import java.util.ArrayList;

public class Blackjack {
	
	private Sleeve sleeve;
	private Dealer dealer;
	private Player player;
	private ArrayList<Integer> pSums = new ArrayList<Integer>();
	private boolean readyForDealer = true;
	public static int HANDS = 9000000;
	public static int HANDS_PLAYED = 0;
	public static double STARTING_AMT = 1000;
	public static int BETTING_AMT = 5;

	public Blackjack() {
		this.sleeve = new Sleeve(8, 0.75);
		this.dealer = new Dealer();
		this.player = new Player(dealer, STARTING_AMT, BETTING_AMT, null);
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
		player.reset();
		dealer.clearHand();
		readyForDealer = true;
		
		if(sleeve.needsShuffling()) {
			sleeve.shuffle();
		}
	}
	
	/**
	 * stores the percent increase in money and longest streak
	 */
	public void saveData() {
		DataUtility.data.add(new String[]{String.valueOf(player.getMoney() / STARTING_AMT), String.valueOf(player.getLongestStreak())});
	}
	
	public void play() {
		pSums.add(player.playHand(sleeve));
		handleSplits();
		
		for(int i = 0; i < pSums.size(); i++) {
			int pSum = pSums.get(i);
			//Scenarios where dealer does not need to play
			if(pSum == -1) {//surrendered, dealer need not play
				System.out.println("Player Surrenders");
				player.winMoney((double)player.getBet() / 2);
				player.adjustStreak(false);
				player.learn(0.5);
				System.out.println("Player Money: " + player.getMoney());
				pSums.remove(i);
				return;
			}else if(pSum == 100) {//blackjack
				System.out.println("Player Hits Blackjack");
				player.winMoney((double)player.getBet() * 2.5);
				player.adjustStreak(true);
				player.learn(1.0);
				System.out.println("Player Money: " + player.getMoney());
				pSums.remove(i);
				return;
			}else if(pSum > 21) {//busted
				//nothing, player lost
				System.out.println("Player Busts");
				player.adjustStreak(false);
				player.learn(0.0);
				System.out.println("Player Money: " + player.getMoney());
				pSums.remove(i);
				return;
			}

		}
		
		int dSum = -1;
		if(readyForDealer) {
			//dealer must play now
			dSum = dealer.playHand(sleeve);
			readyForDealer = false;
		}
		
		for(int i = 0; i < pSums.size(); i++) {
			int pSum = pSums.remove(pSums.size() - 1);
			//Scenarios where dealer does not need to play
			if(pSum == -1) {//surrendered, dealer need not play
				System.out.println("Player Surrenders");
				player.winMoney((double)player.getBet() / 2);
				player.adjustStreak(false);
				player.learn(0.5);
				System.out.println("Player Money: " + player.getMoney());
				return;
			}else if(pSum == 100) {//blackjack
				System.out.println("Player Hits Blackjack");
				player.winMoney((double)player.getBet() * 2.5);
				player.adjustStreak(true);
				player.learn(1.0);
				System.out.println("Player Money: " + player.getMoney());
				return;
			}else if(pSum > 21) {//busted
				//nothing, player lost
				System.out.println("Player Busts");
				player.adjustStreak(false);
				player.learn(0.0);
				System.out.println("Player Money: " + player.getMoney());
				return;
			}
			
			if(dSum != -1) {
				if(dSum > 21) {
					System.out.println("Dealer Busts");
					player.winMoney((double)player.getBet() * 2);
					player.adjustStreak(true);
					player.learn(1.0);
				}else if(pSum > dSum) {//win
					System.out.println("Player Wins");
					player.winMoney((double)player.getBet() * 2);
					player.adjustStreak(true);
					player.learn(1.0);
				}else if(pSum == dSum) {//push
					System.out.println("Player Pushes");
					player.winMoney((double)player.getBet());
					player.learn(0.5);
				}else{//lost
					//nothing, player lost
					System.out.println("Player Loses");
					player.adjustStreak(false);
					player.learn(0.0);
				}
			}
			
			System.out.println("Player Money: " + player.getMoney());
			i--;
		}
		
	}
	
	private void handleSplits() {
		if(player.hasSplit()) {
			readyForDealer = false;
			player.clearHand();
			player.setSum(0);
			//get a split card and another from the deck
			player.getHand().add(player.getSplitCards().pop());
			player.getHand().add(sleeve.giveCard());
			player.bet();
			System.out.println("Player splits and and now has " + player.getMoney());
			player.initHand();
			if(player.getSplitCards().size() == 0) {
				player.resetHasSplit();
			}
			play();
		}else {
			readyForDealer = true;
		}
	}
	
	public Player getPlayer() {
		return player;
	}

}

package assets;

import superClasses.Aspect;
import superClasses.Game;

public class Bed extends Aspect {
	Coins coins;
	
	public Bed(){
		this.name = "bed";
		this.coins = new Coins();
	}
	
	protected boolean examine(){
		if( this.coins != null ){
			System.out.println("An old smelly bed. You find a bag of coins underneath it!");
			Game.player.inventory.add(coins);
			this.coins = null;
		} else {
			System.out.println("An old smelly bed.");
		}
		return true;
	}
}

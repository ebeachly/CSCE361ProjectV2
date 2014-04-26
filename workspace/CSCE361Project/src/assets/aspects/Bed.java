package assets.aspects;

import assets.items.Coins;
import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;

public class Bed extends Aspect {
	Coins coins;
	
	public Bed(){
		this.name = "bed";
		this.coins = new Coins();
	}
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		} else if( action.equals("sleep")){
			return this.sleep();
		}
		return false;
	}
	
	private boolean sleep(){
		System.out.println("You sleep in the bed for a bit.\n You wake up a while later and feel really itchy.");
		return true;
	}
	
	protected boolean examine(){
		if( this.coins != null ){
			System.out.println("It's an old smelly bed. You find a bag of coins underneath it!");
			Game.player.inventory.add(coins);
			this.coins = null;
		} else {
			System.out.println("It's an old smelly bed.");
		}
		return true;
	}
}

package assets;

import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;

public class Coins extends Item {
	
	public Coins(){
		this.name = "coins";
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("buy")) {
			if(target.name.equals("shield")){
				Game.player.inventory.remove("coins");
				Game.player.pickUp("shield");
				Merchant.shield = null;
			}
		}
		return false;
	}
	public boolean examine() {
		System.out.println("A bag of coins.");
		return true;
	}

}

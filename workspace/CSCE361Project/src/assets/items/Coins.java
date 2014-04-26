package assets.items;

import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;
import superClasses.World;

public class Coins extends Item {
	
	public Coins(){
		this.name = "coins";
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("buy") && Game.player.currentLocation.equals(World.nwField) && World.nwField.merchant.shield != null) {
			if(target != null && target.name.equals("shield")){
				Game.player.inventory.remove(this);
				Game.player.inventory.add(World.nwField.merchant.shield);
				World.nwField.merchant.shield = null;
				World.nwField.aspects.remove(World.nwField.shield);
				System.out.println("You bought a shield from the merchant.");
				return true;
			}
		}
		return false;
	}
	
	public boolean examine() {
		System.out.println("A bag of coins.");
		return true;
	}

}

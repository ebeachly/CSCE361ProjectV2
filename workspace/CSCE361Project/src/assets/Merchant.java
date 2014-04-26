package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;

public class Merchant extends Aspect {

	public Shield shield;
	public Merchant() {
		this.name = "merchant";
		this.shield = new Shield();
	}
	
	@Override
	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		}
		return false;
	}
	protected boolean examine() {
		System.out.println("A rotund man with a beard, and "
				+ "wearing a green cloak. He is standing next to his wagon and pointing at a sign"+
				"that reads: \" Shield for sale\".");
		return true;
	}
	public boolean damage(Item weapon){
		System.out.println("You tried to attack the merchant.\n"+
		"He responds with a storm of lightning bolts killing you.");
		Game.hasLost = true;
		return true;
	}
	public boolean give(Interactable target) {
		if (target != null && target instanceof Coins) {
			Game.player.inventory.remove(this);
			Game.player.inventory.add(this.shield);
			this.shield = null;
			System.out.println("You bought a shield from the merchant.");
			return true;
		}
		return false;
	}
}


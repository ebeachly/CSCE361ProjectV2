package assets.aspects;

import assets.items.Map;
import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;

public class Mailbox extends Aspect {

	private Map map;
	public Mailbox() {
		this.name = "mailbox";
		this.map = new Map();
	}
	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		}else if (action.equals("open")){
			Game.player.inventory.add(this.map);
			this.map = null;
			System.out.println("You found a map and placed it in your inventory.");
			return true;
		}
		return false;
	}
	protected boolean examine() {
		if(this.map != null){
			System.out.println("A wooden mailbox in front of the house.\nThere appears to be a map in the mail box.");
			Game.player.inventory.add(this.map);
			this.map = null;
			System.out.println("You found a map and placed it in your inventory.");
		}else{
			System.out.println("An empty wooden mailbox in front of the house.");
		}
		return true;
	}
}


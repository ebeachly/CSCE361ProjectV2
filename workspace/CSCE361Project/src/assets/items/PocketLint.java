package assets.items;

import assets.aspects.Ears;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;
import superClasses.World;

public class PocketLint extends Item {

	public PocketLint() {
		this.name = "pocket lint";
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("put")) {
			return this.put(target);
		} else if (action.equals("remove")) {
			return this.remove(target);
		}
		return false;
	}

	protected boolean eat() {
		System.out.println("You swallow the pocket lint.");
		Game.player.inventory.remove(this);
		return true;
	}

	protected boolean examine() {
		if (this.name.contains("vorpal")) {
			System.out.println("The edges of it seem exceedingly sharp.");
		} else {
			System.out.println("There's nothing special about it.");
		}
		return true;
	}

	protected boolean put(Interactable target) {
		if (target instanceof Ears && World.ears.plug()) {
			System.out.println("You plug your ears with pocket lint.");
			Game.player.inventory.remove(this);
			return true;
		}
		return false;
	}

	protected boolean remove(Interactable target) {
		if (target instanceof Ears && World.ears.unplug()) {
			System.out.println("You can hear again.");
			Game.player.inventory.add(this);
			return true;
		}
		return false;
	}

}

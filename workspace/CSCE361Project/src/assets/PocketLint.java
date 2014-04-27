package assets;

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
		System.out
				.println("A thumb-sized piece of fluff with peculiar sound-absorbtion qualities.");
		return true;
	}

	protected boolean put(Interactable target) {
		if (target instanceof Ears && World.ears.plug(this)) {
			System.out.println("You plug your ears with pocket lint.");
			Game.player.inventory.remove(this);
			return true;
		}
		return false;
	}

	protected boolean remove(Interactable target) {
		if (World.ears.arePlugged()) {
			if (target instanceof Ears && World.ears.unplug()) {
				System.out.println("You can hear again.");
				Game.player.inventory.add(this);
				return true;
			}
		} else {
			System.out.println("There is nothing in your ears.");
		}
		return true;
	}

}

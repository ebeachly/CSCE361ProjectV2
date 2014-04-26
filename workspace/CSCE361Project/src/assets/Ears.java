package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;

public class Ears extends Aspect {

	private boolean plugged = false;
	private PocketLint pocketLint;

	public Ears() {
		name = "ears";
	}

	protected boolean plug(PocketLint pocketLint) {
		plugged = true;
		this.pocketLint = pocketLint;
		return true;
	}

	protected boolean unplug() {
		if (plugged) {
			plugged = false;
			Game.player.inventory.add(this.pocketLint);
			System.out.println("You remove the pocket lint from your ears.");
		}
		return true;
	}

	protected boolean arePlugged() {
		return plugged;
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("unplug")) {
			return this.unplug();
		}
		return false;
	}

}

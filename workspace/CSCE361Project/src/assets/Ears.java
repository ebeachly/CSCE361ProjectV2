package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.World;

public class Ears extends Aspect {

	private boolean plugged = false;
	private PocketLint pocketLint;

	public Ears() {
		name = "ears";
	}

	protected boolean plug(Interactable target) {
		if (target != null) {
			if (!plugged) {
				if (target instanceof PocketLint) {
					plugged = true;
					this.pocketLint = (PocketLint) target;
					World.globalAspects.add(pocketLint);
				} else {
					return false;
				}
			} else {
				System.out.println("There is nothing in your ears.");
			}
		} else {
			System.out.println("SYSTEM: With what?");
		}
		return true;
	}

	protected boolean unplug() {
		if (plugged) {
			plugged = false;
			Game.player.inventory.add(this.pocketLint);
			World.globalAspects.remove(pocketLint);
			System.out.println("You remove the pocket lint from your ears.");
			return true;
		}
		System.out.println("There is nothing in your ears.");
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
		} else if (action.equals("put")) {
			return this.plug(target);
		}
		return false;
	}

}

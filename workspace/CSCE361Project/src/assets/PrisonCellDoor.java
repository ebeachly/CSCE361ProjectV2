package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Location;

public class PrisonCellDoor extends Aspect {
	protected boolean locked = true;
	public Location destination = null;
	private PrisonCellDoor otherSide = null;

	public PrisonCellDoor(Location destination) {
		this.name = "cell door";
		this.destination = destination;
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("go")) {
			return this.goThrough();
		} else if (action.equals("open")) {
			return this.open();
		} else if (action.equals("lock")) {
			return this.lock();
		} else if (action.equals("unlock")) {
			return this.unlock();
		}
		return false;
	}

	public boolean goThrough() {
		// Go through the door
		if (this.locked) {
			System.out.println("The cell door is locked.");
		} else {
			System.out.println("You walk through the cell door.");
			Game.player.currentLocation = this.destination;
			this.destination.printDescription();
		}
		return true;
	}

	public boolean unlock() {
		// This function is what gets called if you try to unlock the door by
		// using the door, instead of using the key on the door
		System.out.println("You need to use a key to unlock the cell door.");
		return true;
	}

	public boolean lock() {
		// This function is what gets called if you try to lock the door by
		// using the door, instead of using the key on the door
		System.out.println("You need to use a key to lock this cell door.");
		return true;
	}

	public boolean open() {
		// Open is just a way to test if the door is locked or not without
		// trying to go through.
		// Having a state of being open or closed is too trivial.
		if (this.locked) {
			System.out.println("The door is locked.");
		} else {
			System.out.println("The door swings open.");
		}
		return true;
	}

	public boolean examine() {
		System.out
				.println("It's a door made out of metal bars and has a sturdy lock with a keyhole.");
		if (this.locked) {
			System.out.println("It is currently locked.");
		} else {
			System.out.println("It is not locked.");
		}
		return true;
	}

	public PrisonCellDoor getOtherSide() {
		// Because Aspects can only exist in Locations, not in between them, you
		// need to have a function to find the other side
		// This function is only necessary for aspects that have states that
		// need to be reflected in both, like locked.
		if (this.otherSide != null) {
			// Has it been found already?
			return this.otherSide;
		} else {
			// This is the first time, so we need to find it.
			for (Aspect a : this.destination.aspects) {
				// The other side has to be of type PrisonCellDoor
				if (a instanceof PrisonCellDoor) {
					PrisonCellDoor temp = (PrisonCellDoor) a;
					// This function will only be called if the player is in the
					// location that this door is in,
					// so we can use that to check if this is the correct door.
					if (temp.destination == Game.player.currentLocation) {
						this.otherSide = temp;
						return this.otherSide;
					}
				}
			}
		}
		System.out.println("ERROR: PrisonCellDoor failed to find other side.");
		return null;
	}
}

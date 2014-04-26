package assets.aspects;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Location;

public class Door extends Aspect{
	private Location destination;
	private String description;

	public Door(String name, Location destination, String description) {
		this.name = name;
		this.destination = destination;
		this.description = description;
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("go")) {
			return this.goThrough();
		} else if (action.equals("open")) {
			return this.open();
		}
		return false;
	}

	public boolean goThrough() {
		// Go through the door
		System.out.println("You walk through the " + this.name);
		Game.player.currentLocation = this.destination;
		this.destination.printDescription();
		return true;
	}
	public boolean open() {
		// Open is just a way to test if the door opens, does not change location
		System.out.println("The door swings open.");
		return true;
	}

	public boolean examine() {
		System.out.println(this.description);
		return true;
	}
}

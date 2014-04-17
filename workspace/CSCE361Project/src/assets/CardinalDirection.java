package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Location;

public class CardinalDirection extends Aspect {

	private Location destination;
	private String description;
	
	public CardinalDirection(String name, Location destination, String description){
		this.name = name;
		this.destination = destination;
		this.description = description;
	}
	
	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("go")) {
			return this.go();
		}
		return false;
	}

	protected boolean go() {
		// Travel in that direction.
		// If the destination is null, then something is blocking the path. Print the description.
		if (this.destination == null) {
			System.out.println(description);
			System.out.println("You can't travel in that direction.");
		} else {
			System.out.println("You travel " + this.name + " for a while.");
			Game.player.currentLocation = this.destination;
			this.destination.printDescription();
		}
		return true;
	}
	
	protected boolean examine(){
		//This should say something like "To the north there is..."
		System.out.println(description);
		return true;
	}
}

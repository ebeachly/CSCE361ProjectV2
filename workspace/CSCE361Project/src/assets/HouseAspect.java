package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.World;

public class HouseAspect extends Aspect {

	public HouseAspect() {
		this.name = "house";
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("go")) {
			return this.goThrough();
		}
		return false;
	}

	public boolean goThrough() {
		// Go through the door
		System.out.println("You walk through the door");
		Game.player.currentLocation = World.house;
		World.house.printDescription();
		return true;
	}

	public boolean examine() {
		System.out.println("A cobblestone house with a steep roof.");
		return true;
	}
}


package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Location;
import superClasses.World;


public class CaveEntrance extends Aspect {

	private Location destination;
	
	public CaveEntrance(Location destination) {
		this.name = "cave entrance";
		this.destination = destination;
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
		// Travel through the cave entrance
		if( this.destination == World.seForest ){
			System.out.println("You exit the cave.");
		} else if( this.destination == World.cave ){
			System.out.println("You enter the cave.");
		}
		Game.player.currentLocation = this.destination;
		this.destination.printDescription();
		return true;
	}
	
	protected boolean examine(){
		if( this.destination == World.seForest ){
			System.out.println("The bright light from the outside is a welcome sight.");
		} else if( this.destination == World.cave ){
			System.out.println("The maw of the cave is black and foetid.");
		}
		return true;
	}
}

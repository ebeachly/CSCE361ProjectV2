package assets.aspects;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Location;
import superClasses.World;

public class Tunnel extends Aspect {
	private Location destination;
	
	public Tunnel(Location destination) {
		this.name = "tunnel";
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
		// Travel through the tunnel
		if( this.destination == World.cave ){
			System.out.println("You crawl through the tunnel.");
		} else if( this.destination == World.jabberwockyLair ){
			System.out.println("You crawl through the tunnel.\n" + 
								"As you do, your eyes adjust to the darkness, and the stench becomes\nalmost unbearable.");
			World.jabberwockyLair.jabberwocky.playerJustEnteredLair = true;
		}
		Game.player.currentLocation = this.destination;
		this.destination.printDescription();
		return true;
	}
	
	protected boolean examine(){
		System.out.println("A low, rocky tunnel between two chambers of the cave.");
		return true;
	}
}

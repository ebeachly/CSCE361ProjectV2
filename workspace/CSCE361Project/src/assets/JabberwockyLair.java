package assets;

import superClasses.Location;
import superClasses.World;

public class JabberwockyLair extends Location {
	
	public void construct() {
		this.aspects.add(new Tunnel(World.cave));
		return;
	}

	public void printDescription() {
		System.out.println( "You are in a smelly, dim chamber of the cave.\n" + 
							"The tunnel you entered by is behind you.\n" +
							"In front of you is the fearsome Jabberwocky!");
		this.printItemsOnGround();
	}
}

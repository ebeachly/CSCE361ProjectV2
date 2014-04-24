package assets;

import superClasses.Location;
import superClasses.World;

public class JabberwockyLair extends Location {
	
	Jabberwocky jabberwocky;
	
	public void construct() {
		this.aspects.add(new Tunnel(World.cave));
		this.jabberwocky = new Jabberwocky();
		this.aspects.add(jabberwocky);
		return;
	}

	public void printDescription() {
		System.out.println( "You are in a smelly, dim chamber of the cave.\n" + 
							"The tunnel you entered by is behind you.");
		if( jabberwocky.alive ){
			System.out.println("In front of you is the loathsome Jabberwocky!");
		} else {
			System.out.println("In front of you is the corpse of the Jabberwocky.");
		}
		this.printItemsOnGround();
	}
}

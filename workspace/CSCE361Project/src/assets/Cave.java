package assets;

import superClasses.Location;
import superClasses.World;

public class Cave extends Location {
	
	public void construct() {
		this.aspects.add(new CaveEntrance(World.seForest));
		this.aspects.add(new Tunnel(World.jabberwockyLair));
		this.droppedItems.add(new Bone());
		return;
	}

	public void printDescription() {
		System.out.println( "You are in a partially lit chamber.\n" + 
							"The cave entrance leads back to the surface.\n" +
							"There is a dark low tunnel in the back of the cave.");
		this.printItemsOnGround();
	}
	
}

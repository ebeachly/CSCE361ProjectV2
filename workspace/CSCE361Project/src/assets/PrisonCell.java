package assets;

import superClasses.World;
import superClasses.Location;

public class PrisonCell extends Location {
	
	public void construct(){
		this.aspects.add(new PrisonCellDoor(World.prisonHallway));
		this.aspects.add(new Guard());
		this.droppedItems.add(new PrisonCellKey());
		return;
	}
	
	public void printDescription(){
		System.out.println("The prison cell is a cold, dirty place.\n"
				+ "The only light in the room filters through the bars in the cell door.");
		this.printItemsOnGround();
	}
	
}

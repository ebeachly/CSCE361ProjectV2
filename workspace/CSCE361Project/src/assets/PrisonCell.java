package assets;

import superClasses.Game;
import superClasses.Location;

public class PrisonCell extends Location {
	
	public PrisonCell(){
		this.aspects.add(Game.world.prisonCellDoor);
		this.droppedItems.add(Game.world.prisonCellKey);
		return;
	}
	
	public void printDescription(){
		System.out.println("The prison cell is a cold, dirty place.\n"
				+ "The only light in the room filters through the bars in the cell door.");
		this.printItemsOnGround();
	}
	
}

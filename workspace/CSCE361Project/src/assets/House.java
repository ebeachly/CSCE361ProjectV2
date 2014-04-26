package assets;

import superClasses.Location;
import superClasses.World;

public class House extends Location {
	
	private Door frontDoor;
	private Door backDoor;
	private Chest chest;

	public void construct() {

		this.frontDoor = new Door("front door", World.cField,
				"A door that leads to the road in front of the house.");
		this.backDoor = new Door("back door", World.sField,
				"A door that leads to the field at the back of the house.");
		this.chest = new Chest();
		
		this.aspects.add(frontDoor);
		this.aspects.add(backDoor);
		this.aspects.add(chest);
		
		this.droppedItems.add(new Coins());
		this.droppedItems.add(new Map());
	}

	public void printDescription() {
		System.out.println("You are in a house. There is a door in the front of the house and a door in the back of the house.");
		this.printItemsOnGround();

	}

}

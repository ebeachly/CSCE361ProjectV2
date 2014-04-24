package assets;

import superClasses.Location;
import superClasses.World;

public class House extends Location {
	
	private Door frontDoor;
	private Door backDoor;

	public void construct() {

		this.frontDoor = new Door("front door", World.cField,
				"A door that leads to the road in front of the house.");
		this.backDoor = new Door("south door", World.sField,
				"A door that leads to the field at the back of the house.");
		
		this.aspects.add(frontDoor);
		this.aspects.add(backDoor);
		
		this.droppedItems.add(new Coins());
		this.droppedItems.add(new Map());
	}

	public void printDescription() {
		System.out.println("You are in a house. There is a door in the north part of the room, and one in the south part of the room.");
		this.frontDoor.examine();
		this.backDoor.examine();

		this.printItemsOnGround();

	}

}

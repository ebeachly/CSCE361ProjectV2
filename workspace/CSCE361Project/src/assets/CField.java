package assets;

import superClasses.Location;
import superClasses.World;

public class CField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;
	private Door frontDoor;
	private Mailbox mailbox;

	public void construct() {

		this.north = new CardinalDirection("north", World.nField,
				"To the north there is an empty field.");
		this.east = new CardinalDirection("east", World.eForest,
				"To the east the road leads into a dense forest.");
		this.south = new CardinalDirection("south", World.sField,
				"To the south there is a house with a field behind it.");
		this.west = new CardinalDirection("west", World.wField,
				"To the west, the road continues toward a large castle.");
		this.frontDoor = new Door("front door", World.house,
				"The wooden door at the front entrance of the house.");
		this.mailbox = new Mailbox();
		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
		this.aspects.add(frontDoor);
		this.aspects.add(new HouseAspect());
		this.aspects.add(mailbox);
	}

	public void printDescription() {
		System.out.println("You are on a road that leads east and west.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();
		System.out.println("There is an old house with a door facing the road.\nThere is a mailbox for the house.");

		this.printItemsOnGround();

	}

}

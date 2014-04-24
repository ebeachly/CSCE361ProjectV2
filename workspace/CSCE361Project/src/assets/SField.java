package assets;

import superClasses.Location;
import superClasses.World;

public class SField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;
	private Door backDoor;

	public void construct() {

		this.north = new CardinalDirection("north", World.cField,
				"To the north there is a road and a house.");
		this.east = new CardinalDirection("east", World.seForest,
				"To the east there is a dense forest.");
		this.south = new CardinalDirection("south", null,
				"To the south there is a deadly cliff that drops off to the sea.");
		this.west = new CardinalDirection("west", World.swField,
				"To the west there is an open field.");
		this.backDoor = new Door("back door", World.house,
				"You see the back door to a house.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
		this.aspects.add(backDoor);
	}

	public void printDescription() {
		System.out.println("You are in an empty field in the south.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();
		this.backDoor.examine();

		this.printItemsOnGround();

	}
}

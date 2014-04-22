package assets;

import superClasses.Location;
import superClasses.World;

public class SField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {

		this.north = new CardinalDirection("north", World.cField,
				"To the north there is a house bordering a road.");
		this.east = new CardinalDirection("east", null,
				"To the east there is a dense forest  containing a mysterious cave.");
		this.south = new CardinalDirection("south", null,
				"To the south there is a deadly cliff that drops off to the sea.");
		this.west = new CardinalDirection("west", World.swField,
				"To the west there is an empty field.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
	}

	public void printDescription() {
		System.out.println("You are in a field behind a house.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}

}

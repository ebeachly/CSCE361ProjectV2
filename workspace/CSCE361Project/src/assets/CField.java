package assets;

import superClasses.Location;
import superClasses.World;

public class CField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public CField() {

		this.north = new CardinalDirection("north", World.wField,
				"To the north there is an empty field.");
		this.east = new CardinalDirection("east", null,
				"To the east the road leads into a dense forest.");
		this.south = new CardinalDirection("south", World.sField,
				"To the south there is a house with a field behind it.");
		this.west = new CardinalDirection("west", World.wField,
				"To the west, the road continues toward a large castle.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
	}

	public void printDescription() {
		System.out.println("You are on a road that leads east and west.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}

}

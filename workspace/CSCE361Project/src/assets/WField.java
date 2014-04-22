package assets;

import superClasses.Location;
import superClasses.World;

public class WField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {
		this.north = new CardinalDirection("north", World.nwField,
				"To the north there is a field with a wagon.");
		this.east = new CardinalDirection("east", World.cField,
				"To the east the road leads toward a house.");
		this.south = new CardinalDirection("south", World.swField,
				"To the south there is an empty field.");
		this.west = new CardinalDirection("west", null,
				"To the west there is a bridge toward a castle.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);

		return;
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

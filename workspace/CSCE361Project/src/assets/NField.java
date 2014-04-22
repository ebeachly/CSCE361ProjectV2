package assets;

import superClasses.Location;
import superClasses.World;

public class NField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {
		this.north = new CardinalDirection("north", World.canyon,
				"To the north there is canyon.");
		this.east = new CardinalDirection("east", World.neForest,
				"To the east there is a dense forest.");
		this.south = new CardinalDirection("south", World.cField,
				"To the south there is a road that goes toward a house.");
		this.west = new CardinalDirection("west", World.nwField,
				"To the west there is a field.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);

		return;
	}

	public void printDescription() {
		System.out.println("You are in a field.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}

}

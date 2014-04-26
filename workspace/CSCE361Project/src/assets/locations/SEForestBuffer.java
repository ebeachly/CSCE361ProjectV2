package assets.locations;

import assets.aspects.CardinalDirection;
import superClasses.Location;
import superClasses.World;

public class SEForestBuffer extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {
		this.north = new CardinalDirection("north", World.eForestBuffer,
				"To the north there is dense forest");
		this.east = new CardinalDirection("east", World.seForestBuffer,
				"To the east there is dense forest.");
		this.south = new CardinalDirection("south", null,
				"To the south there is a cliff.");
		this.west = new CardinalDirection("west", World.seForest,
				"To the west there is dense forest.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);

		return;
	}

	public void printDescription() {
		System.out.println("You are in a forest.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}

}

package assets;

import superClasses.Location;
import superClasses.World;

public class EForestBuffer extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {
		this.north = new CardinalDirection("north", World.neForestBuffer,
				"To the north there is dense forest.");
		this.east = new CardinalDirection("east", World.eForestBuffer,
				"To the east the road continues into the forest.");
		this.south = new CardinalDirection("south", World.seForestBuffer,
				"To the south there is dense forest.");
		this.west = new CardinalDirection("west", World.eForest,
				"To the west the road continues into the forest.");

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

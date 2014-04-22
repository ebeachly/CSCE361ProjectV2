package assets;

import superClasses.Location;
import superClasses.World;

public class NEForestBuffer extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public NEForestBuffer() {
		this.north = new CardinalDirection("north", null,
				"To the north there are massive cliffs.");
		this.east = new CardinalDirection("east", World.neForestBuffer,
				"To the east there is dense forest.");
		this.south = new CardinalDirection("south", World.eForestBuffer,
				"To the south there is dense forest.");
		this.west = new CardinalDirection("west", World.neForest,
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

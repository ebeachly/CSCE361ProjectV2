package assets;

import superClasses.Location;
import superClasses.World;

public class NEForest extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public NEForest() {
		this.north = new CardinalDirection("north", null,
				"To the north there are massive cliffs");
		this.east = new CardinalDirection("east", null,
				"To the east there is dense forest.");
		this.south = new CardinalDirection("south", World.eForestBuffer,
				"To the south there is dense forest.");
		this.west = new CardinalDirection("west", World.cField,
				"To the west there is a field.");

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

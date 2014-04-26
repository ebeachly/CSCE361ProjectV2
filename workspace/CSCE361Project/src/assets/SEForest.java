package assets;

import superClasses.Location;
import superClasses.World;

public class SEForest extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {
		this.north = new CardinalDirection("north", World.eForest,
				"To the north there is dense forest.");
		this.east = new CardinalDirection("east", World.seForestBuffer,
				"To the east there is dense forest.");
		this.south = new CardinalDirection("south", null,
				"To the south there is a cliff.");
		this.west = new CardinalDirection("west", World.sField,
				"To the west there is a field behind a house.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
		this.aspects.add(new CaveEntrance(World.cave));

		return;
	}

	public void printDescription() {
		System.out.println("You are in a forest. A dark cave is there.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}

}

package assets;

import superClasses.Location;
import superClasses.World;

public class Canyon extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;
	private Jubjub jubjub;

	public void construct() {

		this.north = new CardinalDirection("north", World.cField,
				"To the north the canyon continues into darkness.");
		this.east = new CardinalDirection("east", null,
				"To the east there is a large cliff.");
		this.south = new CardinalDirection("south", World.nField,
				"To the south there is an empty field.");
		this.west = new CardinalDirection("west", null,
				"To the west there is a large cliff.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);

		this.jubjub = new Jubjub();

		this.aspects.add(jubjub);
	}

	public void printDescription() {
		System.out.println("You are in a deep canyon.");

		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();
	}

}

package assets;

import superClasses.Location;
import superClasses.World;

public class Canyon extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {

		this.north = new CardinalDirection("north", World.cField,
				"To the north the canyon continues into darkness.");
		this.east = new CardinalDirection("east", null,
				"To the east there is a large cliff.");
		this.south = new CardinalDirection("south", null,
				"To the south there is an empty field.");
		this.west = new CardinalDirection("west", null,
				"To the west there is a large cliff.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
	}

	public void printDescription() {
		System.out.println("You are in a deep canyon.");
		System.out.println("Further along the canyon you hear a man calling for help.");
		System.out.println("A large bird steps from the shadows.");
		System.out.println("You've heard tale of this terrifying beast.");
		System.out.println("It is the Jub Jub bird.");
		System.out.println("The creature opens its mouth and lets out a piercing cry.");
		System.out.println("You turn and run.");
		south.go();
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}

}

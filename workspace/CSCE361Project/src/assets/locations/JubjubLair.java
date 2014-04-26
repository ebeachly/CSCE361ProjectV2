package assets.locations;

import assets.aspects.CardinalDirection;
import assets.aspects.Jubjub;
import assets.aspects.Wizard;
import superClasses.Location;
import superClasses.World;

public class JubjubLair extends Location {

	private CardinalDirection south;
	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection west;
	public Jubjub jubjub;
	protected Wizard wizard;

	public void construct() {
		this.south = new CardinalDirection("south", World.canyon,
				"To the south lies a canyon.");
		this.north = new CardinalDirection("north", null,
				"To the north is the back wall of the canyon.");
		this.east = new CardinalDirection("east", null,
				"To the east is a large cliff.");
		this.west = new CardinalDirection("west", null,
				"To the west is a large cliff.");

		this.aspects.add(south);
		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(west);

		this.jubjub = new Jubjub();
		this.aspects.add(jubjub);

		this.wizard = new Wizard();
		this.aspects.add(wizard);
	}

	public void printDescription() {
		System.out.println("You are in a shallow cave.");

		south.examine();

		this.printItemsOnGround();
	}

}

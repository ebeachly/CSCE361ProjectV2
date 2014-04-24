package assets;

import superClasses.Game;
import superClasses.Location;
import superClasses.World;

public class SWField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	boolean firstTimePrintingDescription;

	public void construct() {
		firstTimePrintingDescription = true;

		this.north = new CardinalDirection("north", World.wField,
				"To the north there is a road that runs east and west.");
		this.east = new CardinalDirection("east", World.sField,
				"To the east there is a field and a house.");
		this.south = new CardinalDirection("south", null,
				"To the south there is a deadly cliff that drops off to the sea.");
		this.west = new CardinalDirection(
				"west",
				null,
				"To the west there is a rapid river that pours off a cliff into the sea.\n"
						+ "Beyond that is a crenelated castle wall with many towers.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);

		return;
	}

	public void printDescription() {
		System.out.println("You are in an empty field.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		if (firstTimePrintingDescription) {
			firstTimePrintingDescription = false;
			Game.player.inventory.add(new Sword());
			Game.player.inventory.add(new PocketLint());
			Game.player.viewInventory();
			System.out
					.println("Suddenly a piece of paper comes soaring on the wind and lands right in front of your feet.");
			Pamphlet pamphlet = new Pamphlet();
			this.droppedItems.add(pamphlet);
		}

		this.printItemsOnGround();

	}
}

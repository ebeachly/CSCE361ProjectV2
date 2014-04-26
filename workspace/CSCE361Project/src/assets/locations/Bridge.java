package assets.locations;

import assets.aspects.CardinalDirection;
import superClasses.Location;
import superClasses.World;

public class Bridge extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;

	public void construct() {
		this.north = new CardinalDirection("north", null,
				"To the north you see the river flow under the bridge.");
		this.east = new CardinalDirection("east", World.wField,
				"To the east the road continues through a field.");
		this.south = new CardinalDirection("south", null,
				"To the south the river flows over a waterfall.");
		this.west = new CardinalDirection("west", null,
				"To the west the bridge ends, because the drawbridge on the castle is up.");

		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);

		return;
	}

	public void printDescription() {
		System.out.println("You are on a bridge that extends halfway over a river. Across the river is a castle.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}
}

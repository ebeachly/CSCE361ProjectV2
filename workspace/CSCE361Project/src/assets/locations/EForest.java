package assets.locations;

import assets.aspects.CardinalDirection;
import superClasses.Location;
import superClasses.World;

public class EForest extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;
	
	public void construct(){
		this.north = new CardinalDirection("north", World.neForest, "To the north there is dense forest.");
		this.east = new CardinalDirection("east", World.eForestBuffer, "To the east the road continues into the forest.");
		this.south = new CardinalDirection("south", World.seForest, "To the south there is a mysterious cave hidden in the trees.");
		this.west = new CardinalDirection("west", World.cField, "To the west there is a road leading to a house.");
		
		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
		
		return;
	}
	
	public void printDescription() {
		System.out.println("You are on a road in a forest.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();

		this.printItemsOnGround();

	}
	
}

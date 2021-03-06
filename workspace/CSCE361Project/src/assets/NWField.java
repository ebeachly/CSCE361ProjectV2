package assets;

import superClasses.Location;
import superClasses.World;

public class NWField extends Location {

	private CardinalDirection north;
	private CardinalDirection east;
	private CardinalDirection south;
	private CardinalDirection west;
	public Merchant merchant;
	private Wagon wagon;
	public ShieldAspect shield;

	public void construct() {
		this.north = new CardinalDirection("north", null,
				"To the north there are massive cliffs.");
		this.east = new CardinalDirection("east", World.nField,
				"To the east there is a field.");
		this.south = new CardinalDirection("south", World.wField,
				"To the south there is a road running from east to west.");
		this.west = new CardinalDirection("west", null,
				"To the west there is a raging river.");
		this.merchant= new Merchant();
		this.wagon = new Wagon();
		this.shield = new ShieldAspect();
		
		this.aspects.add(north);
		this.aspects.add(east);
		this.aspects.add(south);
		this.aspects.add(west);
		this.aspects.add(merchant);
		this.aspects.add(wagon);
		this.aspects.add(shield);
		return;
	}

	public void printDescription() {
		System.out.println("You are in a field.");
		this.north.examine();
		this.east.examine();
		this.west.examine();
		this.south.examine();
		System.out.println("There is a merchant and his wagon in the field.");
		this.printItemsOnGround();

	}

}

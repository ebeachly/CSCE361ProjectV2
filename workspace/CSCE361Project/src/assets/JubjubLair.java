package assets;

import superClasses.Location;
import superClasses.World;

public class JubjubLair extends Location {

	private CardinalDirection south;
	protected Jubjub jubjub;
	protected Wizard wizard;
	
	public void construct() {
		this.south = new CardinalDirection("south", World.canyon,
				"To the south lies a canyon.");
		
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

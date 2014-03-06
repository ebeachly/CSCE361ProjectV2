package superClasses;

import assets.PrisonCellDoor;
import assets.PrisonCellKey;

public class Game {
	
	public static Player player = new Player();
	public static Parser parser = new Parser();
	
	public static void main(String args[]){
		//TODO: Implement
		
		//Do the second phase of world construction (First was done when the program was loaded)
		World.constructWorld();
		//Put the player in the cell
		Game.player.currentLocation = World.prisonCell;
		
		// DEBUG:
		//Unlock the door
		((PrisonCellKey)World.prisonCell.droppedItems.getFirst()).unlock(Game.player.currentLocation.aspects.get(0));
		//Walk through it
		((PrisonCellDoor)Game.player.currentLocation.aspects.get(0)).goThrough();
		//Walk through it again
		((PrisonCellDoor)Game.player.currentLocation.aspects.get(0)).goThrough();
		//Check that the player is in an actual location.
		if(Game.player.currentLocation == null){
			System.out.println("The doorway out of the prison cell goes to null.");
		} else {
			System.out.println("Yay it worked.");
		}
		
		
		//Main Menu
		
		//Turn Manager:
		// Player turn
		// Check to see if game over?
		// Use a queue to hold the aspects that want to take a turn.
		// Add a method to empty the queue (in case an aspect causes a change of location).
	}
	
}

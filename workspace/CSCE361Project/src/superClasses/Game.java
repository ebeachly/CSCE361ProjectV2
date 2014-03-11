package superClasses;

import java.util.Scanner;

import assets.PrisonCellDoor;
import assets.PrisonCellKey;

public class Game {

	public static Player player = new Player();
	public static Parser parser = new Parser();
	public static boolean hasLost = false;

	public static void main(String args[]){
		//TODO: Implement
		Scanner console = new Scanner(System.in);
		String input;
		System.out.println("" +
				"     ____.     ___.  ___.                                      __           \n" +
				"    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__.\n" +
				"    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |\n" +
				"/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |\n" +
				"\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|\n" +
				"              \\/    \\/    \\/     \\/                         \\/     \\/\\/     ");
		System.out.println();
		System.out.println();
		System.out.println();
		do {
		System.out.print(">> ");
		input = console.nextLine().toLowerCase();
		} while (parseMenuOption(input) == 0);
		
		//Do the second phase of world construction (First was done when the program was loaded)
		World.constructWorld();
		//Put the player in the cell
		Game.player.currentLocation = World.prisonCell;
		
		player.currentLocation.printDescription();
		System.out.println();
		System.out.println();
		System.out.println();
		
		while(!hasLost){
			System.out.print(">> ");
			input = console.nextLine().toLowerCase();
			//parser.parseInput(input);
			player.pickUp("cell key");
			for(Aspect a : player.currentLocation.aspects){
				a.takeTurn();
			}
		}
		
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
	
	private static int parseMenuOption(String input){
		if (input.equals("quit") || input.equals("q")){
			System.exit(0);
			return 0;
		} else if (input.equals("new") || input.equals("new game") || input.equals("n")){
			return 1;
		} else {
			return 0;
		}
	}
}

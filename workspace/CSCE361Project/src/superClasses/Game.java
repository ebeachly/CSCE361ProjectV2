package superClasses;

public class Game {
	
	public static Player player = new Player();
	public static Parser parser = new Parser();
	
	public static void main(String args[]){
		//TODO: Implement Main Menu, turn manager
		
		System.out.println("Does it work?");
		
		//Setup
		Game.player.currentLocation = World.prisonCell;
		
		//Main Menu
		
		//Turn Manager:
		// Player turn
		// Check to see if game over?
		// Use a queue to hold the aspects that want to take a turn.
		// Add a method to empty the queue (in case an aspect causes a change of location).
	}
	
}

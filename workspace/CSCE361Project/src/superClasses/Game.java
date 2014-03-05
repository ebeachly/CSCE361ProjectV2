package superClasses;

public class Game {
	
	public static World world;
	public static Player player;
	public static Parser parser;
	
	public static void main(String args[]){
		//TODO: Implement Main Menu, turn manager
		System.out.println("Does it work?");
		Game.player.currentLocation = Game.world.prisonCell;
	}
	
}

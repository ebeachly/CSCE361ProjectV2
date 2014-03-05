package assets;

import superClasses.Aspect;
import superClasses.Game;

public class PrisonCellDoor extends Aspect {
	boolean locked;
	String name = "cell door";
	
	void goThrough(){
		if( this.locked ){
			System.out.println("The cell door is locked.");
		} else {
			if(Game.player.currentLocation == Game.world.prisonHallway){
				
				System.out.println("You walk through the door into the prison cell");
				Game.player.currentLocation = Game.world.prisonCell;
				
			} else if( Game.player.currentLocation == Game.world.prisonCell ){
				
				System.out.println("You walk through the door into the hallway");
				Game.player.currentLocation = Game.world.prisonHallway;
			}
		}
		return;
	}
}

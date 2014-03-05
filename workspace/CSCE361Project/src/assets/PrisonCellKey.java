package assets;

import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;

public class PrisonCellKey extends Item {
	String name = "cell key";
	
	public void unlock(Interactable target){
		if( target == Game.world.prisonCellDoor ){
			System.out.println("You unlock the cell door");
			Game.world.prisonCellDoor.locked = false;
		} else {
			System.out.println("It didn't work.");
		}
	}
	
	public void lock(Interactable target){
		if( target == Game.world.prisonCellDoor ){
			System.out.println("You lock the cell door");
			Game.world.prisonCellDoor.locked = true;
		} else {
			System.out.println("It didn't work.");
		}
	}
	
}

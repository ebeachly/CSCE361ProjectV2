package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.World;

public class PrisonCellDoor extends Aspect {
	protected boolean locked;
	public String name = "cell door";
	
	public PrisonCellDoor(){
		this.locked = true;
	}
	
	public boolean interact( String action, Interactable target ){
		if(action.equals("examine")){
			return this.examine();
		} else if(action.equals("go through")){
			return this.goThrough();
		} else if(action.equals("open")){
			return this.open();
		} else if(action.equals("lock")){
			return this.lock();
		} else if(action.equals("unlock")){
			return this.unlock();
		}
		System.out.println("The word \"" + action + "\" wasn't recognized");
		return false;
	}
	
	public boolean goThrough(){
		//Go through the door
		if( this.locked ){
			System.out.println("The cell door is locked.");
		} else {
			if(Game.player.currentLocation == World.prisonHallway){
				
				System.out.println("You walk through the cell door into the prison cell");
				Game.player.currentLocation = World.prisonCell;
				
			} else if( Game.player.currentLocation == World.prisonCell ){
				
				System.out.println("You walk through the cell door into the hallway");
				Game.player.currentLocation = World.prisonHallway;
			}
		}
		return true;
	}
	
	public boolean unlock(){
		//This function is what gets called if you try to unlock the door by using the door, instead of using the key on the door
		System.out.println("You need to use a key to unlock the cell door.");
		return true;
	}
	
	public boolean lock(){
		//This function is what gets called if you try to lock the door by using the door, instead of using the key on the door
		System.out.println("You need to use a key to lock this cell door");
		return true;
	}
	
	public boolean open(){
		//Open is just a way to test if the door is locked or not without trying to go through.
		//Having a state of being open or closed is too trivial.
		if(this.locked){
			System.out.println("The door is locked.");
		} else {
			System.out.println("The door swings open.");
		}
		return true;
	}
	
	public boolean examine(){
		System.out.println("It's a door made out of metal bars and has a sturdy lock with a keyhole.");
		if(this.locked){
			System.out.println("It is currently locked.");
		} else {
			System.out.println("It is not locked.");
		}
		return true;
	}
}

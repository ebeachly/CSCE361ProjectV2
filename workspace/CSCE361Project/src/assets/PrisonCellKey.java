package assets;

import superClasses.Interactable;
import superClasses.Item;

public class PrisonCellKey extends Item {
	public String name = "cell key";
	
	public boolean interact( String action, Interactable target ){
		if ( action.equals("drop") ){
			return this.drop();
		} else if(action.equals("examine")){
			return this.examine();
		} else if(action.equals("lock")){
			return this.lock(target);
		} else if(action.equals("unlock")){
			return this.unlock(target);
		}
		System.out.println("The word \"" + action + "\" wasn't recognized");
		return false;
	}
	
	public boolean unlock(Interactable target){
		if( target instanceof PrisonCellDoor ){	//Could also check if the target is the PrisonCellDoor in Game.world.
			System.out.println("You unlock the cell door");
			((PrisonCellDoor)target).locked = false;
		} else {
			System.out.println("Nothing happened.");
		}
		return true;
	}
	
	public boolean lock(Interactable target){
		if( target instanceof PrisonCellDoor ){
			System.out.println("You lock the cell door");
			((PrisonCellDoor)target).locked = true;
		} else {
			System.out.println("Nothing happened.");
		}
		return true;
	}
	
	public boolean examine(){
		System.out.println("A big rusty key on a ring. It looks like it would fit the lock in the cell door.");
		return true;
	}
	
}

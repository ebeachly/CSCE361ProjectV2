package assets;

import superClasses.Interactable;
import superClasses.Item;

public class PrisonCellKey extends Item {
	public String name = "cell key";
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		} else if(action.equals("lock")){
			return this.lock(target);
		} else if(action.equals("unlock")){
			return this.unlock(target);
		}
		return false;
	}
	
	public boolean unlock(Interactable target){
		if( target instanceof PrisonCellDoor ){
			System.out.println("You unlock the cell door");
			((PrisonCellDoor)target).locked = false;
			((PrisonCellDoor)target).getOtherSide().locked = false;
		} else {
			System.out.println("Nothing happened.");
		}
		return true;
	}
	
	public boolean lock(Interactable target){
		if( target instanceof PrisonCellDoor ){
			System.out.println("You lock the cell door");
			((PrisonCellDoor)target).locked = true;
			((PrisonCellDoor)target).getOtherSide().locked = true;
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

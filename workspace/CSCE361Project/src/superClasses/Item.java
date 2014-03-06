package superClasses;

public abstract class Item extends Interactable {
	//This class represents a tool, weapon or other small item the player can hold.
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		} else if ( action.equals("drop") ){
			return this.drop();
		}
		return false;
	}
	
	public boolean drop(){
		//TODO: Implement
		//Make sure to check that this item exists in the player's inventory
		return true;
	}
	
	//Pick-up function in Player class because you can't interact with items on the ground.
	
}

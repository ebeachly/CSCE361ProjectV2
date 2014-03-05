package superClasses;

public abstract class Item extends Interactable {
	//This class represents a tool, weapon or other small item the player can hold.
	
	public boolean interact( String action, Interactable target ){
		if(action.equals("examine")){
			return this.examine();
		} else if ( action.equals("drop") ){
			return this.drop();
		}
		System.out.println("The word \"" + action + "\" wasn't recognized");
		return false;
	}
	
	public boolean drop(){
		//TODO: Implement
		//Make sure to check that this item exists in the player's inventory
		return true;
	}
	
	//Pick-up function in Player class because you can't interact with items on the ground.
	
}

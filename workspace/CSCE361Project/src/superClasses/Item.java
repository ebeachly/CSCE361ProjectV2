package superClasses;

public abstract class Item extends Interactable {
	
	public boolean interact( String action, Interactable target ){
		//returns false if the action is not recognized.
		if ( action.equals("drop") ){
			this.drop();
			return true;
		} else if ( action.equals("pick up") ){
			this.pickUp();
			return true;
		}
		return false;
	}
	
	public void drop(){
		//TODO: Implement
		//Make sure to check that this item exists in the player's inventory
		return;
	}
	
	public void pickUp(){
		//TODO: Implement
		//Make sure to check that the item exists on the player's current Location's dropped items list.
		return;
	}
	
}

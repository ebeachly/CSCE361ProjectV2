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
		//Takes the item from the player's inventory and drops it on the ground
		//Make sure to check that this item exists in the player's inventory
		if(Game.player.itemInInventory(this)==true){
			Game.player.dropItem(this);
			return true;
		}
		return false;
	}
	
	//Pick-up function in Player class because you can't interact with items on the ground.
	
}

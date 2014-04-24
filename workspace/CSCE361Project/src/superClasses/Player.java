package superClasses;

import java.util.LinkedList;
import java.util.Iterator;

public class Player {

	public LinkedList<Item> inventory;
	public Location currentLocation;

	public Player() {
		inventory = new LinkedList<Item>();
	}

	public boolean pickUp(String name) {
		// Searches for an item with the given name, removes it from the ground
		// and adds it to the inventory.
		Item item = Game.parser.findItemOnGround(name);
		
		if( item == null ){
			return true;
		} else {
			System.out.println("You pick up a " + item.name + ".");
			this.currentLocation.droppedItems.remove(item);
			this.inventory.add(item);
			return true;
		}
	}

	public void viewInventory(){
		//States the name of every item currently held by the player
		if( !inventory.isEmpty() ){
			System.out.println("Your inventory contains:");
			for(Item i: inventory){
				System.out.println("   " + i.name);
			}
		} else {
			System.out.println("Your inventory contains nothing.");
		}
		return;
	}
	
	public boolean itemInInventory(Item itemIn){
		//Returns true or false depending on if player has said item
		for(Item i: inventory){
			if(itemIn.name.compareTo(i.name)==0){
				return true;
			}
		}
		//Inventory does not contain item, tells the player that information
		System.out.println("You don't have " + itemIn.name + " in your inventory.");
		return false;
	}
	
	public boolean dropItem(Item i){
		//Player removes item from inventory and places it in current location
		//returns true if the item was in the player's inventory.
		if(this.inventory.remove(i)){
			this.currentLocation.droppedItems.add(i);
			return true;
		}
		return false;
	}

	// public void viewStatus(){} //Perhaps the player could become injured and
	// survive one or two hits? You could have a helmet item that gets destroyed
	// and prevents a damage.

}

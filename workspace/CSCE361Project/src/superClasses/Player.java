package superClasses;

import java.util.LinkedList;
import java.util.Iterator;

public class Player {

	public LinkedList<Item> inventory;
	public Location currentLocation;

	public Player() {
		inventory = new LinkedList<Item>();
	}

	public void pickUp(String name) {
		// Searches for an item with the given name, removes it from the ground
		// and adds it to the inventory.
		Iterator<Item> it = this.currentLocation.droppedItems.iterator();
		boolean unique = true;
		Item potential = null;
		while (it.hasNext()) {
			Item i = it.next();
			if (i.name.equals(name)) {
				System.out.println("You pick up a " + name + ".");
				it.remove(); // I think this just removes the pointer to the
								// object, so as long as i or another reference
								// exists, Java won't garbage collect the item.
				this.inventory.add(i); //
				return;
			}
			if (i.name.contains(name)) {
				if (unique) {
					if (potential == null) {
						potential = i;
					} else {
						unique = false;
					}
				}
			}
		}
		if (potential != null && unique) {
			System.out.println("You pick up a " + potential + ".");
			this.currentLocation.droppedItems.remove(potential);
			this.inventory.add(potential);
			return;
		}
		System.out.println("You can't find a " + name + " on the ground.");
		return;
	}

	public void viewInventory(){
		//States the name of every item currently held by the player
		System.out.println("Your inventory contains:");
		for(Item i: inventory){
			System.out.println(i.name);
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
		System.out.println("Player does not have " + itemIn.name + " in their inventory.");
		return false;
	}
	
	public void dropItem(Item i){
		//Player removes item from inventory and places it in current location
		this.inventory.remove(i);
		this.currentLocation.droppedItems.add(i);
		System.out.println(i.name + " was dropped on the ground.");
	}

	// public void viewStatus(){} //Perhaps the player could become injured and
	// survive one or two hits? You could have a helmet item that gets destroyed
	// and prevents a damage.

}

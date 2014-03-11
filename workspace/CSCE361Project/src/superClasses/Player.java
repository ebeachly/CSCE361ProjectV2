package superClasses;

import java.util.LinkedList;
import java.util.Iterator;

public class Player {

	public LinkedList<Item> inventory;
	public Location currentLocation;
	
	public Player(){
		inventory = new LinkedList<Item>();
	}
	
	public void pickUp( String name ){
		//Searches for an item with the given name, removes it from the ground and adds it to the inventory.
		Iterator<Item> it = this.currentLocation.droppedItems.iterator();
		while(it.hasNext()){
			Item i = it.next();
			if( i.name.equals(name)){
				System.out.println("You pick up a " + name + ".");
				it.remove();			//I think this just removes the pointer to the object, so as long as i or another reference exists, Java won't garbage collect the item.
				this.inventory.add(i);	//
				return;
			}
		}
		System.out.println("You can't find a " + name + " on the ground.");
		return;
	}
	
	public void viewInventory(){
		//TODO: Implement
	}
	
	//public void viewStatus(){}	//Perhaps the player could become injured and survive one or two hits? You could have a helmet item that gets destroyed and prevents a damage.

}

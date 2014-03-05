package superClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class Location {

	public LinkedList<Item> droppedItems;
	public ArrayList<Aspect> aspects;
	
	
	public void printDescription(){
		return;
	}
	
	public void printItemsOnGround(){
		if( this.droppedItems.size() == 1 ){
			System.out.println("On the ground there is a: " + this.droppedItems.get(0).name );
		} else {
			System.out.println("On the ground there are:");
			Iterator<Item> it = this.droppedItems.iterator();
			while(it.hasNext()){
				Item i = it.next();
				System.out.println(i.name);
			}
		}
		return;
	}
	
	/*	//Is this method necessary? I'll keep it in because it is a good example of how to remove the item from the linked list.
	public Item removeItemFromGround( String name ){
		//Searches for an item with the given name and removes and returns the first one it finds
		Iterator<Item> it = this.droppedItems.iterator();
		while(it.hasNext()){
			Item i = it.next();
			if( i.name.equals(name)){
				it.remove();
				return i;
			}
		}
		return null;
	}
	*/
	
}

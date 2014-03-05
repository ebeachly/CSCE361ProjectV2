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
			System.out.println("On the ground there is a: " + this.droppedItems.get(0).name );	//TODO: conditionally do a/an based on first letter of name
		} else {
			System.out.println("On the ground there are:");
			Iterator<Item> it = this.droppedItems.iterator();
			while(it.hasNext()){
				Item i = it.next();
				System.out.println("   " + i.name);
			}
		}
		return;
	}
	

	
}

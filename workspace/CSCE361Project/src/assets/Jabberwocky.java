package assets;

import superClasses.Aspect;
import superClasses.Interactable;
import superClasses.Item;

public class Jabberwocky extends Aspect {
	boolean alive;
	public Jabberwocky(){
		this.alive = true;
	}
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		}
		return false;
	}
	
	protected boolean examine(){
		System.out.println("There's nothing special about it.");
		return true;
	}
	
	public boolean damage(Item weapon){
		//Returns true if the weapon had an effect and prints out a description of the effect.
		//If there was no effect, returns false.
		return false;
	}
}

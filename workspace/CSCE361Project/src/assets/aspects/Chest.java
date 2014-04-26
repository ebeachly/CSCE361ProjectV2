package assets.aspects;

import superClasses.Aspect;

public class Chest extends Aspect {

	public Chest(){
		this.name = "chest";
	}
	
	protected boolean examine(){
		System.out.println("It is a dark oak chest with nothing inside.");
		return true;
	}
	
}

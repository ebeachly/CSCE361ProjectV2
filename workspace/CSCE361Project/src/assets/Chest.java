package assets;

import superClasses.Aspect;

public class Chest extends Aspect {

	public Chest(){
		this.name = "chest";
	}
	
	protected boolean examine(){
		System.out.println("It is empty.");
		return true;
	}
	
}

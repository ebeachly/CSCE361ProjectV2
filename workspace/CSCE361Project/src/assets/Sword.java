package assets;

import superClasses.Interactable;
import superClasses.Item;

public class Sword extends Item {

	public Sword(){
		this.name = "sword";
	}
	
	protected boolean attack( Interactable target ){
		return target.damage(this);
	}
	
}

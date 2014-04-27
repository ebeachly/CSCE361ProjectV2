package assets;

import superClasses.Interactable;
import superClasses.Item;

public class Sword extends Item {

	public Sword(){
		this.name = "sword";
	}
	
	protected boolean attack( Interactable target ){
		if( target != null && !(target instanceof CardinalDirection) ){
			System.out.println("You swing your " + this.name + " at the " + target.name + ".");
			if( !target.damage(this)){
				System.out.println("Your attack bounces off and does nothing.");
			}
			return true;
		} else {
			System.out.println("You swing your " + this.name + " wildy around.");
			return true;
		}
	}
	public boolean examine() {
		System.out.println("A steel broadsword. The hilt is wrapped in leather.");
		if( this.name.contains("vorpal")){
			System.out.println("The edge seems very sharp.");
		}
		return true;
	}
	
}

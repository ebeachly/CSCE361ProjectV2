package superClasses;

public abstract class Item extends Interactable {
	//This class represents a tool, weapon or other small item the player can hold.
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		} else if ( action.equals("drop") ){
			return this.drop();
		} else if ( action.equals("toss")){
			return this.toss(target);
		} else if ( action.equals("attack")){
			return this.attack(target);
		}  else if(action.equals("eat")){
			return this.eat();
		}
		return false;
	}
	
	protected boolean drop(){
		//Takes the item from the player's inventory and drops it on the ground
		//Make sure to check that this item exists in the player's inventory
		//Pick-up function in Player class because you can't interact with items on the ground.
		if(Game.player.dropItem(this)){
			System.out.println("You drop your " + this.name + " on the ground.");
			return true;
		}
		return false;
	}
	
	protected boolean toss( Interactable target ){
		if( Game.player.dropItem(this)){
			if(target!= null){
				System.out.println("You throw your " + this.name + " at the " + target.name + ".");
				if(!target.damage(this)){
					System.out.println("The " + this.name + " bounces off and falls on the ground.");
				}
			} else {
				System.out.println("You throw your " + this.name + " away, and it lands on the ground.");
			}
			return true;
		}
		return false;
	}
	
	protected boolean attack( Interactable target ){
		return this.toss(target);
	}
	
	protected boolean eat(){
		System.out.println("That's a dumb idea.");
		return true;
	}
	protected boolean examine(){
		if(this.name.contains("vorpal")){
			System.out.println("The edges of it seem exceedingly sharp.");
		} else {
			System.out.println("There's nothing special about it.");
		}
		return true;
	}
	
	public void makeVorpal(){
		this.name = "vorpal " + this.name;
	}
	
}

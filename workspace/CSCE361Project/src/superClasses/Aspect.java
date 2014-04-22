package superClasses;

public abstract class Aspect extends Interactable {
	//This class represents some important thing in a Location, like a passageway, a door, an npc, etc.
	//Some aspects can 
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		} else if( action.equals("attack")){
			return this.attack();
		}
		return false;
	}

	public void takeTurn(){
		return;
	}
	
	public boolean attack(){
		System.out.println("SYSTEM: You need to specify what you are using to attack, ie: attack goblin with sword.");
		return false;
	}
	
}

package superClasses;

public abstract class Aspect extends Interactable {
	//This class represents some important thing in a Location, like a passageway, a door, an npc, etc.
	//Some aspects can 
	
	public boolean interact( String action, Interactable target ){
		if(action.equals("examine")){
			this.examine();
			return true;
		}
		System.out.println("The word \"" + action + "\" wasn't recognized");
		return false;
	}

	public void takeTurn(){
		return;
	}
	
}

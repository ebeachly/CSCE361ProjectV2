package superClasses;

public abstract class Interactable {
	//Interactable needs to be a class because otherwise the variables like name would be static
	
	public String name = "";			//this is the all-lowercase unique identifier used by the game to identify the interactable object.
	
	public boolean interact( String action, Interactable target ){
		return true;
	}
	
	public void printDescription(){		//maybe this is unnecessary
		System.out.println("There's nothing special about it.");
		return;
	}
	
}

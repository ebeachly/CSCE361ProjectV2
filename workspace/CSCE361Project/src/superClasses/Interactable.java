package superClasses;

public abstract class Interactable {
	//Interactable needs to be a class because otherwise the variables like name would be static
	
	public String name = "";			//this is the all-lowercase unique identifier used by the game to identify the interactable object.
	//public String indefiniteArticle = "a";	//We could write an algorithm for determining whether to use a or an, or we could just store it.
	
	public boolean interact( String action, Interactable target ){
		//returns false if the player deserves a retry at the command (the action wasn't recognized)
		if(action.equals("examine")){
			return this.examine();
		}
		//Possibly, we could nest different levels of interact methods, so that we wouldn't have to retype every action that the superclass gives.
		System.out.println("The word \"" + action + "\" wasn't recognized");
		return false;
	}
	
	public boolean examine(){
		System.out.println("There's nothing special about it.");
		return true;
	}
	
}

package superClasses;

public abstract class Interactable {
	//Interactable needs to be a class because otherwise the variables like name would be static
	
	public String name = "";			//this is the all-lowercase unique identifier used by the game to identify the interactable object.
	//public String indefiniteArticle = "a";	//We could write an algorithm for determining whether to use a or an, or we could just store it.
	
	public boolean interact( String action, Interactable target ){
		//checks if the action is recognized and performs it if it is and returns true
		//returns false if the the action wasn't recognized
		if(action.equals("examine")){
			return this.examine();
		}
		return false;
	}
	
	public boolean examine(){
		System.out.println("There's nothing special about it.");
		return true;
	}
	
}

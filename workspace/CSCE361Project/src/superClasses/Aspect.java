package superClasses;

public abstract class Aspect extends Interactable {
	
	public boolean interact( String action, Interactable target ){
		return true;
	}

	public void takeTurn(){
		return;
	}
	
}

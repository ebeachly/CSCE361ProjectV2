package assets.aspects;

import superClasses.Aspect;
import superClasses.Interactable;
import superClasses.World;

public class Wagon extends Aspect {

	public Wagon() {
		this.name = "wagon";
	}

	@Override
	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		}
		return false;
	}

	protected boolean examine() {
		System.out.println("The merchant's wagon that holds all of his wares.");
		if( World.nwField.merchant.shield != null ){
			System.out.println("There is a shield hanging from the side.");
		}
		return true;
	}

}



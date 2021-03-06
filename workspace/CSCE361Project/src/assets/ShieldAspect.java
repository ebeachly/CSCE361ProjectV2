package assets;

import superClasses.Aspect;
import superClasses.Interactable;

public class ShieldAspect extends Aspect {

	public ShieldAspect() {
		this.name = "shield";
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("buy")) {
			System.out.println("SYSTEM: With what?");
			return true;
		}
		return false;
	}

	public boolean examine() {
		System.out
				.println("A large shiny shield hangs on the merchant's wagon. It looks heavy.");
		return true;
	}

}

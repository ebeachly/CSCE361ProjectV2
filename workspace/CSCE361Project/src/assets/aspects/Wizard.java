package assets.aspects;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;
import superClasses.World;

public class Wizard extends Aspect {

	private boolean firstAppearance = true;
	private boolean damaged = false;

	public Wizard() {
		this.name = "wizard";
	}

	public void takeTurn() {
		if (!World.jubjubLair.jubjub.isAlive()) {
			if (firstAppearance) {
				System.out
						.println("An old man in a bath robe steps out from behind a bush.");
				System.out
						.println("Old man: \"Oh thank you kind sir. You have saved my life.\"");
				System.out
						.println("Old man: \"That wretched bird has had me trapped down here for days.\"");
				System.out
						.println("Old man: \"I am the most powerful wizard in this land.\"");
				System.out
						.println("Wizard: \"For your bravery, I will enchant a single item of your choosing.\"");
				firstAppearance = false;
			} else if(this.damaged == true){
				System.out.println("The wizard smirks and vanishes.");
			}
			else {
				System.out
						.println("\"The wizard asks: What do you want me to enchant?\"");
			}
		}
		return;
	}

	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		} else if (action.equals("give")) {
			return this.give(target);
		}
		return false;
	}
	public boolean damage(Item weapon){
		System.out.println("He responds with a storm of lightning bolts killing you.");
		this.damaged = true;
		Game.hasLost = true;
		return true;
	}
	protected boolean examine() {
		System.out.println("This old man thinks he's a wizard.");
		return true;
	}

	public boolean give(Interactable target) {
		if (target != null && target instanceof Item) {
			((Item) target).makeVorpal();
			System.out
					.println("The wizard mumbles: \"Oobaday, oobuday, ack!\"");
			System.out.println("He hands back your new " + target.name + ".");
			System.out.println("Wizard: \"May it serve you well.\"");
			System.out.println("He snaps his fingers and vanishes.");
			World.jubjubLair.aspects.remove(this);
			return true;
		}
		return false;
	}

}

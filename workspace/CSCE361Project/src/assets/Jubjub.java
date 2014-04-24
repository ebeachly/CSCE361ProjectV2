package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;
import superClasses.World;

public class Jubjub extends Aspect {

	private boolean isAlive = true;
	private boolean firstAppearance = true;

	public Jubjub() {
		name = "jubjub bird";
	}

	public boolean interact(String action, Interactable target) {
		return super.interact(action, target);
	}

	public void takeTurn() {
		if (isAlive) {
			if (firstAppearance) {
				System.out
						.println("A large creature emerges from the shadows.");
				System.out
						.println("You've heard tale of this terrifying beast.");
				System.out.println("It's the Jubjub bird");
				firstAppearance = false;
			}
			if (World.ears.arePlugged()) {
				System.out
						.println("The jubjub bird rears back its head and opens its mouth, but you hear nothing.");
			} else {
				System.out
						.println("The jubjub bird rears back its head and unleashes a terrifying scream.");
				System.out.println("You turn and run back to the field.");
				Game.player.currentLocation = World.canyon;
				System.out.println("You need something to protect your ears.");
			}
		}
		return;
	}

	public boolean damage(Item weapon) {
		// Returns true if the weapon had an effect and prints out a description
		// of the effect.
		// If there was no effect, returns false.
		if (weapon instanceof assets.Sword) {
			System.out.println("The jubjub bird falls to the ground, dead.");
			isAlive = false;
			return true;
		}
		return false;
	}
	
	public boolean isAlive(){
		return this.isAlive;
	}
	
	protected boolean examine(){
		System.out.println("There's nothing special about it.");
		return true;
	}

}

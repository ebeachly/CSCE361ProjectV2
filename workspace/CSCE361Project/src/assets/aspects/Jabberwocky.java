package assets.aspects;

import assets.items.Sword;
import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;

public class Jabberwocky extends Aspect {
	public boolean alive;
	private boolean preparingToBreatheFire;
	public boolean playerJustEnteredLair;
	public boolean playerRaisedShield;
	public boolean playerDazed;
	
	public Jabberwocky(){
		this.name = "jabberwocky";
		this.alive = true;
		this.preparingToBreatheFire = false;
		this.playerJustEnteredLair = false;
		this.playerRaisedShield = false;
		this.playerDazed = false;
	}
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		}
		return false;
	}
	
	protected boolean examine(){
		if( alive ){
			System.out.println("A manxome foe that's about to eat you.");
		} else {
			System.out.println("Its headless corpse is splayed on the ground.");
		}
		return true;
	}
	
	public boolean damage(Item weapon){
		if( !alive ){
			System.out.println("You mash up the Jabberwocky's corpse");
		} else if( preparingToBreatheFire ){
			System.out.println("The Jabberwocky keeps its distance while it inhales more air and your attack misses.");
		} else if( weapon instanceof Sword){
			if( weapon.name.contains("vorpal")){
				System.out.println("Your vorpal blade cuts through the Jabberwocky's neck with a snicker-snack!");
				alive = false;
				Game.hasWon = true;
			} else {
				System.out.println("Your blow connects, but your sword isn't sharp enough to cut through the\nJabbewocky's tough hide!");
			}
		} else {
			System.out.println("Your weak attack hits the Jabberwocky, but it is protected by its thick hide.\n" + 
					"It doesn't even seem to notice you hit it.");
		}
		return true;
	}
	
	public void takeTurn(){
		if( !alive ){
		} else if( playerJustEnteredLair ){
			//Prepare to breath fire
			preparingToBreatheFire = true;
			playerJustEnteredLair = false;
			System.out.println("The Jabberwocky's eyes of flame light up as it senses you.\n" +
								"It backs up a bit and begins to inhale deeply.\nSmoke whiffles from its nostrils.");
		} else if( preparingToBreatheFire ){
			//Firebreath
			preparingToBreatheFire = false;
			System.out.println("The Jabberwocky exhales a massive breath of fire!");
			if( playerRaisedShield ){
				System.out.println("The fire is deflected by your shield!");
				playerRaisedShield = false;
			} else {
				System.out.println("It incinerates you! Maybe you should have blocked it with something.");
				Game.hasLost = true;
			}
		} else {
			//Regular attack
			System.out.println("The Jabberwocky swings its claws at you!");
			if( playerRaisedShield ){
				System.out.println("Your shield blocks its attack!");
				playerRaisedShield = false;
			} else if( playerDazed ){
				System.out.println("The blow knocks you unconscious!");
				System.out.println("The Jabberwocky takes its time eating you.");
				Game.hasLost = true;
			} else {
				System.out.println("The blow sends you flying into the wall!");
				System.out.println("You stagger to your feet, but you feel dizzy.");
				System.out.println("One more hit in that state and you'll be knocked unconscious.");
				playerDazed = true;
				return;
			}
		}
		if( playerDazed == true && !playerJustEnteredLair && Game.hasLost == false){
			System.out.println("You recover your senses.");
		}
		playerRaisedShield = false;
		playerDazed = false;
		return;
	}
}

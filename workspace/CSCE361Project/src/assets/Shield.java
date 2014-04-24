package assets;

import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;
import superClasses.World;

public class Shield extends Item{
	
	public Shield(){
		this.name = "shield";
	}
	
	public boolean interact( String action, Interactable target ){
		if(super.interact(action, target)){
			return true;
		} else if ( action.equals("raise") ){
			return this.raise();
		}
		return false;
	}
	
	protected boolean raise(){
		Jabberwocky jabberwocky = World.jabberwockyLair.jabberwocky;
		if(Game.player.currentLocation.aspects.contains(jabberwocky)){
			jabberwocky.playerRaisedShield = true;
		}
		System.out.println("You raise your shield to block the next attack.");
		return true;
	}
	
	protected boolean examine(){
		System.out.println("A metal kite shield. If you are about to be attacked, you can raise it to block the attack.");
		return true;
	}
}

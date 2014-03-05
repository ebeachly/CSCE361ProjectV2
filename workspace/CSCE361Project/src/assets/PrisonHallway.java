package assets;

import superClasses.Game;
import superClasses.Location;

public class PrisonHallway extends Location {
	
	PrisonHallway(){
		this.aspects.add(Game.world.prisonCellDoor);
		return;
	}
}

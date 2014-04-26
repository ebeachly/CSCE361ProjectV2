package blackboxTests;

import superClasses.Location;
import superClasses.World;

public class PrisonHallway extends Location {
	
	public void construct(){
		this.aspects.add(new PrisonCellDoor(World.prisonCell));
		return;
	}
	
	public void printDescription(){
		System.out.println("A lone torch flickers next to you, and the hallway stretches off to darkness to the north and south.\n"
				+ "In the wall next to you is a cell door.");
		this.printItemsOnGround();
	}
}

package superClasses;

import java.util.ArrayList;

import assets.Guard;

public class TestWorld {

	public static void constructWorld() {
		//First phase of construction: allocate memory for the locations and global aspects
		TestWorld.prisonCell = new assets.PrisonCell();
		TestWorld.prisonHallway = new assets.PrisonHallway();
		
		TestWorld.globalAspects = new ArrayList<Aspect>();
		
		//Second phase of construction: create local aspects and dropped items that might reference locations and global aspects
		// Construct Linkages that might reference other Locations (Second phase
		// of Construction)
		TestWorld.prisonCell.construct();
		TestWorld.prisonHallway.construct();

		Guard prisonGuard = new Guard(prisonCell.getCellDoor());
		globalAspects.add(prisonGuard);
		
		//Put the player in the cell
		Game.player.currentLocation = TestWorld.prisonCell;
		return;
	}

	public static ArrayList<Aspect> globalAspects = null;

	public static assets.PrisonCell prisonCell = null;
	public static assets.PrisonHallway prisonHallway = null;

}

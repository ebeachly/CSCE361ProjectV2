package superClasses;

import java.util.ArrayList;

import assets.Guard;

public class World {

	public static void constructWorld() {
		//First phase of construction: allocate memory for the locations and global aspects
		World.prisonCell = new assets.PrisonCell();
		World.prisonHallway = new assets.PrisonHallway();
		
		World.globalAspects = new ArrayList<Aspect>();
		
		//Second phase of construction: create local aspects and dropped items that might reference locations and global aspects
		// Construct Linkages that might reference other Locations (Second phase
		// of Construction)
		World.prisonCell.construct();
		World.prisonHallway.construct();

		Guard prisonGuard = new Guard(prisonCell.getCellDoor());
		globalAspects.add(prisonGuard);
		return;
	}

	public static ArrayList<Aspect> globalAspects = null;

	public static assets.PrisonCell prisonCell = null;
	public static assets.PrisonHallway prisonHallway = null;

}

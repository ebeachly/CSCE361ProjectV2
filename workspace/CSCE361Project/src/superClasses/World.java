package superClasses;

import java.util.ArrayList;

import assets.Guard;

public class World {

	public static void constructWorld() {
		// Construct Linkages that might reference other Locations (Second phase
		// of Construction)
		World.prisonCell.construct();
		World.prisonHallway.construct();

		Guard prisonGuard = new Guard(prisonCell.getCellDoor());
		globalAspects.add(prisonGuard);
		return;
	}

	/*******************************************
	 * Locations *******************************************
	 * 
	 * Also allocate memory space for all of the locations (First phase of
	 * Construction).
	 * 
	 * If we wanted to, we could move this up to the constructWorld() function,
	 * but it would take more typing. The advantage would be that the program
	 * would use almost no memory while it was in the Main Menu.
	 * 
	 */

	public static ArrayList<Aspect> globalAspects = new ArrayList<Aspect>();

	public static assets.PrisonCell prisonCell = new assets.PrisonCell();
	public static assets.PrisonHallway prisonHallway = new assets.PrisonHallway();

}

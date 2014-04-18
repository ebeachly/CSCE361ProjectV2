package superClasses;

import java.util.ArrayList;

import assets.Guard;
import assets.SWField;


public class World {

	public static void constructWorld() {
		//First phase of construction: allocate memory for the locations and global aspects
		swField = new SWField();
		
		World.globalAspects = new ArrayList<Aspect>();
		
		//Second phase of construction: create local aspects and dropped items that might reference locations and global aspects
		// Construct Linkages that might reference other Locations (Second phase
		// of Construction)
		swField.construct();

		//Initialize global aspects
		
		//Put the player in the starting location
		Game.player.currentLocation = swField;
		
		return;
	}
	
	public static void constructTestWorld() {
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
		
		//Put the player in the cell
		Game.player.currentLocation = World.prisonCell;
		return;
	}

	public static ArrayList<Aspect> globalAspects = null;
	
	//Locations for the main world
	public static assets.SWField swField = null;
	
	//Locations for the test world
	public static assets.PrisonCell prisonCell = null;
	public static assets.PrisonHallway prisonHallway = null;

}

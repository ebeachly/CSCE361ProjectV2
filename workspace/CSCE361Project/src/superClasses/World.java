package superClasses;

import java.util.ArrayList;


public class World {

	public static void constructWorld() {
		//First phase of construction: allocate memory for the locations and global aspects
		swField = new assets.SWField();
		wField = new assets.WField();
		sField = new assets.SField();
		cField = new assets.CField();
		
		World.globalAspects = new ArrayList<Aspect>();
		
		//Second phase of construction: create local aspects and dropped items that might reference locations and global aspects
		// Construct Linkages that might reference other Locations (Second phase
		// of Construction)
		swField.construct();
		wField.construct();
		sField.construct();
		cField.construct();

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

		assets.Guard prisonGuard = new assets.Guard(prisonCell.getCellDoor());
		globalAspects.add(prisonGuard);
		
		//Put the player in the cell
		Game.player.currentLocation = World.prisonCell;
		return;
	}

	public static ArrayList<Aspect> globalAspects = null;
	
	//Locations for the main world
	public static assets.SWField swField = null;
	public static assets.WField wField = null;
	public static assets.SField sField = null;
	public static assets.CField cField = null;
	
	//Locations for the test world
	public static assets.PrisonCell prisonCell = null;
	public static assets.PrisonHallway prisonHallway = null;

}

package superClasses;

import java.util.ArrayList;


public class World {

	public static void constructWorld() {
		//First phase of construction: allocate memory for the locations and global aspects
		swField = new assets.SWField();
		wField = new assets.WField();
		sField = new assets.SField();
		cField = new assets.CField();
		nwField = new assets.NWField();
		nField = new assets.NField();
		eForest = new assets.EForest();
		eForestBuffer = new assets.EForestBuffer();
		neForest = new assets.NEForest();
		neForestBuffer = new assets.NEForestBuffer();
		seForest = new assets.SEForest();
		seForestBuffer = new assets.SEForestBuffer();
		
		World.globalAspects = new ArrayList<Aspect>();
		
		//Second phase of construction: create local aspects and dropped items that might reference locations and global aspects
		// Construct Linkages that might reference other Locations (Second phase
		// of Construction)
		swField.construct();
		wField.construct();
		sField.construct();
		cField.construct();
		nwField.construct();
		nField.construct();
		eForest.construct();
		eForestBuffer.construct();
		neForest.construct();
		neForestBuffer.construct();
		seForest.construct();
		seForestBuffer.construct();

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
	public static assets.NWField nwField = null;
	public static assets.NField nField = null;
	public static assets.EForest eForest = null;
	public static assets.EForestBuffer eForestBuffer = null;
	public static assets.NEForest neForest = null;
	public static assets.NEForestBuffer neForestBuffer = null;
	public static assets.SEForest seForest = null;
	public static assets.SEForestBuffer seForestBuffer = null;
	
	//Locations for the test world
	public static assets.PrisonCell prisonCell = null;
	public static assets.PrisonHallway prisonHallway = null;

}

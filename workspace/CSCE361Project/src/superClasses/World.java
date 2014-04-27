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
		canyon = new assets.Canyon();
		cave = new assets.Cave();
		jabberwockyLair = new assets.JabberwockyLair();
		jubjubLair = new assets.JubjubLair();
		house = new assets.House();
		bridge = new assets.Bridge();
		
		World.globalAspects = new ArrayList<Interactable>();
		
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
		canyon.construct();
		cave.construct();
		jabberwockyLair.construct();
		jubjubLair.construct();
		house.construct();
		bridge.construct();

		//Initialize global aspects
		ears = new assets.Ears();
		globalAspects.add(ears);
		
		//Put the player in the starting location
		Game.player.currentLocation = swField;
		
		return;
	}
	
	public static void constructTestWorld() {
		//First phase of construction: allocate memory for the locations and global aspects
		World.prisonCell = new blackboxTests.PrisonCell();
		World.prisonHallway = new blackboxTests.PrisonHallway();
		
		World.globalAspects = new ArrayList<Interactable>();
		
		//Second phase of construction: create local aspects and dropped items that might reference locations and global aspects
		// Construct Linkages that might reference other Locations (Second phase
		// of Construction)
		World.prisonCell.construct();
		World.prisonHallway.construct();

		blackboxTests.Guard prisonGuard = new blackboxTests.Guard(prisonCell.getCellDoor());
		globalAspects.add(prisonGuard);
		
		//Put the player in the cell
		Game.player.currentLocation = World.prisonCell;
		return;
	}

	public static assets.Ears ears = null;
	public static ArrayList<Interactable> globalAspects = null;
	
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
	public static assets.Canyon canyon = null;
	public static assets.Cave cave = null;
	public static assets.JabberwockyLair jabberwockyLair = null;
	public static assets.JubjubLair jubjubLair = null;
	public static assets.House house = null;
	public static assets.Bridge bridge = null;
	
	//Locations for the test world
	public static blackboxTests.PrisonCell prisonCell = null;
	public static blackboxTests.PrisonHallway prisonHallway = null;

}

package superClasses;

import java.util.ArrayList;


public class World {

	public static void constructWorld() {
		//First phase of construction: allocate memory for the locations and global aspects
		swField = new assets.locations.SWField();
		wField = new assets.locations.WField();
		sField = new assets.locations.SField();
		cField = new assets.locations.CField();
		nwField = new assets.locations.NWField();
		nField = new assets.locations.NField();
		eForest = new assets.locations.EForest();
		eForestBuffer = new assets.locations.EForestBuffer();
		neForest = new assets.locations.NEForest();
		neForestBuffer = new assets.locations.NEForestBuffer();
		seForest = new assets.locations.SEForest();
		seForestBuffer = new assets.locations.SEForestBuffer();
		canyon = new assets.locations.Canyon();
		cave = new assets.locations.Cave();
		jabberwockyLair = new assets.locations.JabberwockyLair();
		jubjubLair = new assets.locations.JubjubLair();
		house = new assets.locations.House();
		bridge = new assets.locations.Bridge();
		
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
		canyon.construct();
		cave.construct();
		jabberwockyLair.construct();
		jubjubLair.construct();
		house.construct();
		bridge.construct();

		//Initialize global aspects
		ears = new assets.aspects.Ears();
		globalAspects.add(ears);
		
		//Put the player in the starting location
		Game.player.currentLocation = swField;
		
		return;
	}

	public static assets.aspects.Ears ears = null;
	public static ArrayList<Aspect> globalAspects = null;
	
	//Locations for the main world
	public static assets.locations.SWField swField = null;
	public static assets.locations.WField wField = null;
	public static assets.locations.SField sField = null;
	public static assets.locations.CField cField = null;
	public static assets.locations.NWField nwField = null;
	public static assets.locations.NField nField = null;
	public static assets.locations.EForest eForest = null;
	public static assets.locations.EForestBuffer eForestBuffer = null;
	public static assets.locations.NEForest neForest = null;
	public static assets.locations.NEForestBuffer neForestBuffer = null;
	public static assets.locations.SEForest seForest = null;
	public static assets.locations.SEForestBuffer seForestBuffer = null;
	public static assets.locations.Canyon canyon = null;
	public static assets.locations.Cave cave = null;
	public static assets.locations.JabberwockyLair jabberwockyLair = null;
	public static assets.locations.JubjubLair jubjubLair = null;
	public static assets.locations.House house = null;
	public static assets.locations.Bridge bridge = null;

}

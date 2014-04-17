package superClasses;

import java.util.ArrayList;

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

	public static ArrayList<Aspect> globalAspects = null;

	public static assets.SWField swField = null;

}

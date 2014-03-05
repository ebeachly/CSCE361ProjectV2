package superClasses;

public class World {
	
	//So, when we try to construct all of these, the parts that link to other parts require the others to already be constructed.
	//We'll need to have two phases of constructors:
	//One where we build the locations, and one where we add the things that reference other locations.
	
	//Locations
	public static assets.PrisonCell prisonCell = new assets.PrisonCell();
	public static assets.PrisonHallway prisonHallway= new assets.PrisonHallway();
	
	//Important Aspects
	public static assets.PrisonCellDoor prisonCellDoor = new assets.PrisonCellDoor();	//This exists between two locations and has states that need to be reflected in both locations.
																						//Normal doors and passage-ways don't need to be here
	
	//Important Items
	//There probably won't need to be any items that have to be stored here.

}

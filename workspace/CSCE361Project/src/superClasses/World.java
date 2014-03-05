package superClasses;

public class World {

	//Locations
	public assets.PrisonCell prisonCell;
	public assets.PrisonHallway prisonHallway;
	
	//Important Aspects
	public assets.PrisonCellDoor prisonCellDoor;
	
	//Important Items
	public assets.PrisonCellKey prisonCellKey;

	//Aspects and Items that aren't unique and don't have persistent, important data don't need to be stored here,
	//and can instead be initialized and stored in a Location.
}

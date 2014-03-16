package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.World;

public class Guard extends Aspect {

	protected static int position = 3;
	private static int delta = -1;
	private PrisonCellDoor cellDoor;

	public Guard(PrisonCellDoor cd) {
		this.name = "guard";
		this.cellDoor = cd;
	}

	@Override
	public boolean interact(String action, Interactable target) {
		if (super.interact(action, target)) {
			return true;
		}
		return false;
	}

	@Override
	public void takeTurn() {
		if (Game.player.currentLocation == World.prisonCell
				|| Game.player.currentLocation == World.prisonHallway) {
			if (position == 2) {
				System.out.println("The guard peers into the cell,"
						+ " checking that the door is secured.");
				if (!this.cellDoor.locked) {
					System.out.println("The door swings open.");
					System.out.println("You have been caught.");
					Game.hasLost = true;
				}
			} else if (Math.abs(position + delta - 2) > Math.abs(position - 2)) {
				System.out.println("The guard walks down the hall");
			} else {
				System.out.println("The guard walks toward your cell");
			}
			position += delta;
			if (position == 4 || position == 0) {
				delta *= -1;
			}
		} else {
			return;
		}
	}

	public boolean examine() {
		System.out.println("A large man with a mustache, and "
				+ "wearing a uniform. You should make him angry.");
		return true;
	}

}

package assets;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.TestWorld;

public class Guard extends Aspect {

	protected int position = 3;
	private int delta = -1;
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
		if (Game.player.currentLocation == TestWorld.prisonCell
				|| Game.player.currentLocation == TestWorld.prisonHallway) {
			if (position == 2) {
				System.out.println("The guard peers into the cell,"
						+ " checking that the door is secured, then continues on.");
				if (!this.cellDoor.locked) {
					System.out.println("The door swings open.");
					System.out.println("You have been caught.");
					Game.hasLost = true;
				} else if (Game.player.currentLocation == TestWorld.prisonHallway) {
					System.out
							.println("The guard is confused by your absence.");
					Game.hasWon = true;
				}
			} else if (position == 5 || position == -1) {
				System.out.println("The guard turns around.");
				delta *= -1;
				if (Game.player.currentLocation == TestWorld.prisonHallway) {
					System.out
							.println("You step out of your cell in full view of the guard.");
					System.out.println("You have been caught.");
					Game.hasLost = true;
				}
			} else if (Math.abs(position + delta - 2) > Math.abs(position - 2)) {
				System.out.println("The guard walks away from your cell.");
				if (Game.player.currentLocation == TestWorld.prisonHallway) {
					System.out.println("You escape silently into the shadows.");
					Game.hasWon = true;
				}
			} else {
				System.out.println("The guard walks toward your cell.");
				if (Game.player.currentLocation == TestWorld.prisonHallway) {
					System.out
							.println("You step out of your cell in full view of the guard.");
					System.out.println("You have been caught.");
					Game.hasLost = true;
				}
			}
			position += delta;
		} else {
			return;
		}
	}

	protected boolean examine() {
		System.out.println("A large man with a mustache, and "
				+ "wearing a uniform. You should make him angry.");
		return true;
	}

}

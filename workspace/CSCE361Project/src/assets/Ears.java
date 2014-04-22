package assets;

import superClasses.Aspect;

public class Ears extends Aspect {

	private boolean plugged = false;

	public Ears() {
		name = "ears";
	}

	protected boolean plug() {
		plugged = true;
		return true;
	}

	protected boolean unplug() {
		plugged = false;
		return true;
	}

	protected boolean arePlugged() {
		return plugged;
	}

}

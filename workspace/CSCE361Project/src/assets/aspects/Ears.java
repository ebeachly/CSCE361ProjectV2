package assets.aspects;

import superClasses.Aspect;

public class Ears extends Aspect {

	private boolean plugged = false;

	public Ears() {
		name = "ears";
	}

	public boolean plug() {
		plugged = true;
		return true;
	}

	public boolean unplug() {
		plugged = false;
		return true;
	}

	public boolean arePlugged() {
		return plugged;
	}

}

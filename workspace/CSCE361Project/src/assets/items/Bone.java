package assets.items;

import superClasses.Item;

public class Bone extends Item {

	public Bone(){
		this.name = "bone";
	}

	protected boolean examine(){
		System.out.println("It looks like a femur of a human! It is charred and has tooth marks.");
		return true;
	}
}

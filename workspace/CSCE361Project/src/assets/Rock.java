package assets;

import superClasses.Item;

public class Rock extends Item {

	public Rock(String adjective) {
		setName(adjective);
	}
	
	public Rock(){
		setName("");
	}
	
	private void setName(String adjective){
		if (!adjective.isEmpty()) {
			this.name = adjective + " rock";
		} else {
			this.name = "rock";
		}
	}
	public boolean examine() {
		System.out.println("A "+ this.name);
		return true;
	}
}

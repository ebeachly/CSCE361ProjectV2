package assets;

import superClasses.Item;

public class Pamphlet extends Item {

	public Pamphlet() {
		this.name = "pamphlet";
	}
	
	protected boolean examine(){		
		System.out.println(	  "+-----------------------------------------------------+\n"
							+ "|                                                     |\n"
							+ "|           500 Floren Bounty & Noble Title           |\n"
							+ "|                                                     |\n"
							+ "|      To the man who brings the head of the vile     |\n"
							+ "|                     Jabberwocky                     |\n"
							+ "|        to the castle of the illustrious Duke        |\n"
							+ "|                                                     |\n"
							+ "|       The vile creature makes its lair in the       |\n"
							+ "|                     Tulgey Woods                    |\n"
							+ "|                                                     |\n"
							+ "+-----------------------------------------------------+"
							);
		return true;
	}

}

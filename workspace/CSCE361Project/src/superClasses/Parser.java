package superClasses;

public class Parser {
	
	//For storing the output of the parser function (Basically a way to return more than one thing)
	String parsedVerb;
	String parsedDirectObject;
	String parsedIndirectObject;
	
	//TODO: some sort of Thesaurus. I want separate ones for verbs and nouns.
	
	public void inputCommand(){
		//TODO: implement
		//Gets input, parses it, and executes it.
		
		//To parse:
		// tokenize on prepositions EX:("at", "with", "use", "to")
		// the preposition that precedes the token defines what kind of word you expect it to be (verb or noun)
		// try to match the token with known verb or noun using the thesaurus.
		// if no match, cut words off the front or back and try to match it again ( there might be adverbs/adjectives )
		// if the verb has not been found, it is probably the first word/words.
		// the indirect object is not necessary.
		// if a match is ambiguous, like the player said just "key", and the game has two kinds of keys "cell key" and "skeleton key", search for the context, and see if only one key is visible to the user.
		// Some possible command structures: "use Object to Action Target" "Action Object at Target" "Action Target with Object" "Action Object"
		// Command structures like "Action Target" assume the Player is the direct object, and are indistinguishable from "Action Object". Therefore you have to check for them separately (Pick up item, Check inventory).
		
		//Different types of commands to check for:
		// Quit (Possibly a function implemented in Game?)
		// Functions in Player (pick up / check inventory)
		// else treat it as: use item in inventory or aspect in current location (Call interact on the direct object and pass the indirect object)
		
		return;
	}
	
	public Interactable findTarget(){
		//TODO: implement
		//Searches inventory and aspect list of the current location for the target with the correct name.
		//Don't search through items on the ground because they shouldn't be usable.
		//Asks for clarification if there are no matches.
		return null;
	}
	
	
}

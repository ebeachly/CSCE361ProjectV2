package superClasses;

import java.util.HashMap;
import java.util.LinkedList;

public class Parser {

	HashMap<String, String> verbs;
	HashMap<String, String> nouns;
	
	public String object;
	public String action;
	public String target;

	public Parser() {
		this.verbs = new HashMap<String, String>();
		this.nouns = new HashMap<String, String>();

		verbs.put("quit", "quit");
		verbs.put("q", "quit");
		verbs.put("exit game", "quit");
		verbs.put("exit", "quit");

		verbs.put("examine", "examine");
		verbs.put("check", "examine");
		verbs.put("inspect", "examine");
		verbs.put("investigate", "examine");
		verbs.put("look", "examine");
		verbs.put("stare", "examine");
		verbs.put("view", "examine");
		verbs.put("describe", "examine");

		verbs.put("pick up", "pick up");
		verbs.put("grab", "pick up");
		verbs.put("gather", "pick up");

		verbs.put("drop", "drop");
		verbs.put("throw away", "drop");

		verbs.put("go", "go");
		verbs.put("run", "go");
		verbs.put("walk", "go");
		verbs.put("travel", "go");
		verbs.put("enter", "go");

		verbs.put("attack", "attack");
		verbs.put("strike", "attack");
		verbs.put("swing", "attack");
		verbs.put("stab", "attack");
		verbs.put("slice", "attack");
		verbs.put("chop", "attack");
		verbs.put("kill", "attack");

		verbs.put("toss", "toss");
		verbs.put("throw", "toss");
		verbs.put("fling", "toss");
		verbs.put("hurl", "toss");
		
		verbs.put("open", "open");

		verbs.put("close", "close");
		verbs.put("shut", "close");

		verbs.put("unlock", "unlock");

		verbs.put("lock", "lock");

		verbs.put("wait", "wait");

		nouns.put("inventory", "inventory");
		nouns.put("bag", "inventory");
		nouns.put("items", "inventory");
		nouns.put("possessions", "inventory");

		nouns.put("status", "status");
		nouns.put("self", "status");
		nouns.put("myself", "status");
		nouns.put("health", "status");
		
		nouns.put("map", "map");
		
		nouns.put("pamphlet", "pamphlet");
		nouns.put("paper", "pamphlet");
		nouns.put("flyer", "pamphlet");

		nouns.put("key", "key");
		nouns.put("cell key", "cell key");

		nouns.put("door", "door");
		nouns.put("cell door", "cell door");

		nouns.put("sword", "sword");
		
		nouns.put("rock", "rock");
		nouns.put("stone", "rock");
		nouns.put("pebble", "rock");
		
		nouns.put("goblin", "goblin");
		
		nouns.put("north", "north");
		nouns.put("n", "north");
		nouns.put("east", "east");
		nouns.put("e", "east");
		nouns.put("south", "south");
		nouns.put("s", "south");
		nouns.put("west", "west");
		nouns.put("w", "west");
		
		nouns.put("room", "location");
		nouns.put("location", "location");
		nouns.put("field", "location");
		nouns.put("forest", "location");
		
		nouns.put("cave entrance", "cave entrance");
		nouns.put("cave mouth", "cave entrance");
		nouns.put("cave", "cave entrance");
		
		nouns.put("tunnel", "tunnel");
		
		nouns.put("bone", "bone");
		nouns.put("femur", "bone");
	}

	public boolean parseInput(String input) {
		// parses input into the object, action, and target. Returns false if the input was not
		// understood.

		// To parse:
		// tokenize on prepositions EX:("at", "with", "use", "to")
		// the preposition that precedes the token defines what kind of word you
		// expect it to be (verb or noun)
		// try to match the token with known verb or noun using the thesaurus.
		// if no match, cut words off the front or back and try to match it
		// again ( there might be adverbs/adjectives )
		// if the verb has not been found, it is probably the first word/words.
		// the indirect object is not necessary.
		// if a match is ambiguous, like the player said just "key", and the
		// game has two kinds of keys "cell key" and "skeleton key", search for
		// the context, and see if only one key is visible to the user.
		// Some possible command structures: "use Object to Action Target"
		// "Action Object at Target" "Action Target with Object" "Action Object"
		// Command structures like "Action Target" assume the Player is the
		// direct object, and are indistinguishable from "Action Object".
		// Therefore you have to check for them separately (Pick up item, Check
		// inventory).

		// Different types of commands to check for:
		// Quit (Possibly a function implemented in Game?)
		// Functions in Player (pick up / check inventory)
		// else treat it as: use item in inventory or aspect in current location
		// (Call interact on the direct object and pass the indirect object)

		// Sanitize the input
		// Convert uppercase to lowercase letters
		input = input.toLowerCase();
		// remove all characters that aren't lowercase letters or spaces
		// input.replaceAll("[^a-z ]", "");
		// simplify all whitespace
		// input.replaceAll(" ++", " ");

		// Tokenize into words
		String[] words = input.split(" ");

		// Find the Parts of Speech: Action, Object, and Target

		// These indices represent the range that the part of speech could exist
		// in.
		int startIndexOfObject = 0;
		int endIndexOfObject = words.length - 1;
		int startIndexOfAction = 0;
		int endIndexOfAction = words.length - 1;
		int startIndexOfTarget = 0;
		int endIndexOfTarget = words.length - 1;

		// First, look for prepositions
		int currentPartOfSpeechBeingSearchedFor = 0; // 0: None, 1: Object, 2:
														// Action, 3: Target

		// Iterate through up to the second to last word, because if the
		// preposition is the last word, then we can't say that there is a part
		// of speech after it.
		for (int i = 0; i < words.length - 1; ++i) {

			// Start defining the range the part of speech is in, given what the
			// preposition is.
			if (words[i].equals("with") || words[i].equals("use")) {

				// Stop defining the range the previous part of speech was in
				if (currentPartOfSpeechBeingSearchedFor != 0 && i >= 1) {
					if (currentPartOfSpeechBeingSearchedFor == 2) {
						endIndexOfAction = i - 1;
					} else if (currentPartOfSpeechBeingSearchedFor == 3) {
						endIndexOfTarget = i - 1;
					}
				}

				// Start defining the range the Object is in
				startIndexOfObject = i + 1;
				currentPartOfSpeechBeingSearchedFor = 1;

			} else if (words[i].equals("to")) {

				// Stop defining the range the previous part of speech was in
				if (currentPartOfSpeechBeingSearchedFor != 0 && i >= 1) {
					if (currentPartOfSpeechBeingSearchedFor == 1) {
						endIndexOfObject = i - 1;
					} else if (currentPartOfSpeechBeingSearchedFor == 3) {
						endIndexOfTarget = i - 1;
					}
				}

				// Start defining the range the Action is in
				startIndexOfAction = i + 1;
				currentPartOfSpeechBeingSearchedFor = 2;

			} else if (words[i].equals("at") || words[i].equals("in") ){

				// Stop defining the range the previous part of speech was in
				if (currentPartOfSpeechBeingSearchedFor != 0 && i >= 1) {
					if (currentPartOfSpeechBeingSearchedFor == 1) {
						endIndexOfObject = i - 1;
					} else if (currentPartOfSpeechBeingSearchedFor == 2) {
						endIndexOfAction = i - 1;
					}
				}

				// Start defining the range the Target is in
				startIndexOfTarget = i + 1;
				currentPartOfSpeechBeingSearchedFor = 3;

			} else if (i == 0) {

				// The first word was not a preposition.
				// We can assume the Action will be in the first section if the
				// first word was not a preposition
				currentPartOfSpeechBeingSearchedFor = 2;

			}
			// End for loop
		}

		// System.out.println("DEBUG: number of words " + words.length);
		// System.out.println("DEBUG: action is inclusively between words "
		// + startIndexOfAction + " and " + endIndexOfAction);
		// System.out.println("DEBUG: object is inclusively between words "
		// + startIndexOfObject + " and " + endIndexOfObject);
		// System.out.println("DEBUG: target is inclusively between words "
		// + startIndexOfTarget + " and " + endIndexOfTarget);

		// So we have defined ranges of where we think the parts of speech are.
		// Now we need to find the parts of speech within those ranges by
		// checking for matches with our Thesaurus

		action = "";
		object = "";
		target = "";

		// The action is the most important word to find. Search looking for a
		// match for that first.

		// We will search within the range by first chopping off words from the
		// end. If no matches arise, then we'll chop off a value from the
		// beginning and repeat.
		boolean match = false;
		while (startIndexOfAction <= endIndexOfAction) {

			int tempEndIndex = endIndexOfAction;

			while (startIndexOfAction <= tempEndIndex) {

				// Construct what we think is the string for the part of speech
				action = words[startIndexOfAction];
				for (int i = startIndexOfAction + 1; i <= tempEndIndex; ++i) {
					action = action + " " + words[i];
				}

				// Check if there is a match in our thesaurus
				action = verbs.get(action);
				if (action != null) {
					match = true;
					endIndexOfAction = tempEndIndex;
					break;
				}
				// If no match, decrease the end index
				--tempEndIndex;
			}

			if (match) {
				break;
			}
			// If no match for all patterns that start with this word, increase
			// the start index and reset the end index
			++startIndexOfAction;
		}
		if (!match) {
			action = "";
			System.out.println("SYSTEM: Could not recognize an action in your input.");
			return false;
		}

		// Update the start or end indices of the other parts of speech if they
		// fall within what we have identified as the action
		if (startIndexOfObject >= startIndexOfAction
				&& startIndexOfObject <= endIndexOfAction
				&& endIndexOfAction != words.length) {
			startIndexOfObject = endIndexOfAction + 1;
		}
		if (endIndexOfObject >= startIndexOfAction
				&& endIndexOfObject <= endIndexOfAction
				&& startIndexOfAction != 0) {
			endIndexOfObject = startIndexOfAction - 1;
		}
		if (startIndexOfTarget >= startIndexOfAction
				&& startIndexOfTarget <= endIndexOfAction
				&& endIndexOfAction != words.length) {
			startIndexOfTarget = endIndexOfAction + 1;
		}
		if (endIndexOfTarget >= startIndexOfAction
				&& endIndexOfTarget <= endIndexOfAction
				&& startIndexOfAction != 0) {
			endIndexOfTarget = startIndexOfAction - 1;
		}

		// Next we need to find the Object
		// We will search within the range by first chopping off words from the
		// end. If no matches arise, then we'll chop off a value from the
		// beginning and repeat.
		match = false;
		while (startIndexOfObject <= endIndexOfObject) {

			int tempEndIndex = endIndexOfObject;

			while (startIndexOfObject <= tempEndIndex) {

				// If we're looking inside what we've identified as the action,
				// no point
				if (startIndexOfObject >= startIndexOfAction
						&& tempEndIndex <= endIndexOfAction) {
					break;
				}

				// Construct what we think is the string for the part of speech
				object = words[startIndexOfObject];
				for (int i = startIndexOfObject + 1; i <= tempEndIndex; ++i) {
					object = object + " " + words[i];
				}

				// Check if there is a match in our thesaurus
				object = nouns.get(object);
				if (object != null) {
					match = true;
					endIndexOfObject = tempEndIndex;
					break;
				}
				// If no match, decrease the end index
				--tempEndIndex;
			}

			if (match) {
				break;
			}
			// If no match for all patterns that start with this word, increase
			// the start index and reset the end index
			++startIndexOfObject;
		}
		// if object is null, set it to the empty string
		if (object == null) {
			object = "";
		}

		// Update the target indices based off what we have learned about the
		// object.
		if (startIndexOfTarget >= startIndexOfObject
				&& startIndexOfTarget <= endIndexOfObject
				&& endIndexOfObject != words.length) {
			startIndexOfTarget = endIndexOfObject + 1;
		}
		if (endIndexOfTarget >= startIndexOfObject
				&& endIndexOfTarget <= endIndexOfObject
				&& startIndexOfObject != 0) {
			endIndexOfTarget = startIndexOfObject - 1;
		}

		// Next we will try to find the Target
		// We will search within the range by first chopping off words from the
		// end. If no matches arise, then we'll chop off a value from the
		// beginning and repeat.
		match = false;
		while (startIndexOfTarget <= endIndexOfTarget) {

			int tempEndIndex = endIndexOfTarget;

			while (startIndexOfTarget <= tempEndIndex) {

				// If we're looking inside what we've identified as the action,
				// or the object, no point
				if ((startIndexOfTarget >= startIndexOfAction && tempEndIndex <= endIndexOfAction)
						|| (startIndexOfTarget >= startIndexOfObject && tempEndIndex <= endIndexOfObject)) {
					break;
				}

				// Construct what we think is the string for the part of speech
				target = words[startIndexOfTarget];
				for (int i = startIndexOfTarget + 1; i <= tempEndIndex; ++i) {
					target = target + " " + words[i];
				}

				// Check if there is a match in our thesaurus
				target = nouns.get(target);
				if (target != null) {
					match = true;
					endIndexOfTarget = tempEndIndex;
					break;
				}
				// If no match, decrease the end index
				--tempEndIndex;
			}

			if (match) {
				break;
			}
			// If no match for all patterns that start with this word, increase
			// the start index and reset the end index
			++startIndexOfTarget;
		}
		// if target is null, set it to the empty string
		if (target == null) {
			target = "";
		}

		// Now we have found the action, the object, and maybe the target. Time
		// to execute the command
		
		// DEBUG
		//System.out.println("DEBUG: Action: " + action);
		//System.out.println("DEBUG: Object: " + object);
		//System.out.println("DEBUG: Target: " + target);
		
		return true;
	}
	
	public boolean executeCommand(){
		// First check if it is a special command:
		
		if (this.action.equals("quit")) {
			Game.quit();
			return true;
		} else if (this.action.equals("examine") && this.object.equals("inventory")) {
			Game.player.viewInventory();
			return true;
		} else if (this.action.equals("examine") && this.object.equals("location")) {
			Game.player.currentLocation.printDescription();
			return true;
		} else if (this.action.equals("examine") && this.object.equals("status")) {
			// Game.player.viewStatus();
			return true;
		} else if (this.action.equals("pick up")) {
			Game.player.pickUp(this.object); // pickup needs to find the object and
										// remove it, so if we found the
										// pointer, we would just have to search
										// again anyways because we still don't
										// know where it is.
			return true;
		} else if (this.action.equals("wait")) {
			System.out.println("Some time goes by.");
			return true;
		} else {
			// Otherwise, it is a normal command
			Interactable objectPointer = findInteractable(this.object);
			Interactable targetPointer = findInteractable(this.target);
			if (objectPointer == null) {
				if( this.object.isEmpty() ){
					System.out.println("SYSTEM: could not identify a direct object in your input.");
					return false;
				} else {
					System.out.println("You can't find a " + this.object + ".");
					return true;
				}
			}
			boolean result = objectPointer.interact(this.action, targetPointer);
			if( !result ){
				System.out.println("SYSTEM: That is not a valid use of that object.");
			}
			return result;
		}
	}

	private Interactable findInteractable(String name) {
		// Searches inventory and aspect list of the current location for a
		// match to name.
		// Don't search through items on the ground because they shouldn't be
		// usable.
		
		// check if name is null or empty
		if( name == null || name.isEmpty() || name.equals(" ")){
			return null;
		}

		LinkedList<Interactable> potentialMatches = new LinkedList<Interactable>();

		// Search through the player's inventory
		for (Interactable i : Game.player.inventory) {
			if (i.name.equals(name)) {
				// Direct match, return this
				return i;
			} else if (i.name.contains(name)) {

				// If it has the same name as something already in the list,
				// don't add it
				boolean unique = true;
				for (Interactable j : potentialMatches) {
					if (i.name.equals(j.name)) {
						unique = false;
					}
				}

				if (unique) {
					potentialMatches.add(i);
				}

			}
		}

		// Search through the aspects in the player's current location
		for (Interactable i : Game.player.currentLocation.aspects) {
			if (i.name.equals(name)) {
				// Direct match, return this
				return i;
			} else if (i.name.contains(name)) {

				// If it has the same name as something already in the list,
				// don't add it
				boolean unique = true;
				for (Interactable j : potentialMatches) {
					if (i.name.equals(j.name)) {
						unique = false;
					}
				}

				if (unique) {
					potentialMatches.add(i);
				}

			}
		}
		
		// Search through the aspects in the global aspects list
		for (Interactable i : World.globalAspects) {
			if (i.name.equals(name)) {
				// Direct match, return this
				return i;
			} else if (i.name.contains(name)) {

				// If it has the same name as something already in the list,
				// don't add it
				boolean unique = true;
				for (Interactable j : potentialMatches) {
					if (i.name.equals(j.name)) {
						unique = false;
					}
				}

				if (unique) {
					potentialMatches.add(i);
				}

			}
		}

		// Return matches
		if (potentialMatches.isEmpty()) {
			return null;
		} else if (potentialMatches.size() == 1) {
			return potentialMatches.getFirst();
		} else {
			// Ambiguity
			System.out
					.println("SYSTEM: Could not determine what you meant by "
							+ name
							+ ". Please rephrase your input using one of these:");
			for (Interactable i : potentialMatches) {
				System.out.println("   " + i.name);
			}
			return null;
		}
	}

	public static boolean parseMenuOption(String input) {
		input = input.toLowerCase();
		if (input.equals("quit") || input.equals("q")) {
			Game.quit();
			return false;
		} else if (input.equals("new") || input.equals("new game")
				|| input.equals("n")) {
			return true;
		} else {
			return false;
		}
	}
}

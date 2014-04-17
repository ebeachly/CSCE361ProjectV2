package superClasses;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Game {

	public static Player player;
	public static Parser parser;
	public static boolean hasLost = false;
	public static boolean hasWon = false;
	public static Queue<Aspect> aspects;
	protected static Scanner in = new Scanner(System.in);

	public static void main(String args[]) {
		player = new Player();
		parser = new Parser();
		in = new Scanner(System.in);
		Scanner console = in;
		String input;
		while (true) {
			hasLost = false;
			hasWon = false;
			System.out
					.println(""
							+ "     ____.     ___.  ___.                                      __           \n"
							+ "    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__.\n"
							+ "    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |\n"
							+ "/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |\n"
							+ "\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|\n"
							+ "              \\/    \\/    \\/     \\/                         \\/     \\/\\/     ");
			System.out.println("Type:");
			System.out.println("\"new game\" to start new game");
			System.out.println("\"quit\" to quit");
			do {
				System.out.print(">> ");
				input = console.nextLine();
			} while (Parser.parseMenuOption(input) == 0);

			// Load the world.
			World.constructWorld();
			// clear aspect queue
			clearAspectQueue();

			player.currentLocation.printDescription();

			while (!hasLost && !hasWon) {
				do {
					System.out.print(">> ");
					input = console.nextLine();
				} while (!parser.parseInputAndExecute(input));
					aspects.addAll(World.globalAspects);
					aspects.addAll(player.currentLocation.aspects);
				while (!aspects.isEmpty()) {
					aspects.poll().takeTurn();
				}
			}

			if (hasWon) {
				System.out.println("YOU WON!");
			} else {
				System.out.println("YOU LOSE!");
			}

		}

		// Main Menu

		// Turn Manager:
		// Player turn
		// Check to see if game over?
		// Use a queue to hold the aspects that want to take a turn.
		// Add a method to empty the queue (in case an aspect causes a change of
		// location).
	}

	public static void clearAspectQueue() {
		aspects = new ArrayDeque<Aspect>();
	}

	public static void quit() {
		String response;
		System.out.println("Are you sure you want to quit? (y/n)");
		do {
			System.out.print(">>");
			response = in.nextLine().toLowerCase();
			if (response.equals("y") || response.equals("yes")) {
				in.close();
				System.exit(0);
			} else if (response.equals("n") || response.equals("no")) {
				return;
			}
		} while (true);
	}

}

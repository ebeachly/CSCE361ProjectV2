package jUnitTests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import superClasses.Game;

public class TestGame {

	final static PrintStream stdout = System.out;
	final static InputStream stdin = System.in;
	private static InputStream in = null;
	private static PrintStream out = null;

	@Before
	public void setUp() throws Exception {
		// Setup testing utilities
		out = new PrintStream("testing.txt");
		System.setOut(out);
		Game.quit = false;
	}
	
	@Test
	public void test(){
		Game game = new Game();
		assertNotNull(game);
		Game.clearAspectQueue();
	}

	@Test
	public void testQuit() throws FileNotFoundException {
		clearCommands();
		addCommand("quit");
		addCommand("quit");
		addCommand("what");
		addCommand("no");
		addCommand("quit");
		addCommand("n");
		addCommand("quit");
		addCommand("yes");
		System.setIn(in);
		Game.main(null);

		clearCommands();
		addCommand("what");
		addCommand("quit");
		addCommand("y");
		System.setIn(in);
		Game.main(null);

		// Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();

		assertArrayEquals(
				"     ____.     ___.  ___.                                      __           "
						.toCharArray(),
				testOutput.get(0).toCharArray());
		assertArrayEquals(
				"    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__."
						.toCharArray(), testOutput.get(1).toCharArray());
		assertArrayEquals(
				"    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |"
						.toCharArray(), testOutput.get(2).toCharArray());
		assertArrayEquals(
				"/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |"
						.toCharArray(), testOutput.get(3).toCharArray());
		assertArrayEquals(
				"\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|"
						.toCharArray(), testOutput.get(4).toCharArray());
		assertArrayEquals(
				"              \\/    \\/    \\/     \\/                         \\/     \\/\\/     "
						.toCharArray(), testOutput.get(5).toCharArray());
		assertArrayEquals("Type:".toCharArray(), testOutput.get(6)
				.toCharArray());
		assertArrayEquals("\"new game\" to start new game".toCharArray(),
				testOutput.get(7).toCharArray());
		assertArrayEquals("\"quit\" to quit".toCharArray(), testOutput.get(8)
				.toCharArray());
		assertArrayEquals(
				">> Are you sure you want to quit? (y/n)".toCharArray(),
				testOutput.get(9).toCharArray());
		assertArrayEquals(
				">> >> >> >> Are you sure you want to quit? (y/n)".toCharArray(),
				testOutput.get(10).toCharArray());
		assertArrayEquals(
				">> >> Are you sure you want to quit? (y/n)".toCharArray(),
				testOutput.get(11).toCharArray());
		assertArrayEquals(
				">>      ____.     ___.  ___.                                      __           "
						.toCharArray(), testOutput.get(12).toCharArray());
		assertArrayEquals(
				"    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__."
						.toCharArray(), testOutput.get(13).toCharArray());
		assertArrayEquals(
				"    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |"
						.toCharArray(), testOutput.get(14).toCharArray());
		assertArrayEquals(
				"/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |"
						.toCharArray(), testOutput.get(15).toCharArray());
		assertArrayEquals(
				"\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|"
						.toCharArray(), testOutput.get(16).toCharArray());
		assertArrayEquals(
				"              \\/    \\/    \\/     \\/                         \\/     \\/\\/     "
						.toCharArray(), testOutput.get(17).toCharArray());
		assertArrayEquals("Type:".toCharArray(), testOutput.get(18)
				.toCharArray());
		assertArrayEquals("\"new game\" to start new game".toCharArray(),
				testOutput.get(19).toCharArray());
		assertArrayEquals("\"quit\" to quit".toCharArray(), testOutput.get(20)
				.toCharArray());
	}

	@Test
	public void testNewGame() throws FileNotFoundException {
		clearCommands();
		addCommand("new");
		addCommand("quit");
		addCommand("y");
		System.setIn(in);
		Game.main(null);

		// Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();

		assertArrayEquals(
				"     ____.     ___.  ___.                                      __           "
						.toCharArray(),
				testOutput.get(0).toCharArray());
		assertArrayEquals(
				"    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__."
						.toCharArray(), testOutput.get(1).toCharArray());
		assertArrayEquals(
				"    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |"
						.toCharArray(), testOutput.get(2).toCharArray());
		assertArrayEquals(
				"/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |"
						.toCharArray(), testOutput.get(3).toCharArray());
		assertArrayEquals(
				"\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|"
						.toCharArray(), testOutput.get(4).toCharArray());
		assertArrayEquals(
				"              \\/    \\/    \\/     \\/                         \\/     \\/\\/     "
						.toCharArray(), testOutput.get(5).toCharArray());
		assertArrayEquals("Type:".toCharArray(), testOutput.get(6)
				.toCharArray());
		assertArrayEquals("\"new game\" to start new game".toCharArray(),
				testOutput.get(7).toCharArray());
		assertArrayEquals("\"quit\" to quit".toCharArray(), testOutput.get(8)
				.toCharArray());
		assertArrayEquals(">> You are in an empty field.".toCharArray(),
				testOutput.get(9).toCharArray());
		assertArrayEquals(
				"To the north there is a road that runs east and west."
						.toCharArray(),
				testOutput.get(10).toCharArray());
		assertArrayEquals(
				"To the east there is a field and a house.".toCharArray(),
				testOutput.get(11).toCharArray());
		assertArrayEquals(
				"To the west there is a rapid river that pours off a cliff into the sea."
						.toCharArray(),
				testOutput.get(12).toCharArray());
		assertArrayEquals(
				"Beyond that is a crenelated castle wall with many towers."
						.toCharArray(),
				testOutput.get(13).toCharArray());
		assertArrayEquals(
				"To the south there is a deadly cliff that drops off to the sea."
						.toCharArray(),
				testOutput.get(14).toCharArray());
		assertArrayEquals("Your inventory contains:".toCharArray(), testOutput
				.get(15).toCharArray());
		assertArrayEquals("   sword".toCharArray(), testOutput.get(16)
				.toCharArray());
		assertArrayEquals("   pocket lint".toCharArray(), testOutput.get(17)
				.toCharArray());
		assertArrayEquals(
				"Suddenly a piece of paper comes soaring on the wind and lands right in front of your feet."
						.toCharArray(), testOutput.get(18).toCharArray());
		assertArrayEquals("On the ground there is a: pamphlet.".toCharArray(),
				testOutput.get(19).toCharArray());
		// assertArrayEquals("".toCharArray(),
		// testOutput.get(20).toCharArray());
	}

	
	@Test
	public void testGarbage() throws FileNotFoundException {
		clearCommands();
		addCommand("asdf");
		addCommand("quit");
		addCommand("y");
		System.setIn(in);
		Game.main(null);

		// Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();

		assertArrayEquals(
				"     ____.     ___.  ___.                                      __           "
						.toCharArray(),
				testOutput.get(0).toCharArray());
		assertArrayEquals(
				"    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__."
						.toCharArray(), testOutput.get(1).toCharArray());
		assertArrayEquals(
				"    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |"
						.toCharArray(), testOutput.get(2).toCharArray());
		assertArrayEquals(
				"/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |"
						.toCharArray(), testOutput.get(3).toCharArray());
		assertArrayEquals(
				"\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|"
						.toCharArray(), testOutput.get(4).toCharArray());
		assertArrayEquals(
				"              \\/    \\/    \\/     \\/                         \\/     \\/\\/     "
						.toCharArray(), testOutput.get(5).toCharArray());
		assertArrayEquals("Type:".toCharArray(), testOutput.get(6)
				.toCharArray());
		assertArrayEquals("\"new game\" to start new game".toCharArray(),
				testOutput.get(7).toCharArray());
		assertArrayEquals("\"quit\" to quit".toCharArray(), testOutput.get(8)
				.toCharArray());
		assertArrayEquals(
				">> >> Are you sure you want to quit? (y/n)".toCharArray(),
				testOutput.get(9).toCharArray());
		// assertArrayEquals("".toCharArray(),
		// testOutput.get(20).toCharArray());
	}

	@Test
	public void testWin() throws FileNotFoundException {
		clearCommands();
		addCommand("new game");
		addCommand("go east");
		addCommand("enter house");
		addCommand("examine bed");
		addCommand("exit front door");
		addCommand("go north");
		addCommand("go north");
		addCommand("put lint in ears");
		addCommand("go north");
		addCommand("kill jubjub with sword");
		addCommand("give sword to wizard");
		addCommand("go south");
		addCommand("go south");
		addCommand("go west");
		addCommand("use coins to buy shield");
		addCommand("go south");
		addCommand("go south");
		addCommand("go east");
		addCommand("go east");
		addCommand("enter cave");
		addCommand("go through tunnel");
		addCommand("raise shield");
		addCommand("attack jabberwocky with sword");
		addCommand("quit");
		addCommand("yes");
		System.setIn(in);
		Game.main(null);

		// Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();

		assertArrayEquals(
				"_____.___.               __      __            ._._._."
						.toCharArray(),
				testOutput.get(testOutput.size() - 18).toCharArray());
		assertArrayEquals(
				"\\__  |   | ____  __ __  /  \\    /  \\____   ____| | | |"
						.toCharArray(),
				testOutput.get(testOutput.size() - 17).toCharArray());
		assertArrayEquals(
				" /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  _ \\ /    \\ | | |"
						.toCharArray(),
				testOutput.get(testOutput.size() - 16).toCharArray());
		assertArrayEquals(
				"\\____   (  <_> )  |  /  \\        (  <_> )   |  \\|\\|\\|"
						.toCharArray(),
				testOutput.get(testOutput.size() - 15).toCharArray());
		assertArrayEquals(
				"/ ______|\\____/|____/    \\__/\\  / \\____/|___|  /_____"
						.toCharArray(),
				testOutput.get(testOutput.size() - 14).toCharArray());
		assertArrayEquals(
				"\\/                            \\/             \\/\\/\\/\\/"
						.toCharArray(),
				testOutput.get(testOutput.size() - 13).toCharArray());
		assertArrayEquals("".toCharArray(),
				testOutput.get(testOutput.size() - 12).toCharArray());
		assertArrayEquals(
				"     ____.     ___.  ___.                                      __           "
						.toCharArray(),
				testOutput.get(testOutput.size() - 11).toCharArray());
		assertArrayEquals(
				"    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__."
						.toCharArray(), testOutput.get(testOutput.size() - 10)
						.toCharArray());
		assertArrayEquals(
				"    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |"
						.toCharArray(), testOutput.get(testOutput.size() - 9)
						.toCharArray());
		assertArrayEquals(
				"/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |"
						.toCharArray(), testOutput.get(testOutput.size() - 8)
						.toCharArray());
		assertArrayEquals(
				"\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|"
						.toCharArray(), testOutput.get(testOutput.size() - 7)
						.toCharArray());
		assertArrayEquals(
				"              \\/    \\/    \\/     \\/                         \\/     \\/\\/     "
						.toCharArray(), testOutput.get(testOutput.size() - 6)
						.toCharArray());
		assertArrayEquals("Type:".toCharArray(),
				testOutput.get(testOutput.size() - 5).toCharArray());
		assertArrayEquals("\"new game\" to start new game".toCharArray(),
				testOutput.get(testOutput.size() - 4).toCharArray());
		assertArrayEquals("\"quit\" to quit".toCharArray(),
				testOutput.get(testOutput.size() - 3).toCharArray());
		assertArrayEquals(
				">> Are you sure you want to quit? (y/n)".toCharArray(),
				testOutput.get(testOutput.size() - 2).toCharArray());
		assertArrayEquals(">> ".toCharArray(),
				testOutput.get(testOutput.size() - 1).toCharArray());
	}

	@Test
	public void testLose() throws FileNotFoundException {
		clearCommands();
		addCommand("new game");
		addCommand("go north");
		addCommand("go north");
		addCommand("throw lint at merchant");
		addCommand("quit");
		addCommand("yes");
		System.setIn(in);
		Game.main(null);

		// Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();

		assertArrayEquals(
				"_____.___.              .____                        "
						.toCharArray(),
				testOutput.get(testOutput.size() - 18).toCharArray());
		assertArrayEquals(
				"\\__  |   | ____  __ __  |    |    ____  ______ ____  "
						.toCharArray(),
				testOutput.get(testOutput.size() - 17).toCharArray());
		assertArrayEquals(
				" /   |   |/  _ \\|  |  \\ |    |   /  _ \\/  ___// __ \\ "
						.toCharArray(),
				testOutput.get(testOutput.size() - 16).toCharArray());
		assertArrayEquals(
				" \\____   (  <_> )  |  / |    |__(  <_> )___ \\\\  ___/ "
						.toCharArray(),
				testOutput.get(testOutput.size() - 15).toCharArray());
		assertArrayEquals(
				" / ______|\\____/|____/  |_______ \\____/____  >\\___  >"
						.toCharArray(),
				testOutput.get(testOutput.size() - 14).toCharArray());
		assertArrayEquals(
				" \\/                             \\/         \\/     \\/ "
						.toCharArray(),
				testOutput.get(testOutput.size() - 13).toCharArray());
		assertArrayEquals("".toCharArray(),
				testOutput.get(testOutput.size() - 12).toCharArray());
		assertArrayEquals(
				"     ____.     ___.  ___.                                      __           "
						.toCharArray(),
				testOutput.get(testOutput.size() - 11).toCharArray());
		assertArrayEquals(
				"    |    |____ \\_ |__\\_ |__   _____________  _  ______   ____ |  | _____.__."
						.toCharArray(), testOutput.get(testOutput.size() - 10)
						.toCharArray());
		assertArrayEquals(
				"    |    \\__  \\ | __ \\| __ \\_/ __ \\_  __ \\ \\/ \\/ /  _ \\_/ ___\\|  |/ <   |  |"
						.toCharArray(), testOutput.get(testOutput.size() - 9)
						.toCharArray());
		assertArrayEquals(
				"/\\__|    |/ __ \\| \\_\\ \\ \\_\\ \\  ___/|  | \\/\\     (  <_> )  \\___|    < \\___  |"
						.toCharArray(), testOutput.get(testOutput.size() - 8)
						.toCharArray());
		assertArrayEquals(
				"\\________(____  /___  /___  /\\___  >__|    \\/\\_/ \\____/ \\___  >__|_ \\/ ____|"
						.toCharArray(), testOutput.get(testOutput.size() - 7)
						.toCharArray());
		assertArrayEquals(
				"              \\/    \\/    \\/     \\/                         \\/     \\/\\/     "
						.toCharArray(), testOutput.get(testOutput.size() - 6)
						.toCharArray());
		assertArrayEquals("Type:".toCharArray(),
				testOutput.get(testOutput.size() - 5).toCharArray());
		assertArrayEquals("\"new game\" to start new game".toCharArray(),
				testOutput.get(testOutput.size() - 4).toCharArray());
		assertArrayEquals("\"quit\" to quit".toCharArray(),
				testOutput.get(testOutput.size() - 3).toCharArray());
		assertArrayEquals(
				">> Are you sure you want to quit? (y/n)".toCharArray(),
				testOutput.get(testOutput.size() - 2).toCharArray());
		assertArrayEquals(">> ".toCharArray(),
				testOutput.get(testOutput.size() - 1).toCharArray());
	}

	private void clearCommands() {
		in = new ByteArrayInputStream("".getBytes());
	}

	private void addCommand(String command) {
		command += "\n";
		in = new SequenceInputStream(in, new ByteArrayInputStream(
				command.getBytes()));
	}

}

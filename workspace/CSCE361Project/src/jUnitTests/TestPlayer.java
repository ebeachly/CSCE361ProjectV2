package jUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import superClasses.Game;
import superClasses.Item;
import superClasses.Location;
import superClasses.Parser;
import superClasses.Player;

public class TestPlayer {

	final static PrintStream stdout = System.out;
	final static InputStream stdin = System.in;
	private static PrintStream out = null;
	private static Player player;
	private static Item item;
	private static Item item2;
	private static Location location;

	@Before
	public void setUp() throws FileNotFoundException {
		Game.player = new Player();
		Game.parser = new Parser();

		class TestItem extends Item {
			TestItem() {
				this.name = "testName";
			}
		}
		class TestItem2 extends Item {
			TestItem2() {
				this.name = "testName2";
			}
		}

		item = new TestItem();
		item2 = new TestItem2();

		class TestLocation extends Location {
			TestLocation() {
				this.droppedItems.add(item);
			}
		}

		location = new TestLocation();

		Game.player.currentLocation = location;

		player = Game.player;
		
		out = new PrintStream("testing.txt");
		System.setOut(out);
	}

	@Test
	public void testPickUp() throws FileNotFoundException {
		assertTrue(player.pickUp(null));
		assertTrue(player.pickUp(""));
		player.pickUp("testName");

		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();

		assertArrayEquals("You pick up a testName.".toCharArray(), testOutput
				.get(testOutput.size() - 1).toCharArray());
	}
	
	@Test
	public void testViewInventory() throws FileNotFoundException {
		player.viewInventory();
		
		player.inventory.add(item);

		player.viewInventory();
		
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();

		assertArrayEquals("Your inventory contains nothing.".toCharArray(), testOutput
				.get(0).toCharArray());
		
		assertArrayEquals("   testName".toCharArray(), testOutput
				.get(testOutput.size() - 1).toCharArray());
	}
	
	@Test
	public void testItemInInventory() throws FileNotFoundException {
		assertFalse(player.itemInInventory(item));
		player.inventory.add(item);
		assertTrue(player.itemInInventory(item));
		assertFalse(player.itemInInventory(item2));
		
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		sc.close();
		
		assertArrayEquals("You don't have a testName in your inventory.".toCharArray(), testOutput
				.get(0).toCharArray());
		assertArrayEquals("You don't have a testName2 in your inventory.".toCharArray(), testOutput
				.get(1).toCharArray());
	}
	
	@Test
	public void testDropItem() {
		assertFalse(player.dropItem(item));
		player.inventory.add(item);
		assertTrue(player.dropItem(item));
	}

}

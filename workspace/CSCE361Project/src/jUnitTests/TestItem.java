package jUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import assets.Merchant;
import assets.Wizard;
import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;
import superClasses.Location;
import superClasses.Player;

public class TestItem {

	final static PrintStream stdout = System.out;
	private static PrintStream out = null;
	HashMap<Integer, String> output;

	@Before
	public void setUp() throws Exception {
		//Setup testing utilities
		out = new PrintStream("testing.txt");
		System.setOut(out);
		output = new HashMap<Integer, String>();
	}

	@Test
	public void testInteract() throws FileNotFoundException  {
		//Setup the player
		Game.player = new Player();
		
		//Make a location to put the player
		class TestLoc extends Location {
		}
		
		TestLoc testLoc = new TestLoc();
		Game.player.currentLocation = testLoc;
		
		//Since Item is abstract, create an anonymous class that extends it.
		class TestIte extends Item {
			TestIte(){
				this.name = "testName";
			}
		}
		
		TestIte testIte = new TestIte();
		Game.player.inventory.add(testIte);
		
		//Make some targets
		class SoftTarget extends Aspect {
			SoftTarget(){
				this.name = "soft target";
			}
			public boolean damage(Item weapon){
				return true;
			}
		}
		SoftTarget softTarget = new SoftTarget();
		
		class HardTarget extends Aspect {
			HardTarget(){
				this.name = "hard target";
			}
		}
		HardTarget hardTarget = new HardTarget();
		
		//Perform operations
		//Since this is a white box test, just call interact(). Don't run main.
		
		//gibberish
		assertFalse(testIte.interact("gobbldeygook", null));
		
		//eat it
		assertTrue(testIte.interact("eat", null));
		
		//drop it, but don't pick it back up
		assertTrue(testIte.interact("drop", null));
		assertEquals(1, testLoc.droppedItems.size());
		assertEquals(0, Game.player.inventory.size());
		
		//drop something you don't have. Pick it up
		assertFalse(testIte.interact("drop", null));
		assertEquals(1, testLoc.droppedItems.size());
		assertEquals(0, Game.player.inventory.size());
		testLoc.droppedItems.clear();
		Game.player.inventory.add(testIte);
		
		//toss it, but don't pick it back up
		assertTrue(testIte.interact("toss", null));
		assertEquals(1, testLoc.droppedItems.size());
		assertEquals(0, Game.player.inventory.size());
		
		//toss it when you don't have it. Pick it up
		assertFalse(testIte.interact("toss", null));
		assertEquals(1, testLoc.droppedItems.size());
		assertEquals(0, Game.player.inventory.size());
		testLoc.droppedItems.clear();
		Game.player.inventory.add(testIte);
		
		//toss it at something damageable
		assertTrue(testIte.interact("toss", softTarget));
		assertEquals(1, testLoc.droppedItems.size());
		assertEquals(0, Game.player.inventory.size());
		testLoc.droppedItems.clear();
		Game.player.inventory.add(testIte);
		
		//toss it at something not damageable
		assertTrue(testIte.interact("toss", hardTarget));
		assertEquals(1, testLoc.droppedItems.size());
		assertEquals(0, Game.player.inventory.size());
		testLoc.droppedItems.clear();
		Game.player.inventory.add(testIte);
		
		//attack with it (just calls toss)
		assertTrue(testIte.interact("attack", null));
		assertEquals(1, testLoc.droppedItems.size());
		assertEquals(0, Game.player.inventory.size());
		testLoc.droppedItems.clear();
		Game.player.inventory.add(testIte);
		
		//test giving the item.
		//Create a simple wizard and merchant
		class TestWizard extends Wizard {
			public boolean given;
			TestWizard(){
				this.name = "testWizard";
				this.given = false;
			}
			public boolean give(Interactable target) {
				this.given = true;
				return true;
			}
		}
		class TestMerchant extends Merchant {
			public boolean given;
			TestMerchant(){
				this.name = "testMerchant";
				this.given = false;
			}
			public boolean give(Interactable target) {
				this.given = true;
				return true;
			}
		}
		TestMerchant merchant = new TestMerchant();
		TestWizard wizard = new TestWizard();
		
		//Give the item to the merchant
		assertTrue(testIte.interact("give", merchant));
		assertTrue(merchant.given);
		//Give the item to the wizard
		assertTrue(testIte.interact("give", wizard));
		assertTrue(wizard.given);
		//Give the item to null
		assertFalse(testIte.interact("give", null));
		//Give the item to something that isn't a wizard or a merchant, but not null
		assertFalse(testIte.interact("give", hardTarget));

		//Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		
		//Compare output to expected output
		assertArrayEquals( "That's a dumb idea.".toCharArray() , testOutput.get(0).toCharArray() );
		assertArrayEquals( "You drop your testName on the ground.".toCharArray() , testOutput.get(1).toCharArray() );
		assertArrayEquals( "You throw your testName away, and it lands on the ground.".toCharArray() , testOutput.get(2).toCharArray() );
		assertArrayEquals( "You throw your testName at the soft target.".toCharArray() , testOutput.get(3).toCharArray() );
		assertArrayEquals( "You throw your testName at the hard target.".toCharArray() , testOutput.get(4).toCharArray() );
		assertArrayEquals( "The testName bounces off and falls on the ground.".toCharArray() , testOutput.get(5).toCharArray() );
		assertArrayEquals( "You throw your testName away, and it lands on the ground.".toCharArray() , testOutput.get(6).toCharArray() );
		
		//Close scanner
		sc.close();
	}
	
	@Test
	public void testPublicMethods() throws FileNotFoundException {
		
		//Since Item is abstract, create an anonymous class that extends it.
		class TestIte extends Item {
			TestIte(){
				this.name = "testName";
			}
		}
		
		TestIte testIte = new TestIte();
		
		//Perform operations
		testIte.interact("examine", null);
		testIte.makeVorpal();
		testIte.interact("examine", null);
		
		//Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		
		//Compare output to expected output
		assertArrayEquals( "There's nothing special about it.".toCharArray() , testOutput.get(0).toCharArray() );
		assertArrayEquals( "The edges of it seem exceedingly sharp.".toCharArray() , testOutput.get(1).toCharArray() );
		
		//Close scanner
		sc.close();
	}

}

package jUnitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import superClasses.Aspect;
import superClasses.Game;
import superClasses.Interactable;
import superClasses.Item;
import superClasses.Location;
import superClasses.Parser;
import superClasses.Player;
import superClasses.World;

public class TestParser {
	
	Parser parser;

	final static PrintStream stdout = System.out;
	private static PrintStream out = null;

	
	@Before
	public void setUp() throws Exception {
		//Setup testing utilities
		out = new PrintStream("testing.txt");
		System.setOut(out);
		parser = new Parser();
	}

	@Test
	public void testParseInput() {
		//Test sanitization
		assertTrue(parser.parseInput("      134123   GI!@#$%^&**()34VE 43 852789 MERC_+-=+-*//H342.//ANT q8-4385n          .          .        24nn CO2INS       .      ..  "));
		assertArrayEquals("give".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("merchant".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("coins".toCharArray(), parser.target.toCharArray() );
		
		//no preposition
		assertTrue(parser.parseInput("give merchant coins"));
		assertArrayEquals("give".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("merchant".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("coins".toCharArray(), parser.target.toCharArray() );
		
		//test with
		assertTrue(parser.parseInput("attack goblin with sword"));
		assertArrayEquals("attack".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		//test use
		assertTrue(parser.parseInput("use sword to attack goblin"));
		assertArrayEquals("attack".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		//test at
		assertTrue(parser.parseInput("throw sword at goblin"));
		assertArrayEquals("toss".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		//test in
		assertTrue(parser.parseInput("put pocket lint in ears"));
		assertArrayEquals("put".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("pocket lint".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("ears".toCharArray(), parser.target.toCharArray() );
		
		//test to
		assertTrue(parser.parseInput("give coins to merchant"));
		assertArrayEquals("give".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("coins".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("merchant".toCharArray(), parser.target.toCharArray() );
		
		//test the algorithm's ability to transition from searching for target to searching for object
		assertTrue(parser.parseInput("swing at goblin with sword"));
		assertArrayEquals("attack".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		//Test a command with the action after the object
		assertTrue(parser.parseInput("with shield, block"));
		assertArrayEquals("raise".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("shield".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("".toCharArray(), parser.target.toCharArray() );
		
		//no prepositions. lots of adjectives
		assertTrue(parser.parseInput("quickly and speedily give the gray old merchant my valuable shiny coins"));
		assertArrayEquals("give".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("merchant".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("coins".toCharArray(), parser.target.toCharArray() );
		
		//can't find action
		assertFalse(parser.parseInput("la kdsfl ka lkds;l k gga"));
		
		//can't find object
		assertTrue(parser.parseInput("quit aldksf ask alst ackl"));
		assertArrayEquals("quit".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("".toCharArray(), parser.target.toCharArray() );
		
		//Test a command where the parts of speech are multiple words
		assertTrue(parser.parseInput("hide behind dull rock red rock"));
		assertArrayEquals("raise".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("dull rock".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("red rock".toCharArray(), parser.target.toCharArray() );
	}

	@Test
	public void testFindInteractable() {
		//Initialize environment
		Game.player = new Player();
		
		//Create some anonymous classes for testing
		class TestLoc extends Location {
		}
		
		class TestIte extends Item {
			TestIte(String name){
				this.name = name;
			}
		}
		
		class TestAsp extends Aspect {
			TestAsp(String name){
				this.name = name;
			}
		}
		
		TestLoc testLoc = new TestLoc();
		
		TestIte ite1 = new TestIte("test 1");
		TestIte ite2 = new TestIte("test 1");
		TestIte ite4 = new TestIte("test 4");
		
		TestAsp asp1 = new TestAsp("test 2");
		TestAsp asp2 = new TestAsp("test 2");
		TestAsp asp3 = new TestAsp("test 3");
		TestAsp asp4 = new TestAsp("test 3");
		
		Game.player.currentLocation = testLoc;
		Game.player.inventory.add(ite1);
		Game.player.inventory.add(ite2);
		Game.player.inventory.add(ite4);
		testLoc.aspects.add(asp1);
		testLoc.aspects.add(asp2);
		World.globalAspects = new ArrayList<Interactable>();
		World.globalAspects.add(asp3);
		World.globalAspects.add(asp4);
		
		//Test bad inputs
		assertSame( null, parser.findInteractable(null) );
		assertSame( null, parser.findInteractable("") );
		assertSame( null, parser.findInteractable(" ") );
		
		//Test direct match in inventory
		assertSame( ite1, parser.findInteractable("test 1"));
		//Test direct match in location's aspects
		assertSame( asp1, parser.findInteractable("test 2"));
		//Test direct match in global aspects
		assertSame( asp3, parser.findInteractable("test 3"));
		
		//Test no match
		assertSame( null, parser.findInteractable("wild goose"));
		//Test single potential match
		assertSame( ite1, parser.findInteractable("1"));
		//Test ambiguous match
		assertSame( null, parser.findInteractable("test"));
		
	}
	
	@Test
	public void testfindItemOnGround() {
		//Initialize environment
		Game.player = new Player();
		
		//Create some anonymous classes for testing
		class TestLoc extends Location {
		}
		
		class TestIte extends Item {
			TestIte(String name){
				this.name = name;
			}
		}
		
		TestLoc testLoc = new TestLoc();
		
		TestIte ite1 = new TestIte("test 1");
		TestIte ite2 = new TestIte("test 1");
		TestIte ite3 = new TestIte("test 2");
		TestIte ite4 = new TestIte("test 2");
		
		Game.player.currentLocation = testLoc;
		testLoc.droppedItems.add(ite1);
		testLoc.droppedItems.add(ite2);
		testLoc.droppedItems.add(ite3);
		testLoc.droppedItems.add(ite4);
		
		//Test bad inputs
		assertSame( null, parser.findItemOnGround(null) );
		assertSame( null, parser.findItemOnGround("") );
		assertSame( null, parser.findItemOnGround(" ") );
		
		//Test direct match on ground
		assertSame( ite1, parser.findItemOnGround("test 1"));
		
		//Test no match
		assertSame( null, parser.findItemOnGround("wild goose"));
		//Test single potential match
		assertSame( ite1, parser.findItemOnGround("1"));
		//Test ambiguous match
		assertSame( null, parser.findItemOnGround("test"));
	}
	
	@Test
	public void testExecuteCommand() throws FileNotFoundException {
		//Initialize environment
		class TestLoc extends Location {
			public boolean printedDescription;
			public boolean printedItemsOnGround;
			TestLoc(){
				printedDescription = false;
				printedItemsOnGround = false;
			}
			public void printDescription(){
				this.printedDescription = true;
				return;
			}
			public void printItemsOnGround(){
				this.printedItemsOnGround = true;
				return;
			}
		}
		class TestPlayer extends Player {
			public boolean viewedInventory;
			public String pickedUp;
			TestPlayer(){
				inventory = new LinkedList<Item>();
				viewedInventory = false;
				pickedUp = null;
			}
			public void viewInventory(){
				this.viewedInventory = true;
				return;
			}
			public boolean pickUp(String name) {
				pickedUp = name;
				return true;
			}
		}
		class TestIte extends Item {
			TestIte(){
				this.name = "item";
			}
			public boolean interact( String action, Interactable target ){
				if( action.equals("true") ){
					return true;
				}
				return false;
			}
			
		}
		TestLoc testLoc = new TestLoc();
		TestPlayer testPlayer = new TestPlayer();
		TestIte item = new TestIte();
		Game.player = testPlayer;
		Game.player.currentLocation = testLoc;
		Game.player.inventory.add(item);
		World.globalAspects = new ArrayList<Interactable>();
		
		//Set up the input stream for testing quit.
		InputStream in = new ByteArrayInputStream("yes\n".getBytes());
		Game.in = new Scanner(in);

		//Test quit
		parser.action = "quit";
		parser.object = "";
		parser.target = "";
		assertTrue(parser.executeCommand());
		assertTrue(Game.quit);
		//Refresh the output file
		out = new PrintStream("testing.txt");
		System.setOut(out);
		
		//Test help
		parser.action = "help";
		parser.object = "";
		parser.target = "";
		assertFalse(parser.executeCommand());
		
		//Test examine inventory
		parser.action = "examine";
		parser.object = "inventory";
		parser.target = "";
		assertTrue(parser.executeCommand());
		assertTrue(testPlayer.viewedInventory);
		
		//Test examine location
		parser.action = "examine";
		parser.object = "location";
		parser.target = "";
		assertTrue(parser.executeCommand());
		assertTrue(testLoc.printedDescription);
		
		//Test examine ground
		parser.action = "examine";
		parser.object = "ground";
		parser.target = "";
		assertTrue(parser.executeCommand());
		assertTrue(testLoc.printedItemsOnGround);
		
		//Test pick up
		parser.action = "pick up";
		parser.object = "rock";
		parser.target = "";
		assertTrue(parser.executeCommand());
		assertArrayEquals("rock".toCharArray(), testPlayer.pickedUp.toCharArray());
		
		//Test wait
		parser.action = "wait";
		parser.object = "";
		parser.target = "";
		assertTrue(parser.executeCommand());
		
		//Test empty object
		parser.action = "google";
		parser.object = "";
		parser.target = "";
		assertFalse(parser.executeCommand());
		
		//Test unfindable object
		parser.action = "google";
		parser.object = "wild goose";
		parser.target = "";
		assertTrue(parser.executeCommand());
		
		//Test findable object, proper use
		parser.action = "true";
		parser.object = "item";
		parser.target = "";
		assertTrue(parser.executeCommand());
		
		//Test findable object, improper use
		parser.action = "false";
		parser.object = "item";
		parser.target = "";
		assertFalse(parser.executeCommand());
		
		//Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		
		//Compare output to expected output
		assertArrayEquals( "Try typing common actions such as:".toCharArray() , testOutput.get(0).toCharArray() );
		assertArrayEquals( "\tgo north".toCharArray() , testOutput.get(1).toCharArray() );
		assertArrayEquals( "\texamine area".toCharArray() , testOutput.get(2).toCharArray() );
		assertArrayEquals( "\tpick up pamphlet".toCharArray() , testOutput.get(3).toCharArray() );
		assertArrayEquals( "Some time goes by.".toCharArray() , testOutput.get(4).toCharArray() );
		assertArrayEquals( "SYSTEM: could not identify a direct object in your input.".toCharArray() , testOutput.get(5).toCharArray() );
		assertArrayEquals( "You can't find a wild goose.".toCharArray() , testOutput.get(6).toCharArray() );
		assertArrayEquals( "SYSTEM: That is not a valid use of that object.".toCharArray() , testOutput.get(7).toCharArray() );
		
		//Close scanner
		sc.close();
	}
	
	@Test
	public void testParseMenuOption() {
		InputStream in = new ByteArrayInputStream("yes\nyes\n".getBytes());
		Game.in = new Scanner(in);
		assertFalse(Parser.parseMenuOption("Gobbledygook"));
		assertTrue(Parser.parseMenuOption("New Game"));
		assertTrue(Parser.parseMenuOption("New"));
		assertTrue(Parser.parseMenuOption("N"));
		Game.quit = false;
		assertFalse(Parser.parseMenuOption("Quit"));
		assertTrue(Game.quit);
		Game.quit = false;
		assertFalse(Parser.parseMenuOption("Q"));
		assertTrue(Game.quit);
		return;
	}

}

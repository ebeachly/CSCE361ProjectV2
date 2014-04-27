package jUnitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import superClasses.Game;
import superClasses.Parser;

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
	}

	@Test
	public void testFindInteractable() {
		
	}
	
	@Test
	public void testfindItemOnGround() {
		
	}
	
	@Test
	public void testExecuteCommand() {
		
	}
	
	@Test
	public void testParseMenuOption() {
		InputStream in = null;
		in = new ByteArrayInputStream("yes\nyes\n".getBytes());
		System.setIn(in);
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
		System.setIn(System.in);
		return;
	}

}

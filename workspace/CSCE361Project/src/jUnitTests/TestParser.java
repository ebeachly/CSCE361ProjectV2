package jUnitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import superClasses.Game;
import superClasses.Parser;

public class TestParser {
	
	Parser parser;

	final static PrintStream stdout = System.out;
	private static PrintStream out = null;
	HashMap<Integer, String> output;

	private static InputStream in = null;
	
	@Before
	public void setUp() throws Exception {
		//Setup testing utilities
		out = new PrintStream("testing.txt");
		System.setOut(out);
		output = new HashMap<Integer, String>();
		parser = new Parser();
	}

	@Test
	public void testParseInput() {
		assertTrue(parser.parseInput("quickly attack the slimey nasty goblin with my sharp metal sword"));
		assertArrayEquals("attack".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		assertTrue(parser.parseInput("with sharp metal sword quickly attack the slimey nasty goblin"));
		assertArrayEquals("attack".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		assertTrue(parser.parseInput("use sharp metal sword to quickly attack the slimey nasty goblin"));
		assertArrayEquals("attack".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		assertTrue(parser.parseInput("throw sharp metal sword at the slimey nasty goblin"));
		assertArrayEquals("toss".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		assertTrue(parser.parseInput("at the slimey nasty goblin throw with sharp metal sword"));
		assertArrayEquals("toss".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		assertTrue(parser.parseInput("at the slimey nasty goblin to throw with sharp metal sword"));
		assertArrayEquals("toss".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("sword".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("goblin".toCharArray(), parser.target.toCharArray() );
		
		assertFalse(parser.parseInput("kasd;fljl   ;ajdlkjf l;jal;k jdf;lkjas doi faid lkaksdj fadjijaisd jfkakj iefajksldjfhayy alks"));
		assertArrayEquals("".toCharArray(), parser.action.toCharArray() );
		assertArrayEquals("".toCharArray(), parser.object.toCharArray() );
		assertArrayEquals("".toCharArray(), parser.target.toCharArray() );
		
	}

	@Test
	public void testParseMenuOption() {
		in = new ByteArrayInputStream("yes\n".getBytes());
		System.setIn(in);
		assertFalse(Parser.parseMenuOption("gobbledygook"));
		assertFalse(Parser.parseMenuOption("quit"));
		assertTrue(Game.quit);
		assertTrue(Parser.parseMenuOption("new game"));
	}

}

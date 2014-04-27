package jUnitTests;

import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import superClasses.Game;
import superClasses.Player;
import superClasses.World;

public class TestWorld {

	final static PrintStream stdout = System.out;
	final static InputStream stdin = System.in;
	private static PrintStream out = null;

	@Before
	public void setUp() throws Exception {
		// Setup testing utilities
		out = new PrintStream("testing.txt");
		System.setOut(out);
	}

	@Test
	public void test() {
		World w = new World();
		assertNotNull(w);
		Game.player = new Player();
		World.constructTestWorld();
		World.constructWorld();
	}

}

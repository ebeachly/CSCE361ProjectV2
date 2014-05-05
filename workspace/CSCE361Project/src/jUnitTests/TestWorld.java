package jUnitTests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		Game.player = new Player();
	}

	@Test
	public void test() {	
		World w = new World();
		
		assertNotNull(w);
		
		assertNull(World.bridge);
		assertNull(World.canyon);
		assertNull(World.cave);
		assertNull(World.cField);
		assertNull(World.ears);
		assertNull(World.eForest);
		assertNull(World.eForestBuffer);
		assertNull(World.globalAspects);
		assertNull(World.house);
		assertNull(World.jabberwockyLair);
		assertNull(World.jubjubLair);
		assertNull(World.neForest);
		assertNull(World.neForestBuffer);
		assertNull(World.nField);
		assertNull(World.nwField);
		assertNull(World.seForest);
		assertNull(World.seForestBuffer);
		assertNull(World.sField);
		assertNull(World.swField);
		assertNull(World.wField);
		
		World.constructWorld();
		
		assertNotNull(World.bridge);
		assertNotNull(World.canyon);
		assertNotNull(World.cave);
		assertNotNull(World.cField);
		assertNotNull(World.ears);
		assertNotNull(World.eForest);
		assertNotNull(World.eForestBuffer);
		assertNotNull(World.globalAspects);
		assertNotNull(World.house);
		assertNotNull(World.jabberwockyLair);
		assertNotNull(World.jubjubLair);
		assertNotNull(World.neForest);
		assertNotNull(World.neForestBuffer);
		assertNotNull(World.nField);
		assertNotNull(World.nwField);
		assertNotNull(World.seForest);
		assertNotNull(World.seForestBuffer);
		assertNotNull(World.sField);
		assertNotNull(World.swField);
		assertNotNull(World.wField);
		
		
		assertNull(World.prisonCell);
		assertNull(World.prisonHallway);
		
		World.constructTestWorld();
		
		assertNotNull(World.prisonCell);
		assertNotNull(World.prisonHallway);
	}

}

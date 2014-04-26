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

import superClasses.Aspect;

public class TestAspect {

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
	public void testInteract() throws FileNotFoundException {
		
		//Since Aspect is abstract, create an anonymous class that extends it.
		class TestAsp extends Aspect {
			TestAsp(){
				this.name = "testName";
			}
		}
		
		TestAsp testAsp = new TestAsp();
		
		//Perform operations
		//Since this is a white box test, just call interact(). Don't run main.
		assertFalse(testAsp.interact("gobbldeygook", null));
		assertTrue(testAsp.interact("examine", null));
		assertFalse(testAsp.interact("attack", null));

		//Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		
		//Compare output to expected output
		assertArrayEquals( "There's nothing special about it.".toCharArray() , testOutput.get(0).toCharArray() );
		assertArrayEquals( "SYSTEM: You need to specify what you are using to attack, ie: attack goblin with sword.".toCharArray() , testOutput.get(1).toCharArray() );
		
		//Close scanner
		sc.close();
	}
	
	@Test
	public void testPublicMethods(){
		
		//Since Interactable is abstract, create an anonymous class that extends it.
		class TestAsp extends Aspect {
			TestAsp(){
				this.name = "testName";
			}
		}
		
		TestAsp testAsp = new TestAsp();
		
		//Perform operations
		testAsp.takeTurn();
		

	}


}

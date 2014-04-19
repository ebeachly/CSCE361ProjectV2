package jUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import superClasses.Interactable;

public class testInteractable {
	
	final static PrintStream stdout = System.out;
	private static PrintStream out = null;
	HashMap<Integer, String> output;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Setup testing utilities
		out = new PrintStream("testing.txt");
		System.setOut(out);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		output = new HashMap<Integer, String>();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInteract() throws FileNotFoundException  {
		
		//Since Interactable is abstract, create an anonymous class that extends it.
		class TestObject extends Interactable {
			TestObject(){
				this.name = "testName";
			}
		}
		
		TestObject testObject = new TestObject();
		
		//Perform operations
		//Since this is a white box test, just call interact(). Don't run main.
		assertFalse(testObject.interact("gobbldeygook", null));
		assertTrue(testObject.interact("examine", null));

		//Read in the file of what was printed out
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		
		//Compare output to expected output
		assertArrayEquals( "There's nothing special about it.".toCharArray() , testOutput.get(0).toCharArray() );
		
		//Close scanner
		sc.close();
	}
	
	@Test
	public void testPublicMethods(){
		
		//Since Interactable is abstract, create an anonymous class that extends it.
		class TestObject extends Interactable {
			TestObject(){
				this.name = "testName";
			}
		}
		
		TestObject testObject = new TestObject();
		
		//Perform operations
		assertFalse(testObject.damage(null));
		assertArrayEquals( "testName".toCharArray() , testObject.toString().toCharArray());

	}

}

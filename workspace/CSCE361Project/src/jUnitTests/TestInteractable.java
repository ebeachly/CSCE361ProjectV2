package jUnitTests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import superClasses.Interactable;

// Tests Interactable
public class TestInteractable {
	
	final static PrintStream stdout = System.out;
	private static PrintStream out = null;

	@Before
	public void setUp() throws Exception {
		//Setup testing utilities
		out = new PrintStream("testing.txt");
		System.setOut(out);
	}

	@Test
	public void testInteract() throws FileNotFoundException  {
		
		//Since Interactable is abstract, create an anonymous class that extends it.
		class TestInt extends Interactable {
			TestInt(){
				this.name = "testName";
			}
		}
		
		TestInt testInt = new TestInt();
		
		//Perform operations
		//Since this is a white box test, just call interact(). Don't run main.
		assertFalse(testInt.interact("gobbldeygook", null));
		assertTrue(testInt.interact("examine", null));

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
		class TestInt extends Interactable {
			TestInt(){
				this.name = "testName";
			}
		}
		
		TestInt testInt = new TestInt();
		
		//Perform operations
		assertFalse(testInt.damage(null));
		assertArrayEquals( "testName".toCharArray() , testInt.toString().toCharArray());

	}

}

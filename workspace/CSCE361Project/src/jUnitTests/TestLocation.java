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

import superClasses.Item;
import superClasses.Location;

public class TestLocation {
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
	public void testPublicMethods() throws FileNotFoundException {
		//Since Location is abstract, create an anonymous class that extends it.
		class TestLoc extends Location {
		}
		
		TestLoc testLoc = new TestLoc();
		
		//These don't do anything
		testLoc.construct();
		testLoc.printDescription();
		
		//Test printItemsOnGround
		class TestItem extends Item{
			TestItem(String name){
				this.name = name;
			}
		}
		
		TestItem item1 = new TestItem("item1");
		TestItem item2 = new TestItem("item2");
		
		testLoc.printItemsOnGround();
		testLoc.droppedItems.add(item1);
		testLoc.printItemsOnGround();
		testLoc.droppedItems.add(item2);
		testLoc.printItemsOnGround();
		
		//Read in the file of stuff that was output
		Scanner sc = new Scanner(new File("testing.txt"));
		ArrayList<String> testOutput = new ArrayList<String>();
		while (sc.hasNextLine()) {
			testOutput.add(sc.nextLine());
		}
		
		//Compare output to expected output
		assertArrayEquals( "On the ground there is a: item1.".toCharArray() , testOutput.get(0).toCharArray() );
		assertArrayEquals( "On the ground there are:".toCharArray() , testOutput.get(1).toCharArray() );
		assertArrayEquals( "   item1".toCharArray() , testOutput.get(2).toCharArray() );
		assertArrayEquals( "   item2".toCharArray() , testOutput.get(3).toCharArray() );
		
		//Close scanner
		sc.close();
	}

}

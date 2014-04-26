package jUnitTests;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;

import org.junit.Test;

import superClasses.Game;

public class TestGame {

	final static PrintStream stdout = System.out;
	private String commands = null;
	private static InputStream in = null;
	private static PrintStream out = null;
	HashMap<Integer, String> output;
	
	@Test
	public void testMain() {
		clearCommands();
		Game.main(null);
		fail("Not yet implemented");
	}
	
	private void clearCommands(){
		commands = "";
		in = null;
	}
	
	private void addCommand(String command){
		
	}

}

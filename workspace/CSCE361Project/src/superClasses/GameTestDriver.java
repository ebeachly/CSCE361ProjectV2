package superClasses;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class GameTestDriver {

	public static void main(String[] args) throws IOException {
		InputStream in = new ByteArrayInputStream(("new\n" +
				"pick up key\n" +
				"wait\n" +
				"unlock door with key\n" +
				"go through door\n" +
				"quit\n" +
				"yes").getBytes());
		System.setIn(in);
		PrintStream out = new PrintStream("testing.txt");
		PrintStream stdout = System.out;
		System.setOut(out);
		try{
			Game.main(null);
		} catch (NoSuchElementException nsee) {
			
		}
		System.setOut(stdout);
		System.out.println();
	}

}

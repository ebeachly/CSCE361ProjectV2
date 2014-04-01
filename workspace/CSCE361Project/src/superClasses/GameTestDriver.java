package superClasses;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class GameTestDriver {

	public static void main(String[] args) throws IOException {
		InputStream in = new ByteArrayInputStream(("new\n" +
				"pick up key\n" +
				"wait\n" +
				"unlock door with key\n" +
				"quit\n" +
				"no\n" +
				"go through door\n" +
				"new\n" +
				"quit\n" +
				"no\n" +
				"quit\n" +
				"yes").getBytes());
		System.setIn(in);
		PrintStream out = new PrintStream("testing.txt");
		PrintStream stdout = System.out;
		System.setOut(out);
		try{
			Game.main(null);
		} catch (Exception e) {
			System.setOut(stdout);
		}
		System.setOut(stdout);
		System.out.println();
	}

}

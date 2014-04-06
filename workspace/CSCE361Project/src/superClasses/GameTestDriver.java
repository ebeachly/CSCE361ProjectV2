package superClasses;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Scanner;

public class GameTestDriver {

	final static PrintStream stdout = System.out;
	private static InputStream in = null;
	private static PrintStream out = null;

	public static void main(String[] args) throws IOException {
		System.setSecurityManager(new NoExitSecurityManager());

		test1();

	}

	private static void test1() throws FileNotFoundException {
		String test1 = "new\n" + "pick up key\n" + "wait\n"
				+ "unlock door with key\n" + "quit\n" + "y\n";
		try {
			in = new ByteArrayInputStream(test1.getBytes());
			System.setIn(in);
			out = new PrintStream("testing.txt");
			System.setOut(out);
			Game.main(null);
		} catch (ExitException se) {

		} catch (Exception e) {
			System.setOut(stdout);
			System.out.println("Error: ");
			e.printStackTrace();
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			if (testOutput.get(testOutput.size() - 2).equals(
					">> Are you sure you want to quit? (y/n)")) {
				System.out.println("test1 passed");
			} else {
				System.out.println("test1 failed");
			}
		}
	}

	protected static class ExitException extends SecurityException {

		private static final long serialVersionUID = -6885909113823889720L;
		public final int status;

		public ExitException(int status) {
			super("There is no escape!");
			this.status = status;
		}
	}

	private static class NoExitSecurityManager extends SecurityManager {
		@Override
		public void checkPermission(Permission perm) {
			// allow anything.
		}

		@Override
		public void checkPermission(Permission perm, Object context) {
			// allow anything.
		}

		@Override
		public void checkExit(int status) {
			super.checkExit(status);
			throw new ExitException(status);
		}
	}

}

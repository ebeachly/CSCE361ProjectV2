package superClasses;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameTestDriver {

	final static PrintStream stdout = System.out;
	private static InputStream in = null;
	private static PrintStream out = null;

	public static void main(String[] args) throws IOException {
		System.setSecurityManager(new NoExitSecurityManager());

		test1();
		// test2();
		// test3();
		test4();
		// test5();
		// test6();
		// test7();
		// test8();
		// test9();

	}

	private static void test1() throws FileNotFoundException {

		String input = "new\n" + "pick up key\n" + "wait\n"
				+ "unlock door with key\n" + "quit\n" + "y\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();

		boolean passed = true;
		try {
			in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			out = new PrintStream("testing.txt");
			System.setOut(out);
			Game.main(null);
		} catch (ExitException se) {

		} catch (Exception e) {
			System.setOut(stdout);
			System.out.println("Error: ");
			e.printStackTrace();
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}

			output.put(testOutput.size() - 2,
					">> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test1 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test1 passed");
				}
			} else {
				System.out.println("test1 failed: error");
			}
		}
	}

	private static void test4() throws FileNotFoundException {

		String input = "new\n" + "pick up rock\n" + "quit\n" + "yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();

		boolean passed = true;
		try {
			in = new ByteArrayInputStream(input.getBytes());
			System.setIn(in);
			out = new PrintStream("testing.txt");
			System.setOut(out);
			Game.main(null);
		} catch (ExitException se) {

		} catch (Exception e) {
			System.setOut(stdout);
			System.out.println("Error: ");
			e.printStackTrace();
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}

			output.put(testOutput.size() - 4,
					">> You can't find a rock on the ground.");			

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test4 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test4 passed");
				}
			} else {
				System.out.println("test4 failed: error");
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

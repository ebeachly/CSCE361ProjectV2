package blackboxTests;

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

import superClasses.Game;

public class GameTestDriver {

	final static PrintStream stdout = System.out;
	private static InputStream in = null;
	private static PrintStream out = null;

	public static void main(String[] args) throws IOException {
		System.setSecurityManager(new NoExitSecurityManager());

		test1_1();
		test1_2();
		test1_3();
		test2_1();
		test2_2();
		test2_3();
		test2_4();
		test2_5();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
	}
	
	private static void test1_1() throws FileNotFoundException {

		String test1 = "quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			
			output.put(testOutput.size() - 2, ">> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test1_1 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test1_1 passed");
				}
			} else {
				System.out.println("test1_1 failed: error");
			}
		}
	}

	private static void test1_2() throws FileNotFoundException {

		String test1 = "quit\n"+"no\n"+"quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			
			output.put(testOutput.size() - 2, ">>>> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test1_2 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test1_2 passed");
				}
			} else {
				System.out.println("test1_2 failed: error");
			}
		}
	}

	private static void test1_3() throws FileNotFoundException {

		String test1 = "rawr\n"+"quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			
			output.put(testOutput.size() - 2, ">> >> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test1_3 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test1_3 passed");
				}
			} else {
				System.out.println("test1_3 failed: error");
			}
		}
	}
	
	private static void test2_1() throws FileNotFoundException {

		String test1 = "new game\n"+"examine cell key\n"+"quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			output.put(testOutput.size() - 4, ">> You can't find a cell key.");
			output.put(testOutput.size() - 3, "The guard walks toward your cell.");
			output.put(testOutput.size() - 2, ">> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test2_1 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test2_1 passed");
				}
			} else {
				System.out.println("test2_1 failed: error");
			}
		}
	}
	
	private static void test2_2() throws FileNotFoundException {

		String test1 = "new game\n"+"pick up cell key\n" +"examine cell key\n"+"quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			output.put(testOutput.size() - 4, ">> A big rusty key on a ring. It looks like it would fit the lock in the cell door.");
			output.put(testOutput.size() - 3, "The guard peers into the cell, checking that the door is secured, then continues on.");
			output.put(testOutput.size() - 2, ">> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test2_2 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test2_2 passed");
				}
			} else {
				System.out.println("test2_2 failed: error");
			}
		}
	}
	
	private static void test2_3() throws FileNotFoundException {

		String test1 = "new game\n"+"examine\n"+"quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			output.put(testOutput.size() - 3, ">> SYSTEM: could not identify a direct object in your input.");
			output.put(testOutput.size() - 2, ">> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test2_3 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test2_3 passed");
				}
			} else {
				System.out.println("test2_3 failed: error");
			}
		}
	}
	
	private static void test2_4() throws FileNotFoundException {

		String test1 = "new game\n"+"examine room\n"+"quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			output.put(testOutput.size() - 6, ">> The prison cell is a cold, dirty place.");
			output.put(testOutput.size() - 5, "The only light in the room filters through the bars in the cell door.");
			output.put(testOutput.size() - 4, "On the ground there is a: cell key.");
			output.put(testOutput.size() - 3, "The guard walks toward your cell.");
			output.put(testOutput.size() - 2, ">> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test2_4 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test2_4 passed");
				}
			} else {
				System.out.println("test2_4 failed: error");
			}
		}
	}
	
	private static void test2_5() throws FileNotFoundException {

		String test1 = "new game\n"+"examine\n"+"quit\n"+"no\n"+"quit\n"+"yes\n";

		HashMap<Integer, String> output = new HashMap<Integer, String>();
		
		boolean passed = true;
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
			passed = false;
		} finally {
			System.setOut(stdout);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("testing.txt"));
			ArrayList<String> testOutput = new ArrayList<String>();
			while (sc.hasNextLine()) {
				testOutput.add(sc.nextLine());
			}
			output.put(testOutput.size() - 3, ">> SYSTEM: could not identify a direct object in your input.");
			output.put(testOutput.size() - 2, ">> Are you sure you want to quit? (y/n)");
			output.put(testOutput.size() - 1, ">>");
			
			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test2_5 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test2_5 passed");
				}
			} else {
				System.out.println("test2_5 failed: error");
			}
		}
	}

	private static void test4() throws FileNotFoundException {
		boolean passed = true;
		passed &= test4_1();
		passed &= test4_2();
		passed &= test4_3();
		if (passed) {
			System.out.println("test4 passed");
		}
	}

	private static boolean test4_1() throws FileNotFoundException {

		String input = "new\n" + "pick up rock\n" + "drop rock\n" + "quit\n"
				+ "yes\n";

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

			output.put(testOutput.size() - 5,
					">> You can't find a rock on the ground.");
			output.put(testOutput.size() - 3,
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
					return true;
				}
			} else {
				System.out.println("test4 failed: error");
			}
		}
		return false;
	}

	private static boolean test4_2() throws FileNotFoundException {

		String input = "new\n" + "pick up key\n" + "drop key\n" + "quit\n"
				+ "yes\n";

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

			output.put(testOutput.size() - 6, ">> You pick up a cell key.");
			output.put(testOutput.size() - 4,
					">> cell key was dropped on the ground.");

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
					return true;
				}
			} else {
				System.out.println("test4 failed: error");
			}
		}
		return false;
	}

	private static boolean test4_3() throws FileNotFoundException {

		String input = "new\n" + "drop key\n" + "drop rock\n" + "quit\n"
				+ "yes\n";

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

			output.put(testOutput.size() - 5, ">> You can't find a key.");
			output.put(testOutput.size() - 3, ">> You can't find a rock.");

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
					return true;
				}
			} else {
				System.out.println("test4 failed: error");
			}
		}
		return false;
	}

	private static void test5() throws FileNotFoundException {
		boolean passed = true;
		passed &= test5_1();
		if (passed) {
			System.out.println("test5 passed");
		}
	}

	private static boolean test5_1() throws FileNotFoundException {

		String input = "new\n" + "lock door\n" + "lock door with key\n"
				+ "open door\n" + "go through door\n" + "unlock door\n"
				+ "open door\n" + "go through door\n" + "quit\n" + "yes\n";

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

			output.put(testOutput.size() - 16,
					">> You need to use a key to lock this cell door.");
			output.put(testOutput.size() - 14, ">> You don't have a key.");
			output.put(testOutput.size() - 12, ">> The door is locked.");
			output.put(testOutput.size() - 10, ">> The cell door is locked.");
			output.put(testOutput.size() - 8,
					">> You need to use a key to unlock the cell door.");
			output.put(testOutput.size() - 6, ">> The door is locked.");
			output.put(testOutput.size() - 4, ">> The cell door is locked.");

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test5 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					return true;
				}
			} else {
				System.out.println("test5 failed: error");
			}
		}
		return false;
	}

	private static void test6() throws FileNotFoundException {
		boolean passed = true;
		passed &= test6_1();
		if (passed) {
			System.out.println("test6 passed");
		}
	}

	private static boolean test6_1() throws FileNotFoundException {

		String input = "new\n" + "pick up key\n" + "lock cell door\n"
				+ "lock cell door with key\n" + "open door\n"
				+ "open cell door\n" + "go through door\n"
				+ "unlock cell door\n" + "wait\n"
				+ "unlock cell door with key\n" + "open door\n"
				+ "go through cell door\n" + "quit\n" + "yes\n";

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

			output.put(testOutput.size() - 36,
					">> You need to use a key to lock this cell door.");
			output.put(testOutput.size() - 34, ">> You lock the cell door.");
			output.put(testOutput.size() - 32, ">> The door is locked.");
			output.put(testOutput.size() - 30, ">> The door is locked.");
			output.put(testOutput.size() - 28, ">> The cell door is locked.");
			output.put(testOutput.size() - 26,
					">> You need to use a key to unlock the cell door.");
			output.put(testOutput.size() - 22, ">> You unlock the cell door.");
			output.put(testOutput.size() - 20, ">> The door swings open.");
			output.put(testOutput.size() - 18,
					">> You walk through the cell door.");

			output.put(
					testOutput.size() - 17,
					"A lone torch flickers next to you, and the hallway stretches off to darkness to the north and south.");
			output.put(testOutput.size() - 16,
					"In the wall next to you is a cell door.");

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test6 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					return true;
				}
			} else {
				System.out.println("test6 failed: error");
			}
		}
		return false;
	}
	
	private static void test7() throws FileNotFoundException {
		//Test winning by waiting for the guard to pass
		String input = "new\n" + "pick up key\n" + "wait\n"
				+ "unlock door with key\n" + "go through cell door\n" + "quit\n" + "y\n";

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
			
			//The expected output for specific lines
			output.put(13,"The guard walks toward your cell.");
			output.put(14,">> Some time goes by.");
			output.put(15,"The guard peers into the cell, checking that the door is secured, then continues on.");
			output.put(18,">> You walk through the cell door.");
			output.put(21,"The guard walks away from your cell.");
			output.put(22,"You escape silently into the shadows.");
			output.put(23,"YOU WON!");
			output.put(testOutput.size() - 1, ">>");

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test7 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test7 passed");
				}
			} else {
				System.out.println("test7 failed: error");
			}
		}
	}

	private static void test8() throws FileNotFoundException {
		//Test unlocking the cell door and getting caught
		String input = "new\n" + "pick up cell key\n"
				+ "unlock cell door with cell key\n" + "quit\n" + "y\n";

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
			
			//The expected output for specific lines
			output.put(13,"The guard walks toward your cell.");
			output.put(14,">> You unlock the cell door.");
			output.put(15,"The guard peers into the cell, checking that the door is secured.");
			output.put(16,"The door swings open.");
			output.put(17,"You have been caught.");
			output.put(18,"YOU LOSE!");
			output.put(testOutput.size() - 1, ">>");

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test8 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test8 passed");
				}
			} else {
				System.out.println("test8 failed: error");
			}
		}
	}
	
	private static void test9() throws FileNotFoundException {
		//Test losing by exiting the cell and being spotted
		String input = "new\n" + "pick up key\n" + "wait\n"
				+ "unlock door with key\n" + "wait\n" + "go through cell door\n" + "quit\n" + "y\n";

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
			
			//The expected output for specific lines
			output.put(13,"The guard walks toward your cell.");
			output.put(14,">> Some time goes by.");
			output.put(15,"The guard peers into the cell, checking that the door is secured, then continues on.");
			output.put(18,">> Some time goes by.");
			output.put(20,">> You walk through the cell door.");
			output.put(23,"The guard turns around.");
			output.put(24,"You step out of your cell in full view of the guard.");
			output.put(25,"You have been caught.");
			output.put(26,"YOU LOSE!");
			output.put(testOutput.size() - 1, ">>");

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test9 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test9 passed");
				}
			} else {
				System.out.println("test9 failed: error");
			}
		}
	}
	
	private static void test10() throws FileNotFoundException {
		//Test winning the game twice in a row
		String input = "new\n" + "pick up key\n" + "wait\n"
				+ "unlock door with key\n" + "go through cell door\n" + "new\n" + "pick up key\n" + "wait\n"
				+ "unlock door with key\n" + "go through cell door\n" + "quit\n" + "y\n";

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
			
			//The expected output for specific lines
			output.put(12,">> You pick up a cell key.");
			output.put(13,"The guard walks toward your cell.");
			output.put(14,">> Some time goes by.");
			output.put(15,"The guard peers into the cell, checking that the door is secured, then continues on.");
			output.put(18,">> You walk through the cell door.");
			output.put(21,"The guard walks away from your cell.");
			output.put(22,"You escape silently into the shadows.");
			output.put(23,"YOU WON!");
			
			output.put(36,">> You pick up a cell key.");
			output.put(37,"The guard walks toward your cell.");
			output.put(38,">> Some time goes by.");
			output.put(39,"The guard peers into the cell, checking that the door is secured, then continues on.");
			output.put(42,">> You walk through the cell door.");
			output.put(45,"The guard walks away from your cell.");
			output.put(46,"You escape silently into the shadows.");
			output.put(47,"YOU WON!");
			
			output.put(testOutput.size() - 1, ">>");

			if (passed) {
				for (Map.Entry<Integer, String> entry : output.entrySet()) {
					if (!testOutput.get(entry.getKey())
							.equals(entry.getValue())) {
						passed = false;
						System.out.println("test10 failed: Line "
								+ entry.getKey());
						System.out.println("\tExpected: " + entry.getValue());
						System.out.println("\tReceived: "
								+ testOutput.get(entry.getKey()));
					}
				}
				if (passed) {
					System.out.println("test10 passed");
				}
			} else {
				System.out.println("test10 failed: error");
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

package jUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestWorld.class, TestAspect.class, TestInteractable.class,
		TestItem.class, TestLocation.class, TestParser.class, TestGame.class,
		TestPlayer.class })
public class AllTests {
	
	// TestWorld must be run first

}

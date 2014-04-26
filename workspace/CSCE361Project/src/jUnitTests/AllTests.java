package jUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAspect.class, TestInteractable.class, TestItem.class,
		TestLocation.class, TestParser.class, TestGame.class })
public class AllTests {

}

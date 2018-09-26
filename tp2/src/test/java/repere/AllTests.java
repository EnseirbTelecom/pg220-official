package repere;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAxe.class, TestCercle.class, TestCouleur.class,
		TestPoint.class, TestRepere.class, TestSegment.class,
		TestTriangle.class })
public class AllTests {

}

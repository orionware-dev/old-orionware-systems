package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import datastructuresintegrationtests.DataStructuresIntegrationTestsSuite;
import datastructuresunittests.DataStructuresUnitTestsSuite;
import designpatternsintegrationtests.DesignPatternsIntegrationTestsSuite;

//@RunWith(ConcurrentSuite.class)
@RunWith(Suite.class)
@SuiteClasses({DataStructuresIntegrationTestsSuite.class,
                DataStructuresUnitTestsSuite.class,
                DesignPatternsIntegrationTestsSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
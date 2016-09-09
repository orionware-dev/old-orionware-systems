package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import datastructuresintegrationtests.DataStructuresIntegrationTestsSuite;
import datastructuresunittests.DataStructuresUnitTestsSuite;

@RunWith(Suite.class)
@SuiteClasses({DataStructuresIntegrationTestsSuite.class,
                DataStructuresUnitTestsSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
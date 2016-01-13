package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coreintegrationtests.CoreIntegrationTestsSuite;
import datastructuresintegrationtests.DataStructuresIntegrationTestsSuite;
import datastructuresunittests.DataStructuresUnitTestsSuite;

@RunWith(Suite.class)
@SuiteClasses({CoreIntegrationTestsSuite.class,
                DataStructuresIntegrationTestsSuite.class,
                DataStructuresUnitTestsSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
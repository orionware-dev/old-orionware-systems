package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coreintegrationtests.CoreIntegrationTestsSuite;
import datastructuresunittests.DataStructuresUnitTestsSuite;

@RunWith(Suite.class)
@SuiteClasses({CoreIntegrationTestsSuite.class,
                DataStructuresUnitTestsSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
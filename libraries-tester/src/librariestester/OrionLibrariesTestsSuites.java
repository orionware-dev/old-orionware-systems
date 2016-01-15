package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coreintegrationtests.CoreIntegrationTestsSuite;
import datastructuresintegrationtests.DataStructuresIntegrationTestsSuite;
import datastructuresservicesintegrationtests.DataStructuresServicesIntegrationTestsSuite;
import datastructuresservicesunittests.DataStructuresServicesUnitTestsSuite;
import datastructuresunittests.DataStructuresUnitTestsSuite;

@RunWith(Suite.class)
@SuiteClasses({CoreIntegrationTestsSuite.class,
                DataStructuresIntegrationTestsSuite.class,
                DataStructuresUnitTestsSuite.class,
                DataStructuresServicesUnitTestsSuite.class,
                DataStructuresServicesIntegrationTestsSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
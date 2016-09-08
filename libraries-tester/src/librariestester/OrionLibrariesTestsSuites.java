package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import datastructuresfacadesintegrationtests.DataStructuresFacadesIntegrationTestsSuite;
import datastructuresintegrationtests.DataStructuresIntegrationTestsSuite;
import datastructuresunittests.DataStructuresUnitTestsSuite;

@RunWith(Suite.class)
@SuiteClasses({DataStructuresIntegrationTestsSuite.class,
                DataStructuresUnitTestsSuite.class,
                DataStructuresFacadesIntegrationTestsSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
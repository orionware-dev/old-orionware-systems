package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coredependencyinjectionintegrationtests.CoreDependencyInjectionIntegrationTestsSuite;
import datastructuresfacadesintegrationtests.DataStructuresFacadesIntegrationTestsSuite;
import datastructuresintegrationtests.DataStructuresIntegrationTestsSuite;
import datastructuresservicesintegrationtests.DataStructuresServicesIntegrationTestsSuite;
import datastructuresservicesunittests.DataStructuresServicesUnitTestsSuite;
import datastructuresunittests.DataStructuresUnitTestsSuite;

@RunWith(Suite.class)
@SuiteClasses({CoreDependencyInjectionIntegrationTestsSuite.class,
                DataStructuresIntegrationTestsSuite.class,
                DataStructuresUnitTestsSuite.class,
                DataStructuresServicesUnitTestsSuite.class,
                DataStructuresServicesIntegrationTestsSuite.class,
                DataStructuresFacadesIntegrationTestsSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
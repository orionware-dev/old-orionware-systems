package librariestester;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coreintegrationtests.CoreTestSuite;
import datastructuresfacadesintegrationtests.DataStructuresFacadesTestSuite;
import datastructuresintegrationtests.DataStructuresTestSuite;
import datastructuresservicesintegrationtests.DataStructuresServicesTestSuite;

@RunWith(Suite.class)
@SuiteClasses({CoreTestSuite.class,
                DataStructuresTestSuite.class,
                DataStructuresFacadesTestSuite.class,
                DataStructuresServicesTestSuite.class})
public class OrionLibrariesTestsSuites
{
    
}
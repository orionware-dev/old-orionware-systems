package coredependencyinjectionfacadesintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coredependencyinjectionfacadesintegrationtests.dependencyinjection.DependencyInjectionTest;
import coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.ServiceDependencyInjectionTest;

@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class,
                ServiceDependencyInjectionTest.class})
public class CoreDependencyInjectionFacadesIntegrationTestsSuite
{
    
}
package coredependencyinjectionintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coredependencyinjectionintegrationtests.dependencyinjection.DependencyInjectionTest;
import coredependencyinjectionintegrationtests.servicedependencyinjection.ServiceDependencyInjectionTest;

@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class,
                ServiceDependencyInjectionTest.class})
public class CoreDependencyInjectionIntegrationTestsSuite
{
    
}
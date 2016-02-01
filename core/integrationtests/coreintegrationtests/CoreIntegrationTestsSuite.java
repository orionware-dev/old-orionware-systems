package coreintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coreintegrationtests.dependencyinjection.DependencyInjectionTest;
import coreintegrationtests.servicedependencyinjection.ServiceDependencyInjectionTest;

@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class,
                ServiceDependencyInjectionTest.class})
public class CoreIntegrationTestsSuite
{
    
}
package coreintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coreintegrationtests.dependencyinjection.DependencyInjectionTest;
import coreintegrationtests.servicedependencyinjection.ServiceDependencyInjectionTest;
import coreintegrationtests.taskdependencyinjection.TaskDependencyInjectionTest;

@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class,
                ServiceDependencyInjectionTest.class,
                TaskDependencyInjectionTest.class})
public class CoreIntegrationTestsSuite
{
    
}
package coreintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import coreintegrationtests.dependencyinjection.DependencyInjectionTest;

@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class})
public class CoreIntegrationTestsSuite
{
    
}
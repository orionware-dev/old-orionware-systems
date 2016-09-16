package designpatternsintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import designpatternsintegrationtests.dependencyinjection.DependencyInjectionTest;
import designpatternsintegrationtests.pipeline.PipelineTest;
import designpatternsintegrationtests.propertydependencyinjection.PropertyDependencyInjectionTest;

//@RunWith(ConcurrentSuite.class)
@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class,
                PropertyDependencyInjectionTest.class,            
                PipelineTest.class})
public class DesignPatternsIntegrationTestsSuite
{

}
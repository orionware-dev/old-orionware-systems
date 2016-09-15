package designpatternsintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import designpatternsintegrationtests.dependencyinjection.DependencyInjectionTest;
import designpatternsintegrationtests.pipeline.PipelineTest;

//@RunWith(ConcurrentSuite.class)
@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class,
                PipelineTest.class})
public class DesignPatternsIntegrationTestsSuite
{

}
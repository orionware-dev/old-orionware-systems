package datastructuresintegrationtests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import datastructuresintegrationtests.annotationinstantiation.AnnotationInstantiationTest;
import datastructuresintegrationtests.dependencyinjection.DependencyInjectionTest;

@RunWith(Suite.class)
@SuiteClasses({DependencyInjectionTest.class,
                AnnotationInstantiationTest.class})
public class DataStructuresIntegrationTestsSuite
{

}
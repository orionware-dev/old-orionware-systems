package designpatternsintegrationtests.dependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.facades.sets.factory.SetFactoryFacade;
import datastructures.facades.sets.factory.impl.SetFactoryFacadeImpl;
import datastructures.sets.OrionConcurrentSet;
import designpatterns.DesignPatternsObject;
import designpatterns.configuration.DesignPatternsLibraryConfiguration;

public class DependencyInjectionTest extends DesignPatternsObject
{
    @Before
    public void setUp() throws Exception
    {

    }


    @Test
    public void testDependencyInjection()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Running designpatternsintegrationtests.dependencyinjection.TestClass1...", testClass1.testThisClassIsRunning());
        Assert.assertEquals("Running designpatternsintegrationtests.dependencyinjection.TestClass2...", testClass1.testTestClass2IsRunning());
    }
}
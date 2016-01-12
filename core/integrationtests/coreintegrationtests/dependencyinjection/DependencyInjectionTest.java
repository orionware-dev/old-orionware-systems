package coreintegrationtests.dependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import core.OrionObject;

public class DependencyInjectionTest// extends OrionObject
{
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    
    @Test
    public void testDependencyInjection()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Running coreintegrationtests.dependencyinjection.TestClass1...", testClass1.testThisClassIsRunning());
        Assert.assertEquals("Running coreintegrationtests.dependencyinjection.TestClass2...", testClass1.testTestClass2IsRunning());
        Assert.assertEquals("Running coreintegrationtests.dependencyinjection.TestClass3...", testClass1.testTestClass3IsRunning());
    }
}
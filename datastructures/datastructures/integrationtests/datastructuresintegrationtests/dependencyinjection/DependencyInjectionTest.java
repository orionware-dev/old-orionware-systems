package datastructuresintegrationtests.dependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import datastructures.DataStructuresObject;

public class DependencyInjectionTest extends DataStructuresObject
{
    @Before
    public void setUp() throws Exception
    {

    }


    @Test
    public void testDependencyInjection()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Running datastructuresintegrationtests.dependencyinjection.TestClass1...", testClass1.testThisClassIsRunning());
        Assert.assertEquals("Running datastructuresintegrationtests.dependencyinjection.TestClass2...", testClass1.testTestClass2IsRunning());
    }
}
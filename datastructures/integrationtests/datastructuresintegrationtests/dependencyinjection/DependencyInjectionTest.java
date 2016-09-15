package datastructuresintegrationtests.dependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import computation.annotation.Concurrency;
import datastructures.DataStructuresObject;
import tester.ConcurrentJUnitRunner;

@RunWith(ConcurrentJUnitRunner.class)
@Concurrency()
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
        Assert.assertEquals("Running datastructuresintegrationtests.dependencyinjection.TestClass3...", testClass1.testTestClass3IsRunningInsideClass2());
        Assert.assertEquals("Running datastructuresintegrationtests.dependencyinjection.impl.TestClass4Impl...", testClass1.testTestClass4IsRunningInsideClass3());
        Assert.assertEquals("Running datastructuresintegrationtests.dependencyinjection.impl.TestClass4Impl...", testClass1.testTestClass4TempIsRunningInsideClass3());
    }
}
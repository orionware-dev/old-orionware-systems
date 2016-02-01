package coreintegrationtests.taskdependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskDependencyInjectionTest
{
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    
    @Test
    public void testDependencyInjection()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Running coreintegrationtests.taskdependencyinjection.TestClass1...", testClass1.testThisClassIsRunning());
        Assert.assertEquals("Running coreintegrationtests.taskdependencyinjection.TestClass2...", testClass1.testTestClass2IsRunning());
        Assert.assertEquals("Running coreintegrationtests.taskdependencyinjection.impl.tasks.TestTask...", testClass1.testTestTaskIsRunning());
    }
}
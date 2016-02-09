package coredependencyinjectionintegrationtests.dependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
        Assert.assertEquals("Running coredependencyinjectionintegrationtests.dependencyinjection.TestClass1...", testClass1.testThisClassIsRunning());
        Assert.assertEquals("Running coredependencyinjectionintegrationtests.dependencyinjection.TestClass2...", testClass1.testTestClass2IsRunning());
        Assert.assertEquals("Running coredependencyinjectionintegrationtests.dependencyinjection.TestClass3...", testClass1.testTestClass3IsRunning());
    }
}
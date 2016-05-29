package coredependencyinjectionfacadesintegrationtests.servicedependencyinjection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceDependencyInjectionTest
{
    @Before
    public void setUp() throws Exception
    {
        
    }
    
    
    @Test
    public void testDependencyInjection()
    {
        TestClass1 testClass1 = new TestClass1();
        Assert.assertEquals("Running coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.TestClass1...", testClass1.testThisClassIsRunning());
        Assert.assertEquals("Running coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.TestClass2...", testClass1.testTestClass2IsRunning());
        Assert.assertEquals("Running coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.impl.TestServiceImpl...", testClass1.testTestServiceIsRunning());
    }
}
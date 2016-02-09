package coredependencyinjectionintegrationtests.servicedependencyinjection;

import core.OrionObject;
import core.dependencyinjection.Injector;

public class TestClass1 extends OrionObject
{
    private TestClass2 testClass2;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coredependencyinjectionintegrationtests.servicedependencyinjection.TestClass1...";
    }
    
    
    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }
    
    
    public String testTestServiceIsRunning()
    {
        return testClass2.testTestServiceIsRunning();
    }
    
    
    @Injector(ID = "coredependencyinjectionintegrationtests.servicedependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }
}
package coredependencyinjectionintegrationtests.dependencyinjection;

import core.OrionObject;
import core.dependencyinjection.Injector;

public class TestClass1 extends OrionObject
{
    private TestClass2 testClass2;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coredependencyinjectionintegrationtests.dependencyinjection.TestClass1...";
    }
    
    
    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }
    
    
    public String testTestClass3IsRunning()
    {
        return testClass2.testTestClass3IsRunning();
    }
    
    
    @Injector(ID = "coredependencyinjectionintegrationtests.dependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }
}
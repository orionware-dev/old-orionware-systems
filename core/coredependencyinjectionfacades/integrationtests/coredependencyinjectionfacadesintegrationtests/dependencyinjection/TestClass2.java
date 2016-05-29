package coredependencyinjectionfacadesintegrationtests.dependencyinjection;

import core.OrionObject;
import core.dependencyinjection.Injector;

public class TestClass2 extends OrionObject
{
    private TestClass3 testClass3;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coredependencyinjectionfacadesintegrationtests.dependencyinjection.TestClass2...";
    }
    
    
    public String testTestClass3IsRunning()
    {
        return testClass3.testThisClassIsRunning();
    }
    
    
    @Injector(ID = "coredependencyinjectionfacadesintegrationtests.dependencyinjection.TestClass3")
    private void setTestClass3(TestClass3 testClass3)
    {
        this.testClass3 = testClass3;
    }
}
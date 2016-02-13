package coredependencyinjectionintegrationtests.servicedependencyinjection;

import core.OrionObject;
import core.dependencyinjection.service.ServiceInjector;

public class TestClass2 extends OrionObject
{
    private TestService testService;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coredependencyinjectionintegrationtests.servicedependencyinjection.TestClass2...";
    }
    
    
    public String testTestServiceIsRunning()
    {
        return testService.testThisClassIsRunning();
    }
    
    
    @ServiceInjector(ID = "coredependencyinjectionintegrationtests.servicedependencyinjection.TestService")
    private void setTestService(TestService testService)
    {
        this.testService = testService;
    }
}
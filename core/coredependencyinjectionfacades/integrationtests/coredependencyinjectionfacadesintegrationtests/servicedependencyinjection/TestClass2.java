package coredependencyinjectionfacadesintegrationtests.servicedependencyinjection;

import core.OrionObject;
import core.dependencyinjection.service.ServiceInjector;

public class TestClass2 extends OrionObject
{
    private TestService testService;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.TestClass2...";
    }
    
    
    public String testTestServiceIsRunning()
    {
        return testService.testThisClassIsRunning();
    }
    
    
    @ServiceInjector(ID = "coredependencyinjectionfacadesintegrationtests.servicedependencyinjection.TestService")
    private void setTestService(TestService testService)
    {
        this.testService = testService;
    }
}
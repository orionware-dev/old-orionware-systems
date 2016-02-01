package coreintegrationtests.servicedependencyinjection;

import core.OrionObject;
import core.servicedependencyinjection.ServiceInjector;

public class TestClass2 extends OrionObject
{
    private TestService testService;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.servicedependencyinjection.TestClass2...";
    }
    
    
    public String testTestServiceIsRunning()
    {
        return testService.testThisClassIsRunning();
    }
    
    
    @ServiceInjector(ID = "coreintegrationtests.servicedependencyinjection.TestService")
    private void setTestService(TestService testService)
    {
        this.testService = testService;
    }
}
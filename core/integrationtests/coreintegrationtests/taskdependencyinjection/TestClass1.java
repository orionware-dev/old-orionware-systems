package coreintegrationtests.taskdependencyinjection;

import core.OrionObject;
import core.dependencyinjection.Injector;
import core.servicedependencyinjection.ServiceInjector;
import coreintegrationtests.taskdependencyinjection.impl.TestServiceImpl;

public class TestClass1 extends OrionObject
{
    private TestServiceImpl testService;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.taskdependencyinjection.TestClass1...";
    }
    
    
    public String testTestServiceIsRunning()
    {
        return testService.testThisClassIsRunning();
    }
    
    
    public String testTestTaskIsRunning()
    {
        return testService.testTestTaskIsRunning();
    }
    
    
    @ServiceInjector(ID = "coreintegrationtests.taskdependencyinjection.TestService")
    private void setTestService(TestServiceImpl testService)
    {
        this.testService = testService;
    }
}
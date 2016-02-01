package coreintegrationtests.taskdependencyinjection;

import core.OrionObject;
import core.dependencyinjection.Injector;

public class TestClass1 extends OrionObject
{
    private TestClass2 testClass2;
    
    
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.taskdependencyinjection.TestClass1...";
    }
    
    
    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }
    
    
    public String testTestTaskIsRunning()
    {
        return testClass2.testTestTaskIsRunning();
    }
    
    
    @Injector(ID = "coreintegrationtests.taskdependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }
}
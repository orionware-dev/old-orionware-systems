package coreintegrationtests.dependencyinjection;

import core.OrionObject;
import core.dependencyinjection.Injector;

public class TestClass2 extends OrionObject
{
    private TestClass3 testClass3;
    
    
    public TestClass2()
    {
        this(null);
    }
    
    
    @Injector
    public TestClass2(TestClass3 testClass3)
    {
        
    }
    
    
    public String testThisClassIsRunning()
    {
        return "Running coreintegrationtests.dependencyinjection.TestClass2...";
    }
    
    
    public String testTestClass3IsRunning()
    {
        return testClass3.testThisClassIsRunning();
    }
    
    
    //@Injector(ID = "coreintegrationtests.dependencyinjection.TestClass3")
    private void setTestClass3(TestClass3 testClass3)
    {
        this.testClass3 = testClass3;
    }
}
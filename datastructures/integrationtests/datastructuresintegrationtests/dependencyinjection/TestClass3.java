package datastructuresintegrationtests.dependencyinjection;

import datastructures.DataStructuresObject;
import dependencyinjection.annotation.InjectorImpl;

public class TestClass3 extends DataStructuresObject
{
    private TestClass4 testClass4;
    @InjectorImpl
    private TestClass4 testClass4Temp;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresintegrationtests.dependencyinjection.TestClass3...";
    }
    
    
    public String testTestClass4IsRunning()
    {
        return testClass4.testThisClassIsRunning();
    }
    
    
    public String testTestClass4TempIsRunning()
    {
        return testClass4Temp.testThisClassIsRunning();
    }
    
    
    @InjectorImpl
    private void setTestClass4(TestClass4 testClass4)
    {
        this.testClass4 = testClass4;
    }
}
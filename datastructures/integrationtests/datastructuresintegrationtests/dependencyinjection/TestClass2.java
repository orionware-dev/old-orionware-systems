package datastructuresintegrationtests.dependencyinjection;

import datastructures.DataStructuresObject;
import dependencyinjection.annotation.Injector;

public class TestClass2 extends DataStructuresObject
{
    @Injector
    private TestClass3 testClass3;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresintegrationtests.dependencyinjection.TestClass2...";
    }
    
    
    public String testTestClass4IsRunningInsideClass3()
    {
        return testClass3.testTestClass4IsRunning();
    }
    
    
    public String testTestClass4TempIsRunningInsideClass3()
    {
        return testClass3.testTestClass4TempIsRunning();
    }
    
    
    public String testTestClass3IsRunning()
    {
        return testClass3.testThisClassIsRunning();
    }
}
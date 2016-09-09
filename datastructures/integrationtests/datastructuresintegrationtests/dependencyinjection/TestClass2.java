package datastructuresintegrationtests.dependencyinjection;

import datastructures.DataStructuresObject;
import dependencyinjection.annotations.Injector;

public class TestClass2 extends DataStructuresObject
{
    @Injector
    private TestClass3 testClass3;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresintegrationtests.dependencyinjection.TestClass2...";
    }
    
    
    public String testTestClass3IsRunning()
    {
        return testClass3.testThisClassIsRunning();
    }
}
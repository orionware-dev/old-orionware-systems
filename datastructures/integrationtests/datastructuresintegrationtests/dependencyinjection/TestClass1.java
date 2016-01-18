package datastructuresintegrationtests.dependencyinjection;

import core.dependencyinjection.Injector;
import datastructures.DataStructuresObject;

public class TestClass1 extends DataStructuresObject
{
    private TestClass2 testClass2;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresintegrationtests.dependencyinjection.TestClass1...";
    }
    
    
    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }
    
    
    @Injector(ID = "datastructuresintegrationtests.dependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }
}
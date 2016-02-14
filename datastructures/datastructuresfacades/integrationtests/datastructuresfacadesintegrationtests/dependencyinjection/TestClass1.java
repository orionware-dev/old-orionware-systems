package datastructuresfacadesintegrationtests.dependencyinjection;

import core.dependencyinjection.Injector;
import datastructures.DataStructuresObject;

public class TestClass1 extends DataStructuresObject
{
    private TestClass2 testClass2;
    
    
    public String testThisClassIsRunning()
    {
        return "Running datastructuresfacadesintegrationtests.dependencyinjection.TestClass1...";
    }
    
    
    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }
    
    
    public TestClass2 getTestClass2()
    {
        return testClass2;
    }
    
    
    @Injector(ID = "datastructuresfacadesintegrationtests.dependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }
}
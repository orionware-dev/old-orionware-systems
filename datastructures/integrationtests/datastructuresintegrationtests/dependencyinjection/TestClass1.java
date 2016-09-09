package datastructuresintegrationtests.dependencyinjection;

import datastructures.DataStructuresObject;
import dependencyinjection.annotations.Injector;

public class TestClass1 extends DataStructuresObject
{
    @Injector
    private TestClass2 testClass2;


    public String testThisClassIsRunning()
    {
        return "Running datastructuresintegrationtests.dependencyinjection.TestClass1...";
    }


    public String testTestClass2IsRunning()
    {
        return testClass2.testThisClassIsRunning();
    }
    
    
    public String testTestClass3IsRunningInsideClass2()
    {
        return testClass2.testTestClass3IsRunning();
    }
    
    
    public String testTestClass4IsRunningInsideClass3()
    {
        return testClass2.testTestClass4IsRunningInsideClass3();
    }
    
    
    public String testTestClass4TempIsRunningInsideClass3()
    {
        return testClass2.testTestClass4TempIsRunningInsideClass3();
    }


    /*@Injector(ID = "datastructuresintegrationtests.dependencyinjection.TestClass2")
    private void setTestClass2(TestClass2 testClass2)
    {
        this.testClass2 = testClass2;
    }*/
}